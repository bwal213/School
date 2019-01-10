package demo;
  
public class ShowHashCodes {
  public static void main(String[] args) {
    for ( Object obj :
      new Object[] { "a", "A", new Integer(10), "a0", "a1", new Float(10.0) } )
    {
      System.out.println(obj.hashCode());
    }
 
    int capacity = 11;
    String[] strings = {"music", "beer", "afterlife", "wisdom",
                    "politics", "theater", "schools", "painting", "fear"};
    for (String s : strings) {
      System.out.println(
        '"' + s + '"'
        + "\n\thash code: " + s.hashCode()
        + "\n\tarray index: " + Math.abs(s.hashCode() % capacity)
      );
    }
  }
}