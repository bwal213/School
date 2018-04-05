/**
 * 
 */
package furniture_store;

import java.util.Scanner;

/**
 * @author Ben
 *
 */
public class Chair extends Furniture {

	public double price;
	public double weight;
	public double weightCapacity;
	public double seatDepth;
	//dont forget to add the amount sold check____________________
	
	/**
	 * 
	 */
	public Chair() {
		// TODO Auto-generated constructor stub
		this.price = 50.00;
		this.weight = 0;
		this.weightCapacity = 0;
		this.seatDepth = 0;
		
	}

	public Chair(double price, double weight, double weightCapacity, double seatDepth){
		this.price = price;
		this.weight = weight;
		this.weightCapacity = weightCapacity;
		this.seatDepth = seatDepth;
	}
	
	public static int checkAmountSold(){

		System.out.print("\nNumber of Chairs in cart must be a multiple of 4\n"
				+ "Enter the number of Chairs you wish to purchase: ");
		int correctedAmount = FurnitureStore.kb.nextInt();
		
		while((correctedAmount % 4) != 0){
			System.out.print("\nNumber of Chairs in cart must be a multiple of 4\n"
					+ "Enter the number of Chairs you wish to purchase: ");
			correctedAmount = FurnitureStore.kb.nextInt();
			
		}
		return correctedAmount;
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
	 * @return the weightCapacity
	 */
	public double getWeightCapacity() {
		return weightCapacity;
	}


	/**
	 * @param weightCapacity the weightCapacity to set
	 */
	public void setWeightCapacity(double weightCapacity) {
		this.weightCapacity = weightCapacity;
	}


	/**
	 * @return the seatDepth
	 */
	public double getSeatDepth() {
		return seatDepth;
	}


	/**
	 * @param seatDepth the seatDepth to set
	 */
	public void setSeatDepth(double seatDepth) {
		this.seatDepth = seatDepth;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		System.out.print("\n" + weight + ", " + seatDepth + "\n");
		/*return "Chair [price=" + price + ", weight=" + weight
				+ ", weightCapacity=" + weightCapacity + ", seatDepth="
				+ seatDepth + "]";
		*/
		return "";
	}

}
