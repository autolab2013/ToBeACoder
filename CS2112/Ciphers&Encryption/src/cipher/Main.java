package cipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Parse arguments. argPos keeps track of argument position.
        Main cr = new Main();
        int pos = 0;
        try {
            // Parse cipher type.
            pos = cr.parseCipherType(args, pos);
            // Parse cipher function.
            pos = cr.parseCipherFunction(args, pos);
            // Parse output option(s).
            pos = cr.parseOutputOptions(args, pos);

            // Check if arguments are exhausted.
            if (pos != args.length)
                throw new IllegalArgumentException("Invalid command.");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Usage: CipherRunner <cipher_type> <cipher_function> <output_options>");
            return;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Insufficient number of arguments.");
            System.out.println("Usage: CipherRunner <cipher_type> <cipher_function> <output_options>");
            return;
        }

        // Process command.
        try {
            cr.run();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
        catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    private CipherFactory cf;

    private CipherType type;

    protected enum CipherType {
        mono, caesar, random, cracked, vig, vigL, route, rsa, rsaPr, rsaPu;

        public boolean isRSA() {
            return !(this == rsa | this == rsaPr | this == rsaPu);
        }
    }

    /*
     * Cipher-type related variables. Store parsed options before doing work, in
     * case the command is invalid. Therefore, some of these may be undefined.
     */
    private String inFilename;
    private int shftParam;
    private List<String> sampleFiles, encryptedFiles;

    protected enum CipherFunctionType {
        encryptMessage, encryptFile, decryptMessage, decryptFile
    };

    private CipherFunctionType cipherFunction;
    private String functionString;

    protected enum OutputType {
        printToConsole, printToFile, saveToFile, savePubKeyToFile
    };

    private List<OutputType> outputOptions;
    private List<String> outFilenames;

    private String vigAlph;
    private int width;

    private Main() {
        this.cf = new CipherFactory();
    }

    /**
     * Set up the cipher type based on the options found in args starting at
     * position pos, and return the index into args just past any cipher type
     * options.
     */
    private int parseCipherType(String[] args, int pos)
            throws IllegalArgumentException {
        String cmdFlag = args[pos++];
        switch (cmdFlag) {
        case "--monosub":
            type = CipherType.mono;
            // Read cipher file.
            inFilename = args[pos++];
            break;
        case "--caesar":
            type = CipherType.caesar;
            try {
                shftParam = Integer.parseInt(args[pos++]);
            }
            catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Shift parameter for the Caesar cipher is not a number.");
            }
            break;
        case "--random":
            type = CipherType.random;
            break;
        case "--crackedCaesar":
            type = CipherType.cracked;
            sampleFiles = new LinkedList<String>();
            encryptedFiles = new LinkedList<String>();
            String typeFlag = args[pos++];
            boolean hasNext = true;
            while (hasNext) {
                switch (typeFlag) {
                case "-t":
                    sampleFiles.add(args[pos++]);
                    break;
                case "-c":
                    encryptedFiles.add(args[pos++]);
                    break;
                default:
                    hasNext = false;
                    pos -= 2;
                }
                typeFlag = args[pos++];
            }
			break;
        case "--vigenere":
            type = CipherType.vig;
            vigAlph = args[pos++];
            break;
        case "--vigenereL":
            type = CipherType.vigL;
            // Read save file
            inFilename = args[pos++];
            break;
        case "--route":
            type = CipherType.route;
            width = Integer.parseInt(args[pos++]);
            break;
        case "--rsa":
            type = CipherType.rsa;
            break;
        case "--rsaPr":
            type = CipherType.rsaPr;
            // Read cipher file.
            inFilename = args[pos++];
            break;
        case "--rsaPu":
            type = CipherType.rsaPu;
            // Read cipher file.
            inFilename = args[pos++];
            break;
        default:
            throw new IllegalArgumentException("Unrecognized cipher type: "
                    + cmdFlag);
        }
        return pos;
    }

    /**
     * Parse the operations to be performed by the program from the command-line
     * arguments in args starting at position pos. Return the index into args
     * just past the parsed arguments.
     */
    private int parseCipherFunction(String[] args, int pos)
            throws IllegalArgumentException {
        // Check if arguments are exhausted.
        if (pos == args.length) return pos;

        String cmdFlag;
        loop: while (pos < args.length) {
            switch (cmdFlag = args[pos++]) {
            case "--em":
                cipherFunction = CipherFunctionType.encryptMessage;
                functionString = args[pos++];
                break;
            case "--ef":
                cipherFunction = CipherFunctionType.encryptFile;
                functionString = args[pos++];
                break;
            case "--dm":
                if (type == CipherType.rsaPu) // RSA encryption only
                    throw new IllegalArgumentException("Incompatible function; private key expected: "
                            + cmdFlag);
                cipherFunction = CipherFunctionType.decryptMessage;
                functionString = args[pos++];
                break;
            case "--df":
                if (type == CipherType.rsaPu) // RSA encryption only
                    throw new IllegalArgumentException("Incompatible function; private key expected: "
                            + cmdFlag);
                cipherFunction = CipherFunctionType.decryptFile;
                functionString = args[pos++];
                break;
            default:
                pos--;
                break loop; // done with the option loop
            }
        }
        return pos;
    }

    /**
     * Parse options for output, starting within {@code args} at index
     * {@code argPos}. Return the index in args just past such options.
     */
    private int parseOutputOptions(String[] args, int pos)
            throws IllegalArgumentException {
        // Check if arguments are exhausted.
        if (pos == args.length) return pos;

        this.outputOptions = new LinkedList<OutputType>();
        this.outFilenames = new LinkedList<String>();

        String cmdFlag;
        while (pos < args.length) {
            switch (cmdFlag = args[pos++]) {
            case "--print":
                outputOptions.add(OutputType.printToConsole);
                // dummy filename
                outFilenames.add("");
                break;
            case "--out":
                outputOptions.add(OutputType.printToFile);
                outFilenames.add(args[pos++]);
                break;
            case "--save":
                outputOptions.add(OutputType.saveToFile);
                outFilenames.add(args[pos++]);
                break;
            case "--savePu":
                if (!type.isRSA()) // not RSA
                    throw new IllegalArgumentException("Incompatible output option; public-key cipher expected: "
                            + cmdFlag);
                outputOptions.add(OutputType.savePubKeyToFile);
                outFilenames.add(args[pos++]);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized output option: "
                        + cmdFlag);
            }
        }

        return pos;
    }

    public static final int ALPHABET_SIZE = 26;

    private void run() throws FileNotFoundException, IOException,
            InputMismatchException {
        // Prepare cipher.
        Cipher cipher;
        BufferedReader br;
        switch (type) {
        case mono:
            // Read file content.
            br = new BufferedReader(new FileReader(inFilename));
            String encrAlp = br.readLine();
            br.close();

            // Check content format.
            int len = encrAlp.length();
            if (len != ALPHABET_SIZE)
                throw new InputMismatchException("Cipher file does not contain a valid key.");
            boolean[] usedChars = new boolean[ALPHABET_SIZE];
            char[] encr = encrAlp.toCharArray();
            for (int i = 0; i < len; i++) {
                if (encr[i] >= 'a' && encr[i] <= 'z')
                // Convert to uppercase.
                    encr[i] -= 32;
                if (encr[i] >= 'A' && encr[i] <= 'Z') {
                    int index = encr[i] - 'A';
                    if (usedChars[index])
                        throw new InputMismatchException("Invalid cipher key with duplicate character: "
                                + encr[i]);
                    else usedChars[index] = true;
                }
                else throw new InputMismatchException("Unrecognized character in the cipher key: "
                        + encr[i]);
            }

            cipher = cf.getMonoCipher(encrAlp);
            break;
        case caesar:
            cipher = cf.getCaesarCipher(shftParam);
            break;
        case random:
            cipher = cf.getRandomSubstitutionCipher();
            break;
        case cracked:
            FrequencyAnalyzer sample = analyzeFrequency(sampleFiles);
            FrequencyAnalyzer encrypted = analyzeFrequency(encryptedFiles);
            cipher = FrequencyAnalyzer.getCipher(sample, encrypted);
            break;
        case route:
            cipher = cf.getRouteCipher(width);
            break;
        case rsa:
            cipher = cf.getRSACipher();
            break;
        case vig:
            cipher = cf.getVigenereCipher(this.vigAlph);
            break;
        case vigL:
            br = new BufferedReader(new FileReader(inFilename));
            cipher = cf.getVigenereCipher(br.readLine());
            br.close();
            break;
        case rsaPr: {
            // Read file content.
            br = new BufferedReader(new FileReader(inFilename));
            BigInteger n, e, d;
            try {
                n = new BigInteger(br.readLine());
                e = new BigInteger(br.readLine());
                d = new BigInteger(br.readLine());
            }
            catch (NumberFormatException nfe) {
                br.close();
                throw new InputMismatchException("Integer key expected.");
            }
            br.close();
            cipher = cf.getRSACipher(n, e, d);
            break;
        }
        case rsaPu: {
            // Read file content.
            br = new BufferedReader(new FileReader(inFilename));
            BigInteger n, e;
            try {
                try {
                    n = new BigInteger(br.readLine());
                    e = new BigInteger(br.readLine());
                }
                catch (NumberFormatException nfe) {
                    throw new InputMismatchException("Integer key expected.");
                }
            }
            finally {
                br.close();
            }
            // Special case: encryption only.
            EncryptionCipher ec = cf.getRSACipher(n, e, null); // RSA cipher in
            // 'Public
            // key' mode
            Iterator<String> ofItr = outFilenames.iterator();
            for (Iterator<OutputType> ooItr = outputOptions.iterator(); ooItr.hasNext();) {
                OutputType outputOption = ooItr.next();
                String outFilename = ofItr.next();
                processEncryptionCipher(ec, outputOption, outFilename);
            }
            return;
        }
        default:
            // should not reach here
            throw new RuntimeException("Cipher type not specified.");
        }

        Iterator<String> ofItr = outFilenames.iterator();
        for (Iterator<OutputType> ooItr = outputOptions.iterator(); ooItr.hasNext();) {
            OutputType outputOption = ooItr.next();
            String outFilename = ofItr.next();
            processCipher(cipher, outputOption, outFilename);
        }
    }

    private FrequencyAnalyzer analyzeFrequency(List<String> filenames)
            throws FileNotFoundException, IOException {
        FrequencyAnalyzer result = new FrequencyAnalyzer();
        for (String filename : filenames) {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            for (int c = br.read(); c != -1; c = br.read())
                result.addChar((char) c);
            br.close();
        }
        return result;
    }

    private void processEncryptionCipher(EncryptionCipher ec,
            OutputType outputOption, String outFilename)
            throws FileNotFoundException, IOException {
        OutputStream out = getOutputTarget(outputOption, outFilename);
        switch (outputOption) {
        case printToConsole:
        case printToFile:
            processEncrypt(ec, out);
            break;
        case saveToFile:
        case savePubKeyToFile:
            ec.save(out);
        }
    }

    private void processCipher(Cipher cipher, OutputType outputOption,
            String outFilename) throws FileNotFoundException, IOException {
        OutputStream out = getOutputTarget(outputOption, outFilename);
        switch (outputOption) {
        case printToConsole:
        case printToFile:
            processEncrypt(cipher, out);
            processDecrypt(cipher, out);
            break;
        case saveToFile:
            cipher.save(out);
            break;
        case savePubKeyToFile:
            cipher.save(out);
            break;
        }
    }

    private OutputStream getOutputTarget(OutputType outputOption,
            String outFilename) throws FileNotFoundException {
        if (outputOption == OutputType.printToConsole)
            return System.out;
        else return new FileOutputStream(outFilename);
    }

    private void processEncrypt(EncryptionCipher ec, OutputStream out)
            throws IOException {
        switch (cipherFunction) {
        case encryptMessage:
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            bw.write(ec.encrypt(functionString));
            bw.close();
            break;
        case encryptFile:
            InputStream in = new FileInputStream(functionString);
            ec.encrypt(in, out);
            break;
        default:
            assert false;
        }
    }

    private void processDecrypt(DecryptionCipher cipher, OutputStream out)
            throws IOException {
        assert cipher.decrypt(((Cipher) cipher).encrypt("CAT")).equals("CAT");
        switch (cipherFunction) {
        case decryptMessage:
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            bw.write(cipher.decrypt(functionString));
            bw.close();
            break;
        case decryptFile:
            InputStream in = new FileInputStream(functionString);
            cipher.decrypt(in, out);
            break;
        default:
            assert false;
        }
    }
}
