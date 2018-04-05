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
