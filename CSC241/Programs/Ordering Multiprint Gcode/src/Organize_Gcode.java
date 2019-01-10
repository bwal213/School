import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 
 */

/**
 * @author Ben Walker
 *
 */
public class Organize_Gcode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		FileReader file;
			
			if(args.length > 0){
			
				try {
					file = new FileReader(args[0]);
					BufferedReader br = new BufferedReader(file);
					
					int numOfObjects = 0;
					
					int[] num = new int[numOfObjects];
					float[][] locations = new float[0][];
					
					
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
