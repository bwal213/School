
/**
 * This is a class that allows for an int to be handled in similar
 * way as pass by reference in C++.
 * @version 10.0.2
 * @author Ben Walker
 */
public class Int{

	private int x;
	
	/**
	 * @param x The int to initialize the object with.
	 */
	public Int(int x) {
		
		this.x = x;
		
	}
	
	/**	
	 * @param x The int set to the object.
	 */
	public void setInt(int x) {
		
		this.x = x;
	}
	
	/**
	 * @return The int in the object.
	 */
	public int getInt() {
		return this.x;
	}
	
}