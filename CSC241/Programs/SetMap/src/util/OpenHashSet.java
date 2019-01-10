package util;
 
import java.util.Arrays;

import adapter.SetAdapter;

public class OpenHashSet<E> extends SetAdapter<E> {
  private static final long serialVersionUID = 1L;
 
  private static final int DEFAULT_CAPACITY = 101;
  private static final float DEFAULT_LOADFACTOR = 0.75F;
 
  private static class Node<E> {
    E data;
    Node<E> next;
 
    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }
  private float loadFactor;
  private int size = 0;
  private Node<E>[] bucket;
 
  @SuppressWarnings("unchecked")
  public OpenHashSet(int capacity, float loadFactor) {
    capacity = primeUp(capacity); // we need a prime
 
    bucket = (Node<E>[]) new Node[capacity];
    this.loadFactor = loadFactor;
  }
 
  public OpenHashSet(int capacity) {
    this(capacity, DEFAULT_LOADFACTOR);
  }
 
  public OpenHashSet() {
    this(DEFAULT_CAPACITY, DEFAULT_LOADFACTOR);
  }
 
  @Override
  public int size() {
    return size;
  }
 
  private int hash(Object obj) {
    return Math.abs(obj.hashCode() % bucket.length);
  }
 
  @Override
  public boolean contains(Object obj) {
    if (obj == null) {
      throw new java.lang.IllegalArgumentException("null not allowed");
    }
    int index = hash(obj);
    Node<E> n = bucket[index];
    while (n != null) {
      if (n.data.equals(obj)) {
        return true;
      }
      n = n.next;
    }
    return false;
  }
 
  @Override
  public boolean add(E elt) {
    if (elt == null) {
      throw new java.lang.IllegalArgumentException("null not allowed");
    }
    if (contains(elt)) {
      return false;
    }
    ++size;
    if ((float) size / bucket.length > loadFactor) {
      rehash();
    }
    int index = hash(elt);
    bucket[index] = new Node<>(elt, bucket[index]);
    return true;
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
 
  @SuppressWarnings("unchecked")
  private void rehash() {
    System.out.println("****** rehash *******");
    int old_capacity = bucket.length;
    // we must reset capacity because the hash function depends on it
    int capacity = primeUp(2 * bucket.length);
    Node<E>[] old_bucket = bucket;
    bucket = (Node<E>[]) new Node[capacity];
    for (int i = 0; i < old_capacity; ++i) {
      Node<E> n = old_bucket[i];
      while (n != null) {
        int index = hash(n.data);  // using the new hash function
        bucket[index] = new Node(n.data, bucket[index]);
        n = n.next;
      }
    }
  }
 
  @Override
  public boolean remove(Object obj) {
    if (obj == null) {
      throw new java.lang.IllegalArgumentException("null not allowed");
    }
    if (!contains(obj)) {
      return false;
    }
    --size;
    int num = hash(obj);
 
    bucket[num] = remove(bucket[num], obj);
 
    return true;
  }
 
  private Node<E> remove(Node<E> n, Object obj) {
    if (n.data.equals(obj)) {
      return n.next;
    } else {
      n.next = remove(n.next, obj);
      return n;
    }
  }
 
  @SuppressWarnings("unchecked")
  public void tableOutput() {
    System.out.println("----------------------------");
    System.out.println("==> capacity: " + bucket.length);
    System.out.println("==> loadFactor: " + loadFactor);
    System.out.println("==> size: " + size);
    System.out.printf("==> load: %.2f\n", (float) size / bucket.length);
    for (int i = 0; i < bucket.length; ++i) {
      Node<E> n = bucket[i];
      if (n == null) {
        continue;
      }
      System.out.print(i + ": ");
      boolean first = true;
      while (n != null) {
        if (first) { 
          first = false; 
        }
        else {
          System.out.print(", ");
        }
        System.out.print(n.data);
        n = n.next;
      }
      System.out.println();
    }
    System.out.println("----------------------------");
  }
 
  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];
    int i = 0;
    for (Node<E> curr : bucket) {
      while (curr != null) {
        arr[i++] = curr.data;
        curr = curr.next;
      }
    }
    return arr;
  }
 
  @Override
  public String toString() {
    return Arrays.toString(toArray());
  }
}