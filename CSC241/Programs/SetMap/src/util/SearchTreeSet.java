package util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.SortedSet;

import adapter.NavSetAdapter;

import java.util.Collection;

public class SearchTreeSet<E> extends NavSetAdapter<E> {

  private static final long serialVersionUID = 1L;

  private static class Node<E> {
    E data;
    Node<E> left, right;

    Node(E data, Node<E> left, Node<E> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
  private Node<E> root = null;
  private int size = 0;
  private Comparator<? super E> cmp = null;

  public SearchTreeSet(Comparator<? super E> cmp) {
    this.cmp = cmp;
  }

  public SearchTreeSet() {
  }

  @SuppressWarnings("unchecked")
  private int myCompare(E lhs, E rhs) {
    if (cmp == null) {
      return ((Comparable<E>) lhs).compareTo(rhs);
    }
    else {
      return cmp.compare(lhs, rhs);
    }
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

  @Override
  public java.util.Comparator<? super E> comparator() {
    return cmp;
  }

  private boolean contains(Node<E> n, E elt) {
    if (n == null) {
      return false;
    }
    int comp = myCompare(elt, n.data);
    if (comp < 0) {
      return contains(n.left, elt);
    }
    else if (comp > 0) {
      return contains(n.right, elt);
    }
    else {
      return true;
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean contains(Object obj) {
    E elt = (E) obj;
    return contains(root, elt);
  }

  private Node<E> add(Node<E> n, E elt) {
    if (n == null) {
      return new Node<>(elt, null, null);
    }
    int comp = myCompare(elt, n.data);
    if (comp < 0) {
      n.left = add(n.left, elt);
      return n;
    }
    else if (comp > 0) {
      n.right = add(n.right, elt);
      return n;
    }
    else {
      return n;
    }
  }

  @Override
  public boolean add(E elt) {
    if (this.contains(elt)) {
      return false;
    }
    root = add(root, elt);
    ++size;
    return true;
  }
  
  @Override
  public boolean addAll(Collection<? extends E> c) {
    boolean ret = false;
    for(E elt: c) {
      ret |= add(elt);
    }
    return ret;
  }

  private E findMin(Node<E> n) {
    if (n.left == null) {
      return n.data;
    }
    else {
      return findMin(n.left);
    }
  }

  private E findMax(Node<E> n) {
    if (n.right == null) {
      return n.data;
    }
    else {
      return findMax(n.right);
    }
  }

  private Node<E> removeMin(Node<E> n) {
    if (n.left == null) {
      return n.right;
    }
    else {
      n.left = removeMin(n.left);
      return n;
    }
  }

  private Node<E> removeMax(Node<E> n) {
    if (n.right == null) {
      return n.left;
    }
    else {
      n.right = removeMax(n.right);
      return n;
    }
  }

  // used to randomly choose findMin/findMax in remove operations
  private final Random flipACoin = new Random();

  private Node<E> remove(Node<E> n, E elt) {
    if (n == null) {
      return null;
    }
    int comp = myCompare(elt, n.data);
    if (comp < 0) {
      n.left = remove(n.left, elt);
      return n;
    }
    if (comp > 0) {
      n.right = remove(n.right, elt);
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
      n.data = findMin(n.right);
      n.right = removeMin(n.right);
    }
    else {
      n.data = findMax(n.left);
      n.left = removeMax(n.left);
    }
    return n;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean remove(Object obj) {
    E elt = (E) obj;
    if (this.contains(elt)) {
      root = remove(root, elt);
      --size;
      return true;
    }
    return false;
  }

  // structure-revealing operations
  private String indentString = "   ";

  public void setIndentString(String indentString) {
    this.indentString = indentString;
  }

  public void inorderOutput() {
    inorderOutput(root, 0);
  }

  public void reverseInorderOutput() {
    reverseInorderOutput(root, 0);
  }

  public void preorderOutput() {
    preorderOutput(root, 0);
  }

  public void postorderOutput() {
    postorderOutput(root, 0);
  }

  private String repeat(String str, int times) {
    return new String(new char[times]).replace("\0", str);
  }

  private void inorderOutput(Node<E> n, int level) {
    if (n != null) {
      inorderOutput(n.left, level + 1);
      System.out.println(repeat(indentString, level) + n.data);
      inorderOutput(n.right, level + 1);
    }
  }

  private void reverseInorderOutput(Node<E> n, int level) {
    if (n != null) {
      reverseInorderOutput(n.right, level + 1);
      System.out.println(repeat(indentString, level) + n.data);
      reverseInorderOutput(n.left, level + 1);
    }
  }

  private void preorderOutput(Node<E> n, int level) {
    if (n != null) {
      System.out.println(repeat(indentString, level) + n.data);
      preorderOutput(n.left, level + 1);
      preorderOutput(n.right, level + 1);
    }
  }

  private void postorderOutput(Node<E> n, int level) {
    if (n != null) {
      postorderOutput(n.left, level + 1);
      postorderOutput(n.right, level + 1);
      System.out.println(repeat(indentString, level) + n.data);
    }
  }

  // toArray is basically an inorder traversal.
  // The incoming index marks the last position in the array before
  // execution, and the return value marks the last position in
  // the array after execution.
  private int toArray(Object[] arr, int index, Node<E> n) {
    if (n == null) {
      return index;
    }
    else {
      index = toArray(arr, index, n.left);
      arr[index++] = n.data;
      return toArray(arr, index, n.right);
    }
  }

  @Override
  public Object[] toArray() {
    Comparable[] arr = new Comparable[size];
    toArray(arr, 0, root);
    return arr;
  }

  @Override
  public String toString() {
    return java.util.Arrays.toString(toArray());
  }

  @SuppressWarnings("unchecked")
  @Override
  public Iterator<E> iterator() {
    return Arrays.asList((E[]) toArray()).listIterator();
  }
  
  //------------------------ added by Ben Walker
  
  @Override
  public E last(){
	  Node<E> n = root;
	  if(n == null){
		  throw new NoSuchElementException();
	  }
	  while(n != null){
		  if (n.right == null) {
		      return n.data;
		  }
		  else {
		      n = n.right;
		  }
	  }
	  return null;
  }
  
  @Override
  public E pollLast(){
	  Node<E> n = root;
	  if(n == null){
		  return null;
	  }
	  while(n != null){
		  if (n.right == null){
			  Node<E> tmp = n;
			  remove(n.data);
		      return tmp.data;
		  }
		  else {
		      n = n.right;
		  }
	  }
	  return null;
  }
  
  @Override
  public SortedSet<E> tailSet(E fromElement){
	  if(fromElement == null){
		  throw new NullPointerException();
	  }
	  SortedSet<E> set = new SearchTreeSet<>();
	  tailSet(root, fromElement, set);
	  return set;
  }
  
  private void tailSet(Node<E> n, E elt, SortedSet<E> set) {
	  try{
		  int comp = myCompare(n.data,elt);
		  //System.out.println(comp + "\t" + elt + "\t" + n.data);
		  
		  if(comp >= 0){
			  set.add(n.data);
		  }
		  if(n.left != null){
			  tailSet(n.left, elt, set);
		  }
		  if(n.right != null){
			  tailSet(n.right, elt, set);
		  }
	  }
	  catch(ClassCastException e){
		  System.out.println(e);
		  throw new ClassCastException();
	  }
	  catch(IllegalArgumentException e){
		  System.out.println(e);
		  throw new IllegalArgumentException();
	  }
  }
  
  @Override
  public E ceiling(E elt){
	  if(elt == null){
		  throw new NullPointerException();
	  }
	  Node<E> n = root;
	  if(n == null){
		  return null;
	  }
	  Node<E> n2 = n;
	  try{
		  while(true){
			  if(myCompare(n.data, elt) > 0){
				  if(n.left == null){
					  return n.data;
				  }
				  n2 = n;
				  n = n.left;
			  }
			  else if(myCompare(n.data, elt) < 0){
				  if(n.right == null){
					  return n2.data;
				  }
				  n = n.right;
			  }
			  else if(myCompare(n.data, elt) == 0){
				  return n.data;
			  }
		  }
	  }
	  catch(ClassCastException e){
		  System.out.println(e);
		  throw new ClassCastException();
	  }
  }
}
