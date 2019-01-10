/**
 * @author Ben Walker
 * @course CSC242-02
 * @assignment Lab 2: Simulate Gates
 * @assigned Week 9
 * 
 * This lab is a simulation of a given circuit.
 *
 */
public class Week9_SimulateGates {

	/**
	 * This handles all the logic and 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.print("   X   |    Y    |    Z    |  AND A  |  XOR B  |  XOR C  |  OR D \n");
		
		boolean x = false, y = false , z = false;
		int a,b,c,d;
		for(int i = 0; i < 8; i++){
			if(i > 3){
				x = true;
			}
			if(i == 2 || i == 6){
				y = true;
			}
			if(i == 4){
				y = false;
			}
			if(i % 2 == 1){
				z = true;
			}
			if(i % 2 != 1){
				z = false;
			}
			a = boolToNum(x && z);
			b = boolToNum((!y || (a == 1)) && !(!y && (a == 1)));
			c = boolToNum(((b == 1) || !y) && !((b == 1) && !y));
			d = boolToNum((c == 1) || !x);
			
			System.out.printf("%4s   | %4s    | %4s    | %4s    | %4s    | %4s    | %4s\n",
					boolToNum(x), boolToNum(y), boolToNum(z),a,b,c,d);
		}
		
		

	}
	
	/**
	 * This method is to convert a boolean to an int.
	 * 
	 * @param bool the boolean to be converted
	 * @return an int, 1 or 0
	 */
	
	public static int boolToNum(boolean bool){
		
		if(bool){
			return 1;
		}
		
		return 0;
	}

}
