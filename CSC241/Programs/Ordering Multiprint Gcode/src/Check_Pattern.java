import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */

/**
 * @author Ben
 *
 */
public class Check_Pattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Charset charset = Charset.forName("UTF-8");
		FileReader file;
		
		if(args.length > 0){
		
			try {
				file = new FileReader(args[0]);
				BufferedReader br = new BufferedReader(file);
				
				int[] num = new int[0];
				//float num = new float[0];
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("A Critical Error Has Occured");
				e.printStackTrace();
			}
			
		}
		else{
		System.out.println("No Arguments Specified");
		}
	}

}
