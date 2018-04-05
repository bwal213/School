import java.util.Scanner;

/**
 * 
 */

/**
 * @author Ben
 *
 */
public class Ben_Walker_HW2_3 {

	/**
	 * Handles the input getting
	 * 
	 * Gets the input, and handles setting up the variables
	 * for the method calls.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] monthName = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		int monthLength;
		
		Scanner kb = new Scanner(System.in);
		
		int m;
		int n;
		//int input;
		
		
		while(true){
			System.out.print("please enter the year in YYYY format:");
			try{
				n = Integer.parseInt(kb.next());
				
				break;
			}
			catch(Exception e){
				
				System.out.print("\nAre you sure you have the correct format?\n");
			}
		}
		
		int n2 = n;
		
		while(true){
			System.out.print("please enter the month in MM format:");
			try{
				m = Integer.parseInt(kb.next());
				if(m < 12 || m > 1){
					break;
				}else{
					System.out.print("\nAre you sure you have the correct format?\n");
				}
			}
			catch(Exception e){
				
				System.out.print("\nAre you sure you have the correct format?\n");
			}
		}
		int c = getCentury(n);
		
		if(m == 2 && (n % 4) == 0){
			
			monthLength = daysOfMonth[m-1]+1;
		}else{
			
			monthLength = daysOfMonth[m-1];
		}
		
		String nameOfMonth = monthName[m-1];
		
		if(m == 1 || m == 2){
			
			m = m + 12;
			n = n - 1;
		}
		
		kb.close();
		printCallendar(zellers( m, c, (n % 100)),monthLength,nameOfMonth,n2);
		
	}
	
	/**
	 * Gets the number of the first day of the week.
	 * 
	 * @param month the variable for the month
	 * @param century the variable for the century
	 * @param year the variable for the yy of the year
	 * @return the number of the day of the week the month starts on
	 */
		
	public static int zellers(int month, int century, int year){
		
		int callendar = (((13*(month+1))/5) + year + (year/4) + (century/4) - (2*century));
		
		callendar = (callendar )%7;
		if(callendar < 0){
			callendar = callendar + 7;
		}
		
		//System.out.print(callendar + " " + year + " " + month);
		return callendar;
	}

	/**
	 * Displays the calendar of the requested month
	 * 
	 * @param day the number of the day of the week the first day of the month is on
	 * @param monthLength the number of days in the month
	 * @param monthName the name of the month
	 * @param n the year
	 */
	
	public static void printCallendar(int day, int monthLength,String monthName,int n){
		System.out.print("\n\n    " + monthName + " " + n + "\n");
		System.out.print("  S  M Tu  W Th  F Sa\n\n\n");
		
		for(int j = 0; j < day;j++){
			System.out.print("   ");
		}
		for(int i = 0; i < monthLength;i++){
			
			if((i+day)%7 == 0 && i != 0){
				System.out.print("\n");
			}
			if((i+1) < 10){
				System.out.print(" ");
			}
			System.out.print(" " + (i+1));
			
		}
		
	}
	
	/**
	 * finds the first two digits of the year.
	 * 
	 * @param year
	 * @return the first two digits of the year.
	 */
	
	public static int getCentury(int year){
		
		int d = (int) year/100;
		
		return d;
	}
}
