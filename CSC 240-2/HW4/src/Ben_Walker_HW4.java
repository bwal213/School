import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Ben
 *
 */
public class Ben_Walker_HW4 {

	/**
	 * 
	 */
	public Ben_Walker_HW4() {
		// TODO Auto-generated constructor stub
	}
	
	public static int pallindromeCount = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.print("\nPlease enter the exact path of the file you wish to open: ");
		String fileAddr = kb.nextLine();
		
		File f = new File(fileAddr);
		try{
			if(f.exists()){
				int numberOfItems = getNumberOfItems(f);
				String[] fileContents = new String[numberOfItems];
				
				fillArray(fileContents, f);
				sortArray(fileContents);
				System.out.print("Number of palindromes: " + pallindromeCount);
				writeToFile(fileContents, f);
				System.out.print("\nFiles created sucessfully!\n");
			}
			else{
				System.out.print("\nThere was an issue finding the file.\n"
						+ "(Are you sure you have the correct file path?)");
			}
		}
		catch(Exception e){
			System.out.print("\nIt seems like something blocked access to the file,\n"
					+ "please check on that and try again.\n"
					+ "Error: \n" + e);
			
		}
		kb.close();
	}
	
	/**
	 * Reads from the specified file, and adds it to an array.
	 * 
	 * @param ary The array of items
	 * @param f The original file reference
	 */
	
	public static void fillArray(String[] ary, File f){
		
		try{
			
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			for(int i = 0; i < ary.length; i++){
				ary[i] = br.readLine();
			}
			br.close();
		}
		catch(Exception e){
			System.out.print("There was an issue in reading from the file.\n"
					+ e);
		}
	}
	
	/**
	 * Sorts the items read into an array from a file.
	 * 
	 * @param ary The array of items from the file
	 */
	
	public static void sortArray(String[] ary){
		
		int numOfLoops = ary.length;
		for(int k = 0; k < ary.length; k++){
			for(int i = 0; i < (numOfLoops-1); i++){
				
				String tmp;
				
				int check = ary[i].compareTo(ary[i+1]);
				
				if(check > 0){
					tmp = ary[i];
					ary[i] = ary[i+1];
					ary[i+1] = tmp;
				}
				
			}
			
			if(isPallendrome(ary, numOfLoops-1) == true){
				pallindromeCount++;
			}
			numOfLoops--;
		}
	}
	
	/**
	 * Will check if the word is a palindrome.
	 * 
	 * Set to only check on word at a time. Will cycle through the word
	 * from first to middle and last to middle. Intended to be used at the 
	 * end of the sort loop.
	 * 
	 * @param ary The array of items read from the file.
	 * @param numOfLoops The pointer for which word to look at.
	 * @return T/F based on if word is a palindrome
	 */
	
	public static boolean isPallendrome(String[] ary, int numOfLoops){
		
		for(int i = 0; i <= (ary[numOfLoops].length()/2); i++){
			if(!(ary[numOfLoops].charAt(i)+"").toLowerCase().equals((ary[numOfLoops].charAt(ary[numOfLoops].length() - (i+1))+"").toLowerCase())){
				return false;
			}
			if(!Character.isLetterOrDigit(ary[numOfLoops].charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Writes sorted words to new files based on words starting with a and m 
	 * in one file, and the rest in the other file.
	 * 
	 * @param ary The array of items from the file
	 * @param f the original file reference
	 */
	
	public static void writeToFile(String[] ary, File f){
	
		try{
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(f.getParent()+"Output1.txt"));
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(f.getParent()+"Output2.txt"));
			
			String result;
			for(int i = 0; i < ary.length; i++){
				if((int)'n' > (ary[i].charAt(0)) && (Character.isLetter(ary[i].charAt(0)))){
					
					bw1.write(ary[i]);
					bw1.newLine();
				}
				else{
					bw2.write(ary[i]);
					bw2.newLine();
				}
			}
			bw1.close();
			bw2.close();
			
			Scanner kb = new Scanner(System.in);
			System.out.print("\nPlease enter the word to add: ");
			String input = kb.nextLine();			
			kb.close();
			
			writeNewWord(f, input);
		}
		catch(Exception e){
			System.out.print("\nIt seems there was an error writing to the files.\n" 
					+ e);
		}
	}
	
	/**
	 * Takes in the new word and adds it to the proper file, will sort it as it goes.
	 * 
	 * Once the file needed is determined, it reads all those items into an array, by
	 * adding the new word first and as the array gets populated, it sorts to move the
	 * new word to its correct position. As words should have already been sorted, only
	 * one pass is needed.
	 * 
	 * @param f The original file reference
	 * @param input The word to be added
	 */
	
	public static void writeNewWord(File f, String input){
		try{
			
			if((int)'n' > (int)(input.charAt(0))){
				
				BufferedReader br1 = new BufferedReader(new FileReader(f.getParent()+"Output1.txt"));
				File f1 = new File(f.getParent()+"Output1.txt");
				int filesize = getNumberOfItems(f1);
				String[] ary = new String[filesize];
				ary[0] = input;
				int result;
				String tmp;
				
				for(int i = 1; i < ary.length;i++){
					ary[i] = br1.readLine();
					result = ary[i-1].compareTo(ary[i]);
					if(result > 0){
						tmp = ary[i-1];
						ary[i-1] = ary[i];
						ary[i] = tmp;
					}
				}
				
				
				br1.close();
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(f.getParent()+"Output1.txt"));
				for(int i = 0; i < ary.length;i++){
					bw1.write(ary[i]);
					bw1.newLine();
				}
				bw1.close();
			}
			else{
				BufferedReader br2 = new BufferedReader(new FileReader(f.getParent()+"Output2.txt"));
				File f2 = new File(f.getParent()+"Output2.txt");
				int filesize = getNumberOfItems(f2);
				String[] ary = new String[filesize];
				ary[0] = input;
				int result;
				String tmp;
				
				for(int i = 1; i < ary.length;i++){
					ary[i] = br2.readLine();
					result = ary[i-1].compareTo(ary[i]);
					if(result > 0){
						tmp = ary[i-1];
						ary[i-1] = ary[i];
						ary[i] = tmp;
					}
				}
				
				
				br2.close();
				BufferedWriter bw2 = new BufferedWriter(new FileWriter(f.getParent()+"Output2.txt"));
				for(int i = 0; i < ary.length;i++){
					bw2.write(ary[i]);
					bw2.newLine();
				}
				bw2.close();
			}
		}
		catch(Exception e){
			System.out.println("\nThere was an issue writing the word to the file.\n"
					+ e);
		}
	}
	
	/**
	 * Checks how many lines are in a specified file.
	 * 
	 * @param f The original file reference
	 * @return Int, the number of lines in the file.
	 * @throws IOException If something goes wrong with the file, will throw. Check is done before this point.
	 */
	
	public static int getNumberOfItems(File f) throws IOException {
		
		InputStream is = new BufferedInputStream(new FileInputStream(f));
		try{
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while((readChars = is.read(c)) != -1){
				empty = false;
				for(int i = 0; i < readChars; ++i){
					if (c[i] == '\n'){
						++count;
					}
				}
			}
			return ((count == 0 && !empty) ? 1 : count+1);
		}
		finally {
			is.close();
		}
	}
}
