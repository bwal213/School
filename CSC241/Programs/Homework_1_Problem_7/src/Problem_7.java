/**
 * 
 * @author Ben Walker
 * @class CSC 241
 * @date 2-8-18
 *
 */

public class Problem_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("n      T(n) \t n*log(n)\tT(n)/(n*log(n)\n");
		
		for(int i = 2; i <= 10; i++){
			
			System.out.printf("%-2s %7s %11.2f %13.2f\n",i,tOfN(i),tOfNLog(i),(tOfN(i)/tOfNLog(i)));
			
		}
		
		System.out.print("\nn     U(n) \t n*log(n)\tU(n)/(n*n*log(n))\n");
		
		for(int i = 2; i <= 10; i++){
			
			System.out.printf("%-2s %7s %12.2f %13.2f\n",i,uOfN(i),uOfNLog(i),(uOfN(i)/uOfNLog(i)));
			
		}
		
		System.out.print("\nn     V(n) \t 9*n*n-5*n\n");
		
		for(int i = 2; i <= 10; i++){
			
			System.out.printf("%-2s %7s %10s\n",i,vOfN(i),vTimesNine(i));
			
		}
	}
	
	public static int tOfN(int n){
		
		if(n == 1){
			return 4;
		}
		else{
			return (2 * tOfN(n/2) + 5 * n);
		} 
		
	}
	
	public static double tOfNLog(int n){
		
		return n * (Math.log(n) / Math.log(2));
	}
	
	public static int uOfN(int n){
		
		if(n == 1){
			return 4;
		}
		else{
			return (4 * uOfN(n/2) + 5 * n*n);
		} 
		
	}
	
	public static double uOfNLog(int n){
		
		return (n*n) * (Math.log(n) / Math.log(2));
	}
	
	public static int vOfN(int n){
		
		if(n == 1){
			return 4;
		}
		else{
			return (4 * vOfN(n/2) + 5 * n);
		} 
		
	}
	
	public static int vTimesNine(int n){
		
		return (9 * n*n - 5 * n);
	}

}
