/**
 * 
 */
package furniture_store;

import java.util.Scanner;

/**
 * @author Ben
 *
 */
public class Table extends Furniture {
	
	public double price;
	public double height;
	public int numberOfLegs; //is this 1 or 4?
	public double weightCapacity;
	public double dimensions;

	/**
	 * 
	 */
	public Table() {
		// TODO Auto-generated constructor stub
		this.price = 150.00;
		this.height = 0;
		this.numberOfLegs = 4;
		this.weightCapacity = 0;
		this.dimensions = 0;
	}
	
	public Table(double price, double height, 
			int numberOfLegs, double weightCapacity, double dimensions){
		this.price = price;
		this.height = height;
		this.numberOfLegs = numberOfLegs;
		this.weightCapacity = weightCapacity;
		this.dimensions = dimensions;
	}
	
	public static int checkAmountSold(){
		
		System.out.print("\nPlease enter the number of Tables you want to buy: ");
		int correctedAmount = FurnitureStore.kb.nextInt();
		
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
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
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
	 * @return the dimensions
	 */
	public double getDimensions() {
		return dimensions;
	}

	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(double dimensions) {
		this.dimensions = dimensions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		System.out.print("\n" + buildYear + ", " + weightCapacity + "\n");
		/*return "Table [price=" + price + ", height=" + height
				+ ", numberOfLegs=" + numberOfLegs + ", weightCapacity="
				+ weightCapacity + ", dimensions=" + dimensions + "]";
		*/
		return "";
	}

}
