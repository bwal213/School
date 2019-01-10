import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * C:\Users\Ben\OneDrive\School\2018 Spring\CSC 241\Programs\Lab_3\bin\Sentances.txt
 */

/**
 * @author Ben
 * @course CSC 242-02
 * @assignment CSC242_MessageMapping
 * @assigned week 13
 * 
 * 	The reads messages from a file then saves the words in an array for later readback.
 */
public class CSC242_MessageMapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		FileReader fr;
		while(true){
			try{
				System.out.print("Please input file location: \n");
				File file = new File(kb.nextLine());
				fr = new FileReader(file);
				break;
			} catch (Exception e){
				System.out.print("Wrong file location!\n");
			}
		}
		
		BufferedReader br = new BufferedReader(fr);
		String sentance;
		int[] ary;
		String[] sentArray, wordArray = new String[200];
		int[][] wordPosArray = new int[20][20];
		for(int[] row : wordPosArray){
			Arrays.fill(row,999);
		}
		int pntr = 0, pntr2 = 0;
		boolean isUnique, isFound = false;
		
		while(true){
			
			try{
				sentance = br.readLine();
				if(sentance == null){
					break;
				}
				sentArray = sentance.split(" ");
			} catch (Exception e){
				System.out.print("\nError reading file!\n" + e);
				return;
			}
			for(int i = 0; i < sentArray.length; i++){
				for(int j = 0; j < pntr; j++){
					if(sentArray[i].equals(wordArray[j])){
						isFound = true;
						wordPosArray[pntr2][i] = j;
						break;
					}
					
				}
				if(isFound == false){
					wordArray[pntr] = sentArray[i];
					wordPosArray[pntr2][i] = pntr;
					pntr += 1;
				}
				isFound = false;
			}
			ary = new int[sentance.length()];
			pntr2++;
		}
		
		for(int i = 0; i < wordArray.length; i++){
			System.out.print(wordArray[i]+ " ");
		}
		
		System.out.print("\nWhat sentance would you like to print?: ");
		int temp;
		while(true){
			temp = kb.nextInt() - 1;
			if(temp >= 0 && temp < 20){
				break;
			}
			System.out.print("Please choose a number 1-20: ");
		}
		String endSentance = "";
		int cnt = 0;
		for(int i = 0; i < wordPosArray[temp].length; i++){
			if(wordPosArray[temp][i] == 999){
				break;
			}
			endSentance += wordArray[wordPosArray[temp][i]] + " ";
		}
		System.out.println("\n" + endSentance);
	}

}
