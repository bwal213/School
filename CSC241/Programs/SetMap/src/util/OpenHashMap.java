package util;
 
import java.util.AbstractMap;
import java.util.Arrays;

import adapter.MapAdapter;

public class OpenHashMap<K, V> extends MapAdapter<K, V> {
  private static final long serialVersionUID = 1L;
 
  private static final int DEFAULT_CAPACITY = 101;
  private static final float DEFAULT_LOADFACTOR = 0.75F;
 
  private static class Node<K,V> {
    K key;
    V value;
    Node<K,V> next;
    Node(K key, V value, Node<K,V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
 
  private float loadFactor;
  private int size = 0;
  private Node<K,V>[] bucket;
 
  @SuppressWarnings("unchecked")
  public OpenHashMap(int capacity, float loadFactor) {
    capacity = primeUp(capacity); // we need a prime
    bucket = (Node<K, V>[]) new Node[capacity];
    this.loadFactor = loadFactor;
  }
 
  public OpenHashMap(int capacity) {
    this(capacity, DEFAULT_LOADFACTOR);
  }
 
  public OpenHashMap() {
    this(DEFAULT_CAPACITY, DEFAULT_LOADFACTOR);
  }
 
  @Override
  public int size() { return size; }
 
  private int hash(Object obj) {
    return Math.abs(obj.hashCode() % bucket.length);
  }
 
  //--------- put and get ---------
 
  private Node<K,V> search(Object obj) {
    int num = hash(obj);
    Node<K,V> n = bucket[num];
    while (n != null) {
      if (n.key.equals(obj)) {
        break;
      } 
      n = n.next;
    }
    return n;
  }
 
  @Override
  public V put(K key, V value) {
    if (key == null) {
      throw new java.lang.IllegalArgumentException("null not allowed");
    }
    Node<K,V> foundAt = search(key);
 
    if (foundAt != null) {
      V old_value =  foundAt.value;
      foundAt.value = value;
      return old_value;
    } else {
      ++size;
      float load = (float) size / bucket.length;
 
      if (load > loadFactor) {
        rehash();
      }
      int num = hash(key);
      bucket[num] = new Node<>(key, value, bucket[num]);
      return null;
    }
  }
 
  @Override
  public V get(Object obj) {
    if (obj == null) {
      throw new java.lang.IllegalArgumentException("null not allowed");
    }
    Node<K,V> foundAt = search(obj);
    if (foundAt != null) {
      return foundAt.value;
    } else {
      return null;
    }
  }
 
  @Override
  public boolean containsKey(Object obj) {
    if (obj == null) {
      throw new java.lang.IllegalArgumentException("null not allowed");
    }
    Node<K,V> foundAt = search(obj);
    return foundAt != null;
  }
 
  //-------------------------------
 
  private Object[] toArray() {
    Object[] arr = new Object[size];
    int i = 0;
    for (Node<K,V> n : bucket) {
      Node<K,V> curr;
      for (curr = n; curr != null; curr = curr.next) {
        arr[i++] = new AbstractMap.SimpleEntry<>(curr.key, curr.value);
      }
    }
    return arr;
  }
 
  @Override
  public String toString() { return Arrays.toString(toArray()); }
 
  @SuppressWarnings("unchecked")
  public void tableOutput() {
    System.out.println("==> capacity: " + bucket.length);
    System.out.println("==> loadFactor: " + loadFactor);
    System.out.println("==> size: " + size);
    System.out.println("==> load: " + (float)size/bucket.length);
    Node<K,V> curr;
    for (int i = 0; i < bucket.length; ++i) {
      curr = bucket[i];
      if (curr != null) {
        System.out.print(i + ":");
        while (curr != null) {
          System.out.print(curr.key + "=" + curr.value + " ");
          curr = curr.next;
        }
        System.out.println();
      }
    }
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
    int capacity = primeUp(2*bucket.length);
    Node<K,V>[] old_bucket = bucket;
    bucket = (Node<K,V>[]) new Object[capacity];
    for (int i = 0; i < old_capacity; ++i) {
      Node<K,V> n = old_bucket[i];
      while (n != null) {
        int index = hash(n.key);  // using the new hash function
        bucket[index] = new Node<>(n.key, n.value, bucket[index]);
        n = n.next;
      }
    }
  }
}