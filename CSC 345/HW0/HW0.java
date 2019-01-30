/**
 * 
 */

/**
 * @author Ben Walker
 *
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
	
	static int square(Int i) {
		
		int x = i.toInt();
		
		x = x*x;
		i.setInt(x);
		return i.toInt();
	}
	
	static int twice(Int i) {
		
		int x = i.toInt();
		
		x = 2*x;
		
		i.setInt(x);
		return i.toInt();
	}
	
	static int once(Int i) {
		
		return i.toInt();
	}

}
