/**
 * 
 */
package eMoneyAdvisorHW;

/**
 * @author Ben Walker
 *
 */
public class PrintGlass {

	/**
	 * Calls the PrintGlass method.
	 * 
	 * @param args Not expected to be used but could be implemented.
	 */
	public static void main(String[] args) {
		
		PrintGlass(4);

	}
	
	/**
	 * Prints an ASCII Art martini glass of variable size.
	 * 
	 * @param num Controls size of martini glass.
	 */
	public static void PrintGlass(int num){
		
		if(num > 0){
			
			System.out.print(printChalice(num, ""));
			System.out.print(printStem(num, ""));
			System.out.print(printBase(num, " "));
			
		}	
		else{
			System.out.print("Cannot display less than one character.");
		}
	}
	

	/**
	 * Creates one String of the upper section of the glass.
	 * 
	 * @param num 	Defines the size of the martini glass, must be greater than one.
	 * @param lineOutput 	The base string to start working with, "" for one space in front.
	 * @return Returns String lineOutput.
	 */
	private static String printChalice(int num, String lineOutput){
		for(int i = 0; i < num; i++){
			for(int k = 0; k < i + 1; k++){
				lineOutput += " ";
			}
			for(int j = (num * 2) - ((i * 2) + 1); j > 0; j--){
				lineOutput += "0"; 
			}
			lineOutput += "\n";
		}
		return lineOutput;
	}
	
	/**
	 * Creates one String of the middle section of the glass.
	 * 
	 * @param num	Defines the size of the martini glass, must be greater than one.
	 * @param lineOutput	The base string to start working with, "" for one space in front.
	 * @return Returns String lineOutput.
	 */
	private static String printStem(int num, String lineOutput){
		for(int i = 0; i < num; i++){
			for(int j = 0; j < num; j++){
				lineOutput += " ";
			}
			lineOutput += "|\n";
		}
		return lineOutput;
	}
	
	/**
	 * Creates one String of the bottom section of the glass.
	 * 
	 * @param num	Defines the size of the martini glass, must be greater than one.
	 * @param lineOutput	The base string to start working with, " " for one space in front.
	 * @return Returns String lineOutput.
	 */
	private static String printBase(int num, String lineOutput){
		for(int i = 0; i < (num * 2) - 1; i++){
			lineOutput += "=";
		}
		return lineOutput;
	}
}
