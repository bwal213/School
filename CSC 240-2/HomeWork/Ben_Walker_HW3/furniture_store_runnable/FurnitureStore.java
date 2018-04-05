/**
 * 
 */
package furniture_store;

import java.util.Scanner;

/**
 * @author Ben
 *
 */
public class FurnitureStore {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static double taxrate = .1;
	
	public double tablePrice = 150.00;
	public double chairPrice = 50.00;
	public double diningTablePrice = 250.00;
	public double armChairPrice = 150.00;
	
	public static int numberOfArmchairs = 0;
	public static int numberOfDiningTables = 0;
	public static int numberOfTables = 0;
	public static int numberOfChairs = 0;
	
	public static double total;
	public static double tax;

	/**
	 * 
	 */
	public FurnitureStore() {
		// TODO Auto-generated constructor stub
	}

}
