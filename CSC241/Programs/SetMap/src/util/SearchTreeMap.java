package util;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import adapter.NavMapAdapter;
import adapter.SetAdapter;

public class SearchTreeMap<K, V> extends NavMapAdapter<K, V> {
  private static final long serialVersionUID = 1L;

  private static class Node<K, V> {
    K key;
    V value;
    Node<K, V> left, right;

    Node(K key, V value, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
  private Node<K, V> root = null;
  private int size = 0;
  private Comparator<? super K> cmp = null;

  public SearchTreeMap(Comparator<? super K> cmp) {
    this.cmp = cmp;
  }

  public SearchTreeMap() {
  }

  @SuppressWarnings("unchecked")
  private int myCompare(K lhs, K rhs) {
    if (cmp == null) {
      return ((Comparable) lhs).compareTo(rhs);
    }
    else {
      return cmp.compare(lhs, rhs);
    }
  }

  @Override
  public java.util.Comparator<? super K> comparator() {
    return cmp;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  private Node<K, V> seach(Node<K, V> n, K key) {
    if (n == null) {
      return null;
    }
    int comp = myCompare(key, n.key);
//    if (comp == 0){
//    	return n;
//    }
    if (comp < 0) {
      return seach(n.left, key);
    }
    if (comp > 0) {
      return seach(n.right, key);
    }
    return n;
  }

  @Override
  @SuppressWarnings("unchecked")
  public V get(Object obj) {
    K key = (K) obj;
    Node<K, V> n = seach(root, key);
    if (n == null) {
      return null;
    }
    return n.value;
  }

  private Node<K, V> put(Node<K, V> n, K key, V value) {
    if (n == null) {
      return new Node<>(key, value, null, null);
    }
    int comp = myCompare(key, n.key);
    if (comp < 0) {
      n.left = put(n.left, key, value);
      return n;
    }
    if (comp > 0) {
      n.right = put(n.right, key, value);
      return n;
    }
    // we never get here based on the public put call
    return n;
  }

  @Override
  public V put(K key, V value) {
    Node<K, V> n = seach(root, key);
    if (n == null) {                  // key was not in tree
      root = put(root, key, value);   // we must add it
      ++size;
      return null;
    }
    else {  // key was in tree, we replace value
      V old_value = n.value;
      n.value = value;
      return old_value;  // return the old value
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean containsKey(Object obj) {
    K key = (K) obj;
    return seach(root, key) != null;
  }

  @SuppressWarnings("unchecked")
  private int entryArray(Object[] arr, int index, Node n) {
    if (n == null) {
      return index;
    }
    else {
      index = entryArray(arr, index, n.left);
      arr[index++] = new AbstractMap.SimpleEntry(n.key, n.value);
      return entryArray(arr, index, n.right);
    }
  }

  public class EntrySet extends SetAdapter {
    Object[] arr;

    EntrySet(Object[] arr) {
      this.arr = arr;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
      return new Iterator<Map.Entry<K, V>>() {
        int i = 0;

        @Override
        public boolean hasNext() {
          return i < arr.length;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Map.Entry<K, V> next() {
          return (Map.Entry<K, V>) arr[i++];
        }

        @Override
        public void remove() {
          throw new UnsupportedOperationException("Not supported.");
        }
      };
    }
  }

  @Override
  public String toString() {
    Object[] arr = new Object[size];
    entryArray(arr, 0, root);
    return java.util.Arrays.toString(arr);
  }

  @Override
  @SuppressWarnings("unchecked")
  public Set<Map.Entry<K, V>> entrySet() {
    Object[] arr = new Object[size];
    entryArray(arr, 0, root);
    return new EntrySet(arr);
  }

  @Override
  public Collection<V> values() {
    Collection<V> vals = new LinkedList<>();
    addToValues(root, vals);
    return vals;
  }

  private void addToValues(Node<K, V> n, Collection<V> vals) {
    if (n == null) {
      return;
    }
    vals.add(n.value);
    addToValues(n.left, vals);
    addToValues(n.right, vals);
  }

  @Override
  public Set<K> keySet() {
    Set<K> kset = new TreeSet<>();
    addToKeySet(root, kset);
    return kset;
  }

  private void addToKeySet(Node<K, V> n, Set<K> kset) {
    if (n == null) {
      return;
    }
    kset.add(n.key);
    addToKeySet(n.left, kset);
    addToKeySet(n.right, kset);
  }
  private String indentString = "   ";

  public void setIndentString(String indentString) {
    this.indentString = indentString;
  }

  public void reverseInorderOutput() {
    reverseInorderOutput(root, 0);
  }

  private void reverseInorderOutput(Node n, int level) {
    if (n != null) {
      reverseInorderOutput(n.right, level + 1);
      System.out.println(repeat(indentString, level)
          + n.key + "=" + n.value);
      reverseInorderOutput(n.left, level + 1);
    }
  }

  private static String repeat(String str, int times) {
    return new String(new char[times]).replace("\0", str);
  }
  
  //--------------------- added by Ben Walker
  
  //used to randomly choose findMin/findMax in remove operations
  private final Random flipACoin = new Random();
  
  @Override
  public V remove(Object obj){
	  K key = (K) obj;
	  Node<K, V> n = seach(root, key);
	  if (n != null) {
		  //Node<K,V> n = remove(root, key);
	      root = remove(root, key);
		  --size;
	      return n.value;
	  }
	  return null;
  }
    
  private Node<K, V> remove(Node<K, V> n, K key){
	  try{
		if (n == null) {
			return null;
		}
		int comp = myCompare(key, n.key);
		if (comp < 0) {
			n.left = remove(n.left, key);
			return n;
		}
		if (comp > 0) {
			n.right = remove(n.right, key);
			return n;
		}
		if (n.left == null) {
			return n.right;
		}
		if (n.right == null) {
			return n.left;
		}
		
		boolean choose_min = (flipACoin.nextInt(2) == 1);
		if (choose_min) {
		  n.key = findMin(n.right);
		  n.right = removeMin(n.right);
		}
		else {
		  n.key = findMax(n.left);
		  n.left = removeMax(n.left);
		}
		return n;
		//return null;
	  }
	  catch (ClassCastException e){
		  System.out.print(e);
		  throw new ClassCastException();
	  }
	  catch (NullPointerException e){
		  System.out.print(e);
		  throw new ClassCastException();
	  }
  	}
  private K findMin(Node<K, V> n) {
	  if (n.left == null) {
	      return n.key;
	  }
	  else {
	      return findMin(n.left);
	  }
  }

  private K findMax(Node<K, V> n) {
	  if (n.right == null) {
		  return n.key ;
	  }
	  else {
		  return findMax(n.right);
	  }
  }

  private Node<K, V> removeMin(Node<K, V> n) {
	  if (n.left == null) {
		  return n.right;
	  }
	  else {
		  n.left = removeMin(n.left);
		  return n;
	  }
  }
	  
  private Node<K, V> removeMax(Node<K, V> n) {
	  if (n.right == null) {
		  return n.left;
	  }
	  else {
		  n.right = removeMax(n.right);
		  return n;
	  }
  }
}
