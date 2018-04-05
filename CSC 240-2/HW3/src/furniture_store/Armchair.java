/**
 * 
 */
package furniture_store;

import java.util.Scanner;

/**
 * @author Ben
 *
 */
public class Armchair extends Chair{
	
	public int numberOfArms;

	/**
	 * 
	 */
	public Armchair() {
		// TODO Auto-generated constructor stub
		this.numberOfArms = 2;
		this.price = 150;
		this.weight = 0;
		this.weightCapacity = 0;
		this.seatDepth = 0;
	}
	
	public Armchair(int numberOfArms, double price, double weight, double weightCapacity, double seatDepth){
		this.numberOfArms = numberOfArms;
		this.price = price;
		this.weight = weight;
		this.weightCapacity = weightCapacity;
		this.seatDepth = seatDepth;
	}
	
	public static int checkAmountSold(){
		
		System.out.print("\nNumber of Armchairs in cart must be a multiple of 2\n"
				+ "Enter the number of Armchairs you wish to purchase: ");
		
		int correctedAmount = FurnitureStore.kb.nextInt();
		
		
		while((correctedAmount % 2) != 0){
			System.out.print("\nNumber of Armchairs in cart must be a multiple of 2\n"
					+ "Enter the number of Armchairs you wish to purchase: ");
			
			correctedAmount = FurnitureStore.kb.nextInt();
			
		}
		return correctedAmount;
	}

}
