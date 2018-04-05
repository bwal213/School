import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Ben
 *
 */
public class ManhattanDistance {

	public static int[][] ary = new int[8][8];
	//private static final int empty = -1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		int startX = 10;
		int startY = 10;
		int endX = 10;
		int endY = 10;
		fillArray(ary);
		
		System.out.print("The grid positions start with 1 and end with 8.\n");
		//System.out.print("Please enter the location of the Start point, on the 8 by 8 grid\n"
		//		+ " X coordinate: ");
		startX = getInput(kb,startX, "Start point X coordinate")-1;
				
		//System.out.print("Please enter the location of the Start point, on the 8 by 8 grid\n"
		//		+ " X coordinate: ");
		startY = getInput(kb,startY, "Start point Y coordinate")-1;
				
		//System.out.print("Please enter the location of the End point, on the 8 by 8 grid\n"
		//		+ " X coordinate: ");
		endX = getInput(kb,endX, "End point X coordinate")-1;
				
		//System.out.print("Please enter the location of the Start point, on the 8 by 8 grid\n"
		//		+ " X coordinate: ");
		endY = getInput(kb,endY, "End point Y coordinate")-1;
		
		//Interger[][] ary = new Integer[8][8];
		
		fillDistance(startX,startY);
		//printArray();
		getAllPaths(startX, startY, endX, endY);

	}
	
	public static void fillDistance(int x, int y){
		
		ary[x][y] = 0;
		
		for(int dist = 0; dist < 14; dist++){
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(j+1 < 8){
						if((ary[i][j+1] == dist) && (ary[i][j] == -1 )){
						
							ary[i][j] = dist+1;						
						}
					}
					if((i+1 < 8)){
						if((ary[i+1][j] == dist) && (ary[i][j] == -1 )){
							
							ary[i][j] = dist+1;						
						}
					}
					if((j-1 >= 0)){
						if((ary[i][j-1] == dist) && (ary[i][j] == -1 )){
							
							ary[i][j] = dist+1;						
						}
					}
					if((i-1 >= 0)){
						if((ary[i-1][j] == dist) && (ary[i][j] == -1 )){
							
							ary[i][j] = dist+1;						
						}
					}
				}
			}
		}
	}
	
	//public static boolean hasGoneRight(){
		
	//}
	
	public static void getAllPaths(int startX, int startY, int endX, int endY){
		
		int width = endX - startX;
		int length = endY - startY;
		
		int initWidth = width;
		int secWidth = 0;
		int initLength = length;
		int secLength = 0;
		System.out.print("\nPaths:\n");
		int pathNum = 0;
		int numOfPaths = binomial((length*width)-2,length-1).intValue();
		
		if(width > 0 && length > 0){
			int totalDistance = (width-1) + (length-1);
			
			ArrayList<ArrayList<String>> allPaths = new ArrayList<ArrayList<String>>();
			ArrayList<String> currentPath = new ArrayList<String>();
			
			while(true){
				
				int i1 = startX;
				int i2 = startY;
				System.out.print(numOfPaths + ", " + allPaths.size() + ", " + currentPath.size() 
						+ currentPath + "\n" + allPaths + "\n");
				
				for(int i = 0; i < totalDistance; i++){
					if(!currentPath.contains(Integer.toString(i1+1) + "," + Integer.toString(i2))
							&& i1+1 <= endX){
						currentPath.add(Integer.toString(i1+1) + "," + Integer.toString(i2));
						i1 += 1;
					}
					else if(!currentPath.contains(Integer.toString(i1) + "," + Integer.toString(i2+1))
							&& i2+1 <= endY){
						currentPath.add(Integer.toString(i1) + "," + Integer.toString(i2+1));
						i2 += 1;
					}
					/*else if(!currentPath.contains(Integer.toString(i1-1) + "," + Integer.toString(i2))
							&& i1 >= startX){
						currentPath.add(Integer.toString(i1-1) + "," + Integer.toString(i2));
						i1 -= 1;
					}
					else if(!currentPath.contains(Integer.toString(i1) + "," + Integer.toString(i2-1))
							&& i2 >= startY){
						currentPath.add(Integer.toString(i1) + "," + Integer.toString(i2-1));
						i2 -= 1;
					}
					*/else{
						break;
					}
				}
				
				if(currentPath.size() == totalDistance && !allPaths.contains(currentPath)){
					allPaths.add(currentPath);
					currentPath.clear();
				}
				
				if(allPaths.size() == numOfPaths){
					break;
				}
				
			}
			
			/*
			for(int i = secWidth; i < initWidth; i++){
				System.out.print(pathNum + ": ");
				for(int j = secLength; j < initLength; j++){
					for(int k = width - initWidth; k > 0; k--){
						for(int l = length - initLength; l > 0; l--){
							System.out.print(" (" + (startX+i) + "," + (startY+j) );
						}
					}
				}
			}
			*/
			
			System.out.print(allPaths);
			
		}
		if(width > 0 && length < 0){
			
		}
		if(width < 0 && length > 0){
			
		}
		if(width < 0 && length < 0){
			
		}
		if(width == 0 && length == 0){
			System.out.print("\nThey are on the same point.\n");
		}
		
		//allPaths.
	}
	
	static BigInteger binomial(final int N, final int K) {
	    BigInteger ret = BigInteger.ONE;
	    for (int k = 0; k < K; k++) {
	        ret = ret.multiply(BigInteger.valueOf(N-k))
	                 .divide(BigInteger.valueOf(k+1));
	    }
	    return ret;
	}
	
	/**
	 * This handles getting input and making sure it is an int
	 * 
	 * @param kb The scanner
	 * @param n The "int" of the input
	 * @return n THe int of the input to be used for the hands
	 */
	
	public static int getInput(Scanner kb, int n, String point){
		
		String input;
		
		while(n < 1 || n > 8){
			System.out.print("Please enter the " + point + ": ");
			input = "" + kb.next();
			while(true){
				try{
					
					n = Integer.parseInt(input);
					break;
				}catch(Exception e){
					
					System.out.print("\nNumeric input is prefered\n");
					System.out.print("Please enter the " + point + ": ");
					input = "" + kb.next();
				}				
			}
			
			if(n > 8){
				System.out.print("\nThe grid is only 8 spaces wide.\n");
			}
			if(n < 1){
				System.out.print("\nThe starting space is (1,1).\n");
			}
		}
		return n;
	}
	
	public static void fillArray(int[][] ary){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				ary[i][j] = -1;
			}
		}
	}
	
	public static void printArray(){
		
		System.out.print("Current state of the Grid: \n");
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(" [" + ary[i][j] + "],\t");
			}
			System.out.print("\n");
		}
	}
}
