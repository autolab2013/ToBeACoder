import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashSet;


public class A1 {
	public static void main(String args[]){
//		stutteredFlatten(3, "abc", "de", "f");
//		printLineReverse(args[0]);
		interact();
	}
	/**
	 * Implement method print(int n) that prints all of the numbers in range [0; n-1]
	 * to the console in ascending order.
	 * @param n
	 */
	public void print(int n){
		for(int i=0;i<n;i++){
			System.out.println(i);
		}
	}
	
	/**
	 * Implement method stutteredFlatten(int n, String... list) that returns
	 * a String of the concatenation of n copies of each item of list in the order as given.
	 */
	public static String stutteredFlatten(int n, String ...strings){
		String result = "";
		for(int s=0;s<strings.length;s++){
			for(int i=0;i<n;i++){
				result += strings[s];
			}
		}return result;
	}
	
	/** 
	 * Write a program that reads in a file from the file system and outputs its lines to the
	 * console in reverse order. The filename is given from the command line; that is, as an argument
	 * to the main method of the program.
	 * 
	 * have to specific path: "src/A1.java"
	 */
	public static void printLineReverse(String file){
		Path filename = Paths.get(file);
		Charset charset = Charset.forName("US-ASCII");
		ArrayList<String> line_buffer = new ArrayList<String>();
		try(BufferedReader reader = Files.newBufferedReader(filename, charset)){
			String line = null;
			while((line = reader.readLine()) != null){
				line_buffer.add(line);
			}
		}catch(IOException e){
			System.err.format("IOException: %s%n", e);
		}for(int i=line_buffer.size()-1; i>=0; i--){
			System.out.println(line_buffer.get(i));
		}
	}
	
	/**
	 * Implement method interact() that reads the following inputs from the console,
	 * i.e., entered by the user from keyboard:
	 *  The first line is an integer n.
	 *  The next n lines are strings.
	 *  The last line is an integer k.
	 * With these inputs, call the method stutteredFlatten in Problem 4 that concatenates k copies
	 * of the given strings in reverse order.
	 * If the user enters a value in an incorrect format, e.g., entering a string instead of an integer, keep
	 * asking the user to reenter the value.
	 */
	public static void interact(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int line_num = 0;
		int k;
		System.out.println("Please enter the number of lines: ");
		while(true){
			String num_tmp = "";
			try{
				num_tmp = reader.readLine();
			}catch(IOException e){
				System.out.println("IO exception");
			}
//			can use try catch, performance not good
//			try{
//				line_num = Integer.parseInt(num_tmp);
//				break;
//			}catch(NumberFormatException nfe){
//				System.out.println("invalid input, int line number is expected");
//			}
			if(isNumeric(num_tmp)){
				line_num = Integer.parseInt(num_tmp);
				break;
			}else
				System.out.println("invalid input, int line number is expected");
		}String[] input_str = new String[line_num];
		for(int i=0;i<line_num;i++){
			System.out.println("input "+(line_num-i)+" lines strings left: ");
			try{
				input_str[i] = reader.readLine();
			}catch(IOException e){
				System.out.println("IO exception");
			}
		}
		while(true){
			String buf = "";
			System.out.println("input k: ");
			try{
				buf = reader.readLine();
			}catch(IOException e){
				System.out.println("IO exception");
			}System.out.println("buf: "+buf);
			if(isNumeric(buf)){
				k = Integer.parseInt(buf);
				System.out.println(stutteredFlatten(k, input_str));
				break;
			}else
				System.out.println("invalid input, int line number is expected");
		}
		
		
	}
	
	private static boolean isNumeric(String str){
		  NumberFormat formatter = NumberFormat.getInstance();
		  ParsePosition pos = new ParsePosition(0);
		  formatter.parse(str, pos);
		  return str.length() == pos.getIndex();
	}
	
	/**
	 * Implement method findUnionIntersection(int[] a, int[] b) that takes
	 * two integer arrays and returns a new object containing both the union and the intersection of the
	 * arrays. Each of the two arrays can be assumed not to contain duplicate elements; that is, each
	 * array represents a set. The order of the elements in the resulting array does not matter, but the
	 * array should also represent a set.
	 */
	public static MySet findUnionIntersection(int[] a, int[] b){
		MySet result = new MySet(a, b);
		return result;
	}
	
}
