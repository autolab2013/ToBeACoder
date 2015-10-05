import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by YunongLiu on 9/23/2015.
 */
public class FileIO {
    public FileIO() {}

    public void readAndwrite(String input, String output) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream(input);
            out = new FileOutputStream(output);

            int c;
            while((c=in.read()) != -1 ) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(out != null) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
