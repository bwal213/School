import java.util.Scanner;

/**
 * 
 */

/**
 * @author Ben Walker
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please enter your string to be converted: ");
		String input = kb.nextLine() + " ";
		
		kb.close();
		
		boolean isEnglish = checkIfEnglish(input.charAt(0) + "");
		String output = "";
		
		if(isEnglish == true){
			
			for(int i = 0; i < input.length(); i++){
				
				output = output + (englishToMorse((input.charAt(i) + "").toUpperCase()) + " ");
				
			}
		}
		
		if(isEnglish == false){
			int i = 0;
			String tmp = "";
			int oldOutputLen;
			while(i < input.length()){
				
				tmp = input.substring(i, input.indexOf(' ', i));
				oldOutputLen = output.length();
				output = output + (morseToEnglish(tmp) + ""); 

				if(output.length() == oldOutputLen){
					if(input.substring(i-1 , (i + 6)).equals("       ")){
						output = output + (morseToEnglish("      "));
						i = i + 5;
					}
				}
				
				i = input.indexOf(' ', i) + 1;
			}
			
		}
		
		System.out.print("\nConversion: " + output);
	}
	
	/**
	 * 
	 * @param input the string to be checked
	 * @return if it is not morse
	 */
	
	public static boolean checkIfEnglish(String input){
		
		if(input.equals("-") || input.equals(".")){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	public static String morseToEnglish(String input){
		
		if(input.equals(".-")){
			return("A");
		}
		
		if(input.equals("-...")){
			return("B");
		}
		
		if(input.equals("-.-.")){
			return("C");
		}
		
		if(input.equals("-..")){
			return("D");
		}
		
		if(input.equals(".")){
			return("E");
		}
		
		if(input.equals("..-.")){
			return("F");
		}
		
		if(input.equals("--.")){
			return("G");
		}
		
		if(input.equals("....")){
			return("H");
		}
		
		if(input.equals("..")){
			return("I");
		}
		
		if(input.equals(".---")){
			return("J");
		}
		
		if(input.equals("-.-")){
			return("K");
		}
		
		if(input.equals(".-..")){
			return("L");
		}
		
		if(input.equals("--")){
			return("M");
		}
		
		if(input.equals("-.")){
			return("N");
		}
		
		if(input.equals("---")){
			return("O");
		}
		
		if(input.equals(".--.")){
			return("P");
		}
		
		if(input.equals("--.-")){
			return("Q");
		}
		
		if(input.equals(".-.")){
			return("R");
		}
		
		if(input.equals("...")){
			return("S");
		}
		
		if(input.equals("-")){
			return("T");
		}
		
		if(input.equals("..-")){
			return("U");
		}
		
		if(input.equals("...-")){
			return("V");
		}
		
		if(input.equals(".--")){
			return("W");
		}
		
		if(input.equals("-..-")){
			return("X");
		}
		
		if(input.equals("-.--")){
			return("Y");
		}
		
		if(input.equals("--..")){
			return("Z");
		}
		
		if(input.equals(".----")){
			return("1");
		}
		
		if(input.equals("..---")){
			return("2");
		}
		
		if(input.equals("...--")){
			return("3");
		}
		
		if(input.equals("....-")){
			return("4");
		}
		
		if(input.equals(".....")){
			return("5");
		}
		
		if(input.equals("-....")){
			return("6");
		}
		
		if(input.equals("--...")){
			return("7");
		}
		
		if(input.equals("---..")){
			return("8");
		}
		
		if(input.equals("----.")){
			return("9");
		}
		
		if(input.equals("-----")){
			return("0");
		}
		
		if(input.equals("      ")){
			return(" ");
		}
		
		if(input.equals(" ")){
			return("");
		}
		
		else{
			return input;
		}
		
	}
	
	public static String englishToMorse(String input){
		
		if(input.equals("A")){
			return(".-");
		}
		
		if(input.equals("B")){
			return("-...");
		}
		
		if(input.equals("C")){
			return("-.-.");
		}
		
		if(input.equals("D")){
			return("-..");
		}
		
		if(input.equals("E")){
			return(".");
		}
		
		if(input.equals("F")){
			return("..-.");
		}
		
		if(input.equals("G")){
			return("--.");
		}
		
		if(input.equals("H")){
			return("....");
		}
		
		if(input.equals("I")){
			return("..");
		}
		
		if(input.equals("J")){
			return(".---");
		}
		
		if(input.equals("K")){
			return("-.-");
		}
		
		if(input.equals("L")){
			return(".-..");
		}
		
		if(input.equals("M")){
			return("--");
		}
		
		if(input.equals("N")){
			return("-.");
		}
		
		if(input.equals("O")){
			return("---");
		}
		
		if(input.equals("P")){
			return(".--.");
		}
		
		if(input.equals("Q")){
			return("--.-");
		}
		
		if(input.equals("R")){
			return(".-.");
		}
		
		if(input.equals("S")){
			return("...");
		}
		
		if(input.equals("T")){
			return("-");
		}
		
		if(input.equals("U")){
			return("..-");
		}
		
		if(input.equals("V")){
			return("...-");
		}
		
		if(input.equals("W")){
			return(".--");
		}
		
		if(input.equals("X")){
			return("-..-");
		}
		
		if(input.equals("Y")){
			return("-.--");
		}
		
		if(input.equals("Z")){
			return("--..");
		}
		
		if(input.equals("1")){
			return(".----");
		}
		
		if(input.equals("2")){
			return("..---");
		}
		
		if(input.equals("3")){
			return("...--");
		}
		
		if(input.equals("4")){
			return("....-");
		}
		
		if(input.equals("5")){
			return(".....");
		}
		
		if(input.equals("6")){
			return("-....");
		}
		
		if(input.equals("7")){
			return("--...");
		}
		
		if(input.equals("8")){
			return("---..");
		}
		
		if(input.equals("9")){
			return("----.");
		}
		
		if(input.equals("0")){
			return("-----");
		}
		
		if(input.equals(" ")){
			return("     ");
		}
		
		else{
			return input;
		}
	}
}
