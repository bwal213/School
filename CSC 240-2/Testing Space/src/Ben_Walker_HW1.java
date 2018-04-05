import java.util.Scanner;

/**
 * @author Ben Walker
 * @version 1.0
 *
 */
public class Ben_Walker_HW1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		* TODO
		* DONE-make sure each block (3x3) is checked too
		* DONE-add the ability to return TRUE when correct
		* DONE-change to getting per char not per int
		* -comment this thing!
		* (optional)
		* -Beautify
		* -Try except (could use more but good enough.)
		* -GUI
		* 
		* Test String: 184963725562748319397512864239657148756184293418239657941376582623895471875421936
		*
		*/ 
		
		try{
			
			if(playSudoku() == true){
				//outputArray(puzzleBlock);
				System.out.print("\nThis is a valid puzzle!");
			}
			
		}catch(Exception e){
			
			System.out.print("Sorry, something went wrong.\n"
					+ e);
			
		}

	}
	
	/**
	 * Creates an int[][], checks for validity.
	 * <p>
	 * This will initialize the array of size 9 by 9,
	 * then it fills the array and resets it, then 
	 * outputs the array to the console, then checks
	 * if the array passes the rules of Sudoku.
	 * 
	 * @return (true || false) The final pass of if it is ok.
	 */
	
	public static boolean playSudoku(){
		
		int[][] puzzleBlock = new int[9][9]; 
		
		puzzleBlock = fillArray(puzzleBlock);
		outputArray(puzzleBlock);
		if(checkArray(puzzleBlock) == "TRUE"){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * Takes in an array and fills it with integers.
	 * <p>
	 * Fills the two dimensional array from
	 * the top row to the bottom row, by rows. 
	 * Accepts a single two dimensional array
	 * as input. Outputs the array back once 
	 * filled.
	 * <p>
	 * For the getInput* method, it can
	 * either get it from Keyboard, using
	 * getInputKeyboard() or randomly generate
	 * on its own, using getInputRand().
	 * 
	 * @param ary    Takes in int[][] empty and returns it filled.
	 * @return ary	 Returns int[][] filled with values
	 */
	
	public static int[][] fillArray(int[][] ary){
		
		String inputString = getInputKeyboard();
		
		for(int i = 0; i < ary.length; i++){
			for(int j = 0; j < ary[i].length; j++){
				
				ary[i][j] = Integer.parseInt((inputString.charAt((i*9) + j))+ "");
			}
		}
		return ary;
	}
	
	/**
	 * Generates 81 random numbers in the range of 1 to 9
	 * <p>
	 * This will use Math.random() to generate random
	 * numbers, then multiply by 9 and cast to an int.
	 * <p>
	 * If the num generated is 0, it gets another
	 * number until it is in the correct range.
	 * <p>
	 * It then appends the  number to numString, till
	 * 81 values have been generated.
	 * <p>
	 * It will finally return the full string to the 
	 * calling method.
	 * 
	 * @return numString A string of numbers intended to be put in the array
	 */
	
	public static String getInputRand(){
		
		int num;
		String numString = "";
		
		for(int i = 0; i < 81; i++){
			num = (int) (Math.random() * 9);
			while (num < 1){
				num = (int) (Math.random() * 9);
			}
			numString = (numString + num);
		}
		
		return numString;
		
	}
	
	/**
	 * Gets 81 numbers in range 1 to 9
	 * <p>
	 * This prompts the user in console, to input
	 * the number set to be checked. This makes 
	 * use of Scanner, and checking if it is a 
	 * number with a try catch statement to see
	 * if the char can be converted to an in, and
	 * if not, skips to the next in the input
	 * string and checks that. If there is 
	 * nothing left in the string, it asks for 
	 * the set to finish off.
	 * 
	 * @return numString The string to fill the array.
	 */
	
	public static String getInputKeyboard(){
		 
		String numString = "";
		String tmp = "";
		Scanner keyboard = new Scanner(System.in);
		
		while((int)(numString.length()) < ((9*9) - 1)){
			
			System.out.println("enter the set:");
			tmp = keyboard.next();
			
			for(int j = 0; j < tmp.length(); j++){
				try{
					int isItInt = (Integer.parseInt((tmp.charAt(j)) + "")) / 1;
				//	System.out.print(j + " " 
				//	+ ((tmp.charAt(j)) + "") 
				//	+ " " + numString.length()
				//	+ "\n");
					numString = numString + tmp.charAt(j);
				
				}catch(Exception e){
					System.out.print(
							"Something that isnt a number was entered, "
							+ tmp.charAt(j) + "\n"
							+ "Skipping to next value.\n");
				}
			}
		}
		
		keyboard.close();
		return (numString);
	}
	
	/**
	 * Takes in an array, and displays it to the console.
	 * <p>
	 * Uses two 'for loops' to cycle through the array and
	 * formats the display to make it appear more neat
	 * and slightly closer to the intended style of a
	 * Sudoku puzzle.
	 * <p>
	 * @param ary   an int[][] that will be cycled through
	 */
	
	public static void outputArray(int[][] ary){
		System.out.print("\n");
		for(int i = 0; i < ary.length; i++){
			for(int j = 0; j < ary[i].length; j++){
				System.out.print("[ " + ary[i][j] + " ]");
			}
			System.out.print("\n");
		}
		
	}
	
	/**
	 * Will check a two dimensional array per Sudoku rules.
	 * <p>
	 * This method takes in a two dimensional array
	 * and then checks both the vertical and 
	 * horizontal columns for any duplicates as
	 * well as checking the 9, 3 by 3 blocks.
	 * This is achieved by checking each row first
	 * and compiling a list of numbers given on the
	 * fly, and checking if the same number was
	 * already added. It then checks the columns
	 * the same way. And then each block similar to
	 * how the rows were done. 
	 * If it works, it returns "TRUE" else it will 
	 * return "FALSE". 
	 * If an issue was found it gives a description
	 * of where and what it found.
	 * It Will give a report of where it is based
	 * on how the variables in the 'for loops' are
	 * pointing at that point.
	 * <p>
	 *  There are efficiencies that could be gained
	 *  by kicking out and stopping as soon as
	 *  incorrect input is detected, granted that
	 *  is more how an actual game would work.
	 * <p>
	 * I do feel bad about this, but I couldn't
	 * come up with a better way to check through
	 * the whole set per Sudoku rules. This is
	 * probably an inefficient solution.
	 * <p>
	 *  @param array	An int[][] array that will be checked
	 *  @return String ("TRUE" || "FALSE")	If an issue was found it returns "FALSE" else returns "TRUE"
	 */
	
	public static String checkArray(int[][] ary){
		
		int works = 1;
		
		for(int i = 0; i < ary.length; i++){
			
			int cnt = 0;
			int[] tmp = new int[ary.length];
			for(int j = 0; j < ary[i].length; j++){
				for(int k = 0; k < cnt; k++){
					
					//System.out.print("inside k for loop.\n");
					if(tmp[k] == ary[i][j]){
						System.out.print("There is a duplicate in row" + i 
								+ ",\n (" + ary[i][j] + ") this will not work!\n");
						works = 0;
					}
				}
				tmp[cnt] = ary[i][j];
				cnt++;
				//System.out.print("Added a thing to tmp.\n");
			}
			
		}
		
		for(int j = 0; j < ary.length; j++){
			
			int cnt = 0;
			int[] tmp = new int[ary.length];
			for(int i = 0; i < ary[j].length; i++){
				for(int k = 0; k < cnt; k++){
					
					//System.out.print("inside k for loop.\n");
					if(tmp[k] == ary[i][j]){
						System.out.print("There is a duplicate in column" + j 
								+",\n (" + ary[i][j] + ") this will not work!\n");
						works = 0;
					}
				}
				tmp[cnt] = ary[i][j];
				cnt++;
				//System.out.print("Added a thing to tmp.\n");
			}
			
		}
		
		for(int m = 0; m < 3; m++){
			for(int n = 0; n < 3; n++){
								
				int cnt = 0;
				int[] tmp = new int[ary.length];
					
				for(int i = 0; i < (ary.length / 3); i++){
					for(int j = 0; j < (ary[i].length / 3); j++){
						for(int k = 0;(k < cnt || k == 0); k++){
						
							//System.out.print("inside k for loop.\n");
							if(tmp[k] == ary[(m*3) + i][(n*3) + j]){
								System.out.print("There is a duplicate in block " + (((n)+(m*3))+1) 
										+ ",\n (" + ary[(m*3) + i][(n*3) + j] + ") this will not work!\n");
								works = 0;
							}
						}
						tmp[cnt] = ary[(m*3) + i][(n*3) + j];
						cnt++;
						//System.out.print("Added a thing to tmp.\n");
					}	
				}	
			}
		}
		if(works == 1){
			return "TRUE";
		}else{
			return "FALSE";
		}
		
	}

}
