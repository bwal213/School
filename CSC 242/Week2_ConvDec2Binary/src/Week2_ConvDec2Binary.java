/**
 * @course CSC 241-02
 * @author Ben Walker
 * @assignment Week 2 - Convert to Binary
 */

import java.util.Scanner;

public class Week2_ConvDec2Binary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the Decimal number you wish to convert to Binary.\n"
				+ "(Range is 0-2000000, expects an int.): ");
		int input = kb.nextInt();
		
		while(true){
			
			if(input > 2000000 || input < 0){
				System.out.print("Please enter the Decimal number you wish to convert to Binary.\n"
						+ "(Range is 0-2000000, expects an int.): ");
				input = kb.nextInt();
			}
			else{
				break;
			}
		}
		
		int input2 = input;
		kb.close();
		
		String[] ary = new String[24];
		
		System.out.print("\n");
		System.out.print(" Decimal: "  + input + "\n Binary:");
		
		int j = 0;
		
		if(input2 > 65535){
			j = 23;
		}
		
		if(input2 > 255 && input2 <= 65535){
			j = 15;
		}
		
		if(input2 <= 255){
			j = 7; 
		}
		for(; j >= 0; j--){
			
			//System.out.print("\n" + input + ", " + (input % 2));
			ary[j] = (input % 2)+"";
			input = input / 2;			
		}
		
		int len = 24;
		
		if(input2 > 65535){
			len = 24;
		}
		
		if(input2 > 255 && input2 <= 65535){
			len = 16;
		}
		
		if(input2 <= 255){
			len = 8; 
		}
		for(int i = 0;i < len; i++){
			
			if((i % 8) == 0){
				System.out.print(" ");
			}
			
			System.out.print(ary[i]);
		}
	}
}
