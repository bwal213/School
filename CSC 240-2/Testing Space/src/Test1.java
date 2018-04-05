/**
 * 
 */

/**
 * @author Ben
 *
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
	}
	
	void arrayAverage(){
		double[] ary = new double[10];
		double tmp = 0;
	
		for(int i=0;i < ary.length; i++){
		
			tmp = ary[i] + tmp;
		
		}
	
		System.out.print("The avg is: " + (tmp / ary.length));

	}
	
	public void sumElements(){
		
		int[][] ary = new int[3][2];
		
		for(int i = 0; i < 3; i++){
			int rowSum = 0;
			
			for(int j = 0; i < 2; j++){
				rowSum = ary[i][j] + rowSum;
			}
			System.out.print("For row " + i + " the sum is " + rowSum);
		}
	}
	
	public void lowestValue(){
		
		int[] ary = new int[10];
		int tmp = ary[(ary.length-1)];
		
		for(int i = 0; i < ary.length; i++){
			
			if (ary[i] < tmp){
				tmp = ary[i];
			}
		}
	}
	
	public void shiftAnArray(int[] ary, int moveThisMany){
		
		int tmp;		
		
		for(int i = 0; i < moveThisMany; i++){
			
			tmp = ary[0];
			
			for(int j = 0; j < (ary.length - 1); j++){
				
				ary[j] = ary[j + 1];
				
			}
			
			ary[(ary.length - 1)] = tmp;
			
		}
		
	}
}
