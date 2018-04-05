/**
 * 
 */
package furniture_store;

/**
 * @author Ben
 *
 */
public class Ben_Walker_HW3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Checkout.Checkout();

	}
	
	
	
}

/**
 * 
 */
package furniture_store;

/**
 * @author Ben
 *
 */
public class Furniture {
	
	public String color;
	public String buildYear;
	public String stockNumber;
	
	public Furniture(String color, String buildYear, String stockNumber){
		this.color = color;
		this.buildYear = buildYear;
		this.stockNumber = stockNumber;
	}
	
	public Furniture(){
		this.color = "NULL";
		this.buildYear = "NULL";
		this.stockNumber = "NULL";
	}
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the buildYear
	 */
	public String getBuildYear() {
		return buildYear;
	}

	/**
	 * @param buildYear the buildYear to set
	 */
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	/**
	 * @return the stockNumber
	 */
	public String getStockNumber() {
		return stockNumber;
	}

	/**
	 * @param stockNumber the stockNumber to set
	 */
	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	@Override
	public String toString() {
		System.out.print("\n" + stockNumber + ", " + color + ", " + buildYear + "\n");
		return "";
	}
	
	
}

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

/**
 * 
 */
package furniture_store;

import java.util.Scanner;

/**
 * @author Ben
 *
 */
public class Checkout {

	
	
	/**
	 * 
	 */
	public static void Checkout() {
		// TODO Auto-generated constructor stub
		FurnitureStore fs = new FurnitureStore();
		fs.numberOfChairs = Chair.checkAmountSold();
		fs.numberOfTables = Table.checkAmountSold();
		fs.numberOfArmchairs = Armchair.checkAmountSold();
		fs.numberOfDiningTables = DiningTable.checkAmountSold(fs);
		
		while(fs.numberOfDiningTables > 0 && fs.numberOfArmchairs != (fs.numberOfDiningTables * 2)){
			System.out.print("\nInside CO\n");
			System.out.print("\n2 Armchairs should be bought with each Dining table\n"
					+ "Enter the number of Dining tables you wish to purchase: ");
			
			fs.numberOfDiningTables = FurnitureStore.kb.nextInt();
			
			System.out.print("\nEnter the number of Armchairs you wish to purchase: ");
			
			fs.numberOfArmchairs = FurnitureStore.kb.nextInt();
			if(fs.numberOfDiningTables == fs.numberOfArmchairs /2 ){
				break;
			}
		}
		
		Table tb = new Table();
		Chair ch = new Chair();
		Armchair ac = new Armchair();
		DiningTable dt = new DiningTable();
		
		fs.total = (fs.numberOfTables * tb.price) 
				+ (fs.numberOfDiningTables * dt.price)
				+ (fs.numberOfChairs * ch.price)
				+ (fs.numberOfArmchairs * ac.price);
		
		fs.tax = fs.total * fs.taxrate;
		
		System.out.print("\n\n\nStore FurnitureONE:\n"
				+ fs.numberOfTables + ", Tables\n"
				+ fs.numberOfArmchairs + ", Armchairs\n"
				+ fs.numberOfDiningTables + ", DiningTables\n"
				+ fs.numberOfChairs + ", Chairs\n"
				+ "Subtotal: " + "$" + fs.total + "\n"
				+ "Tax:\t  " + "$" + fs.tax + "\n"
				+ "Total:\t  " + "$" + (fs.total+fs.tax));
	}

}

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

