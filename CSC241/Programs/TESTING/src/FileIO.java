import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Ben
 *
 */
public class FileIO {

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
				System.out.print("Wrong file location!\n" + e);
			}
		}
		
		BufferedReader br = new BufferedReader(fr);
		String sentance;
		int[] ary;
		
		while(true){
			
			try{
				sentance = br.readLine();
			} catch (Exception e){
				System.out.print("\nError reading file!\n" + e);
				return;
			}
			ary = new int[sentance.length()];
			System.out.print(sentance.charAt(0));
			
		}

	}

}
