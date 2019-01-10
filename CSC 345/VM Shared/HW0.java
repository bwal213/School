/**
 * Ben Walker
 * CSC 345
 * HomeWork 0
 */

/**
 * This program will sum a variable using a way that emulates pass by
 * reference in C++.
 * @version 10.0.2
 * @author Ben Walker
 */
public class HW0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Int x = new Int(3);
		int y = square(x) + twice(x) + once(x);		// y == 45, not  18
		System.out.println(y);						// prints 45, not 18

	}
	
	/**
	 * @param i The int to be squared.
	 * @return the squared value.
	 */
	static int square(Int i) {
		
		int x = i.getInt();
		
		x = x*x;
		i.setInt(x);
		return i.getInt();
	}
	
	/**
	 * @param i The int to be multiplied by two.
	 * @return The doubled value.
	 */
	static int twice(Int i) {
		
		int x = i.getInt();
		
		x = 2*x;
		
		i.setInt(x);
		return i.getInt();
	}
	
	/**
	 * @param i The int to be returned.
	 * @return The same value as taken in.
	 */
	static int once(Int i) {
		
		return i.getInt();
	}

}
