package util;

import java.util.Comparator;
import adapter.NavSetAdapter;
import java.util.Collection;

public class AVLTreeSet<E> extends NavSetAdapter<E> {
  private static final long serialVersionUID = 1L;

  private static class Node<E> {
    E data;
    Node<E> left, right;
    int height;

    Node(E data, Node<E> left, Node<E> right, int height) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.height = height;
    }

    Node(E data, Node<E> left, Node<E> right) {
      this(data, left, right, 0);
    }
  }

  private Node<E> root = null;
  private int size = 0;
  private Comparator<? super E> cmp = null;

  public AVLTreeSet(Comparator<? super E> cmp) {
    this.cmp = cmp;
  }

  public AVLTreeSet() {
  }

  @SuppressWarnings("unchecked")
  private int myCompare(E lhs, E rhs) {
    if (cmp == null) {
      return ((Comparable) lhs).compareTo(rhs);
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

  private int height(Node<E> p) {
    return (p == null) ? -1 : p.height;
  }

  private Node<E> s_rotate_left(Node<E> n) {
    Node<E> k2 = n;
    Node<E> k1 = k2.left;

    int x = k1.left.height;

    k2.left = k1.right;
    k1.right = k2;

    k2.height = x;
    k1.height = x + 1;

    return k1;
  }

  private Node<E> s_rotate_right(Node<E> n) {
    Node<E> k1 = n;
    Node<E> k2 = k1.right;

    int z = k2.right.height;

    k1.right = k2.left;
    k2.left = k1;

    k1.height = z;
    k2.height = z + 1;

    return k2;
  }

  private Node<E> d_rotate_left(Node<E> n) {
    Node<E> k3 = n;
    Node<E> k1 = n.left;
    Node<E> k2 = k1.right;

    int a = height(k1.left);

    k1.right = k2.left;
    k3.left = k2.right;
    k2.left = k1;
    k2.right = k3;

    k1.height = 1 + a;
    k3.height = 1 + a;
    k2.height = 2 + a;

    return k2;
  }

  private Node<E> d_rotate_right(Node<E> n) {
    Node<E> k1 = n;
    Node<E> k3 = n.right;
    Node<E> k2 = k3.left;

    int d = height(k3.right);

    k3.left = k2.right;
    k1.right = k2.left;
    k2.left = k1;
    k2.right = k3;

    k1.height = 1 + d;
    k3.height = 1 + d;
    k2.height = 2 + d;

    return k2;
  }

  private boolean showRotations = false;
  private boolean showHeights = false;

  public void setShowRotations(boolean trueORfalse) {
    showRotations = trueORfalse;
  }

  public void setShowHeights(boolean trueORfalse) {
    showHeights = trueORfalse;
  }

  private Node<E> add(E elt, Node<E> n) {
    if (n == null) {
      return new Node<>(elt, null, null);
    }
    int comp = myCompare(elt, n.data);
    if (comp < 0) {
      n.left = add(elt, n.left);

      if (height(n.left) - height(n.right) == 2) {
        int comp1 = myCompare(elt, n.left.data);
        if (comp1 < 0) {
          if (showRotations) {
            System.out.println("s_rotate_left at " + n.data);
          }
          return s_rotate_left(n);   // single rotate on left-left insertion
        }
        else {
          if (showRotations) {
            System.out.println("d_rotate_left at " + n.data);
          }
          return d_rotate_left(n);   // double rotate on left-right insertion
        }
      }
      // reset height
      n.height = Math.max(height(n.left), height(n.right)) + 1;
      return n;
    }
    else /* if (comp > 0) */ {
      n.right = add(elt, n.right);

      if (height(n.right) - height(n.left) == 2) {
        int comp1 = myCompare(elt, n.right.data);
        if (comp1 > 0) {
          if (showRotations) {
            System.out.println("s_rotate_right at " + n.data);
          }
          return s_rotate_right(n);   // single rotate on right-right insertion
        }
        else {
          if (showRotations) {
            System.out.println("d_rotate_right at " + n.data);
          }
          return d_rotate_right(n);   // double rotate on right-left insertion
        }
      }
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        return n;
    }
  }

  @Override
  public boolean add(E elt) {
    if (contains(elt)) {
      return false;
    }
    root = add(elt, root);
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

  // structure-revealing operations
  private String indentString = "   ";

  public void setIndentString(String indentString) {
    this.indentString = indentString;
  }

  public void reverseInorderOutput() {
    reverseInorderOutput(root, 0);
  }

  private String repeat(String s, int times) {
    String output = "";
    for (int i = 0; i < times; ++i) {
      output += s;
    }
    return output;
  }

  private void reverseInorderOutput(Node<E> n, int level) {
    if (n != null) {
      reverseInorderOutput(n.right, level + 1);
      System.out.print(repeat(indentString, level) + n.data);
      if (showHeights) {
        System.out.print("[ht=" + n.height + "]");
      }
      System.out.println();
      reverseInorderOutput(n.left, level + 1);
    }
  }
}
