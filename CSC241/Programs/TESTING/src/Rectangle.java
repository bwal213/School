
public class Rectangle extends Square implements IShape{

	Rectangle (){
		
	}
	
	public void doNothing(){
		System.out.println("Hello World");
	}
	
	public static void main(String[] args){
		
		//new IShape().doNothing();
		
		Square rect = new Square();
		rect = new Rectangle();
		
	}
	
}


