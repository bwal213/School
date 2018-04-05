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
