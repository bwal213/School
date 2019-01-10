package util;
 
import adapter.SetAdapter;

public class ClosedHashSet<E> extends SetAdapter<E> {
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_CAPACITY = 101;
  private static final float DEFAULT_LOADFACTOR = 0.75F;
 
  private float loadFactor;
  private int size = 0;
  private Object[] data;
 
  private class Deleted<E> {
    E value;
    Deleted(E value) {
      this.value = value;
    }
    @Override
    public String toString() { return value.toString(); }
  }
 
  // set this to the desired probe method
  //
  private final String whichProbe
  = "linear"
  //= "quadratic"
  //= "double-hash"
    ;
   
  @Override
  public int size() {
    return size;
  }
 
  protected int hash(Object obj) {
    return Math.abs(obj.hashCode() % data.length);
  }
 
  @SuppressWarnings("unchecked")
  public ClosedHashSet(int capacity, float loadFactor) {
    capacity = primeUp(capacity);
    data = (E[]) new Object[capacity];
    this.loadFactor = loadFactor;
  }
 
  public ClosedHashSet(int capacity) {
    this(capacity, DEFAULT_LOADFACTOR);
  }
 
  public ClosedHashSet() {
    this(DEFAULT_CAPACITY, DEFAULT_LOADFACTOR);
  }
 
  @SuppressWarnings("unchecked")
  private int linear_probe(Object obj) {
    int pos = hash(obj);
    int first_del_pos = -1; // first deleted position marker
    while (true) {
      if (data[pos] == null) {  // reached end of the probe path
        if (first_del_pos == -1) {
          return pos;               // no deleted elements discovered
        } else {
          return first_del_pos;     // found deleted element != obj
        }
      } 
      else if (data[pos].equals(obj)) {
        return -(pos+1);
      } 
      else if (data[pos] instanceof Deleted) {
        if (((Deleted<E>)data[pos]).value.equals(obj)) {  // previously deleted
          return pos;
        } 
        else if (first_del_pos == -1) {  // first deleted position unset
          first_del_pos = pos;
        }
        pos = (pos + 1) % data.length;
      } 
      else {
        pos = (pos + 1) % data.length;
      }
    }
  }
 
  @SuppressWarnings("unchecked")
  private int quadratic_probe(Object obj) {
    int pos = hash(obj);
    int i = 1;
    int first_del_pos = -1; // first deleted position marker
    while (true) {
      if (data[pos] == null) {  // reached end of the probe path
        if (first_del_pos == -1) {
          return pos;               // no deleted elements discovered
        } else {
          return first_del_pos;     // found deleted element != obj
        }
      } else if (data[pos].equals(obj)) {
        return -(pos+1);
      } else if (data[pos] instanceof Deleted) {
        if (((Deleted<E>)data[pos]).value.equals(obj)) {  // previously deleted
          return pos;
        } else if (first_del_pos == -1) {  // first deleted position unset
          first_del_pos = pos;
        }
        pos = (pos + i) % data.length;
        i += 2;
      } else {
        pos = (pos + i) % data.length;
        i += 2;
      }
    }
  }
 
  private int hash2(Object obj) {
    int max = data.length - 2;
    return max - Math.abs(obj.hashCode() % max);
  }
 
  @SuppressWarnings("unchecked")
  private int double_hash_probe(Object obj) {
    int pos = hash(obj);
    int amt = hash2(obj);
    int first_del_pos = -1; // first deleted position marker
    while (true) {
      if (data[pos] == null) {  // reached end of the probe path
        if (first_del_pos == -1) {
          return pos;               // no deleted elements discovered
        } else {
          return first_del_pos;     // found deleted element != obj
        }
      } 
      else if (data[pos].equals(obj)) {
        return -(pos+1);
      } 
      else if (data[pos] instanceof Deleted) {
        if (((Deleted<E>)data[pos]).value.equals(obj)) {  // previously deleted
          return pos;
        } 
        else if (first_del_pos == -1) {  // first deleted position unset
          first_del_pos = pos;
        }
        pos = (pos + amt) % data.length;
      } 
      else {
        pos = (pos + amt) % data.length;
      }
    }
  }
 
  private int probe(Object obj) {
    if (whichProbe.equals("linear")) {
      return linear_probe(obj);
    } else if (whichProbe.equals("quadratic")) {
      return quadratic_probe(obj);
    } else if (whichProbe.equals("double-hash")) {
      return double_hash_probe(obj);
    } else {
      throw new IllegalStateException("probe");
    }
  }
 
  @Override
  public boolean add(E elt) {
    int pos = probe(elt);
    if (pos < 0) {
      return false;
    } else {
      ++size;
      data[pos] = elt;
      return true;
    }
  }
 
  @Override
  public boolean contains(Object obj) {
    return probe(obj) < 0;
  }
 
  @Override
  @SuppressWarnings("unchecked")
  public boolean remove(Object obj) {
    int pos = probe(obj);
    if (pos >= 0) {
      return false;
    } else {
      --size;
      int del_pos = -(pos+1);
      data[del_pos] = new Deleted<>(data[del_pos]);
      return true;
    }
  }
 
  public void tableOutput() {
    System.out.println("----------------------------");
    System.out.println("==> probe method: " + whichProbe);
    System.out.println("==> capacity: " + data.length);
    System.out.println("==> loadFactor: " + loadFactor);
    System.out.println("==> size: " + size);
    System.out.println("==> load: " + (float) size / data.length);
    for (int i = 0; i < data.length; ++i) {
      if (data[i] != null) {
        System.out.print(i + ":");
        if (data[i] instanceof Deleted){
          System.out.println("["+data[i]+"]");
          continue;
        } else {
          System.out.print(data[i]);
        }
        int h = hash(data[i]);
        if (h == i) {
          System.out.println(" (*)");
        } else {
          System.out.print(" (hash=" + h);
          if (whichProbe.equals("double-hash")) {
            System.out.print(", hash2=" + hash2(data[i]));
          }
          System.out.println(")");
        }
      }
    }
    System.out.println("----------------------------");
  }
 
  // returns the next prime >= n
  private static int primeUp(int n) {
    int prime = n;
    if (prime % 2 == 0) {
      prime += 1;
    }
    boolean found_prime;
    do {
      found_prime = true;
      for (int i = 3; i <= Math.sqrt(prime); i += 2) {
        if (prime % i == 0) {
          found_prime = false;
          prime += 2;
          break;
        }
      }
    } while (!found_prime);
    return prime;
  }
}