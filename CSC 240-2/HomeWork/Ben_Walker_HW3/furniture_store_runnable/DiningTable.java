/**
 * 
 */
package furniture_store;

import java.util.Scanner;

/**
 * @author Ben
 *
 */
public class DiningTable extends Table {
	
	public double weight;
	public int numberOfLegs; //MUST BE 1 OR 4
	public double price;
	//SHOULD BE BOUGHT WITH AT LEAST TWO ARMCHAIRS

	/**
	 * 
	 */
	public DiningTable() {
		// TODO Auto-generated constructor stub
		this.weight = 0;
		this.numberOfLegs = 4;
		this.price = 250;
	}
	
	public DiningTable(double weight, int numberOfLegs, double price){
		this.weight = weight;
		this.numberOfLegs = numberOfLegs;
		this.price = price;
	}
	
	public static int checkAmountSold(FurnitureStore fs){
		int correctedAmount = fs.numberOfDiningTables;
		System.out.print("\ninside DT\n");
		System.out.print("\n2 Armchairs should be bought with each Dining table\n"
				+ "Enter the number of Dining tables you wish to purchase: ");
		
		correctedAmount = FurnitureStore.kb.nextInt();
	
		while(fs.numberOfDiningTables > 0 && fs.numberOfArmchairs != (fs.numberOfDiningTables * 2)){
			System.out.print("\n2 Armchairs should be bought with each Dining table\n"
					+ "Enter the number of Dining tables you wish to purchase: ");
			
			correctedAmount = FurnitureStore.kb.nextInt();
			
			System.out.print("\nEnter the number of Armchairs you wish to purchase: ");
			
			fs.numberOfArmchairs = FurnitureStore.kb.nextInt();
			if(fs.numberOfDiningTables == fs.numberOfArmchairs /2 ){
				break;
			}
			
		}
		return correctedAmount;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the numberOfLegs
	 */
	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	/**
	 * @param numberOfLegs the numberOfLegs to set
	 */
	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
