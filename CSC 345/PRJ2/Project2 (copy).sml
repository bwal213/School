(*
;;;=================================================================
;;;Ben Walker
;;;12-10-18
;;;CSC345: ML Project
;;;=================================================================
*)

(*
;;;=================================================================
;;; This was provided beforehand.
;;; Establishes a datatype of bTree.
*)
datatype 'a BT = empty | bTree of 'a * 'a BT * 'a BT;

(*
;;;=================================================================
;;; This was provided beforehand.
;;; Establishes a datatype of X.
*)
datatype X = A|B|C|D|E|F|G|H;

val t1 = bTree(1,
	       bTree(2,bTree(3,empty, empty), bTree(4,empty, empty)),
	       bTree(5,bTree(6,empty, empty), bTree(7,empty, empty)));

val t2 = bTree(A,
	       bTree(B,bTree(D,empty, empty), bTree(E,empty, empty)),
	       bTree(C,bTree(F,empty, empty), bTree(G,empty, empty)));

val t3 = bTree(1.22,bTree(2.33,empty, empty),bTree(3.44,empty, empty));

val t4 =  bTree("A", 
	       bTree("B",
		    bTree("C",bTree("E",empty,empty), empty), 
		    bTree("D",
			 bTree("F",empty,empty), 
			 bTree("G",bTree("H",empty,empty), empty))),
	       bTree("I",
		    bTree("J",empty, bTree("K",
				      bTree("L",empty, empty),
				      bTree("M",empty, empty))),
		    empty));


(*
;;;=================================================================
;;;    NAME: Postorder
;;;  ARG(S): A bTree.
;;; RETURNS: Returns a list of a binary tree in post-order format.
*)
fun Postorder (empty) = nil
  | Postorder (bTree(root,right,left))
    = Postorder(right) @ Postorder(left) @ [root];

(*
;;;=================================================================
;;;    NAME: Preorder
;;;  ARG(S): A bTree.
;;; RETURNS: Returns a list of a binary tree in pre-order format.
*)
fun Preorder (empty) = nil
  | Preorder (bTree(root,right,left))
    = root :: Preorder(right) @ Preorder(left);

(*
;;;=================================================================
;;;    NAME: Inorder
;;;  ARG(S): A bTree.
;;; RETURNS: Returns a list of a binary tree in in-order format.
*)
fun Inorder (empty) = nil
  | Inorder (bTree(root,right,left))
    = Inorder(right) @ [root] @ Inorder(left);

(*
;;;=================================================================
;;;    NAME: printReal
;;;  ARG(S): A real.
;;; RETURNS: Returns void, prints the string value of a real.
*)
fun printReal n = print(Real.toString n) ;

(*
;;;=================================================================
;;;    NAME: printInt
;;;  ARG(S): An int.
;;; RETURNS: Returns void, prints the string value of an int.
*)
fun printInt n = print(Int.toString n);

(*
;;;=================================================================
;;;    NAME: printX
;;;  ARG(S): A valuetype X.
;;; RETURNS: Returns void, prints a correlated string.
*)
fun printX A = print "A"
  | printX B = print "B"
  | printX C = print "C"
  | printX D = print "D"
  | printX E = print "E"
  | printX F = print "F"
  | printX G = print "G"
  | printX H = print "H";

(*
;;;=================================================================
;;;    NAME: indentlevel
;;;   VALUE: 2
*)
val indentlevel = 2;

(*
;;;=================================================================
;;;    NAME: flip
;;;  ARG(S): A list.
;;; RETURNS: Returns a list with elements rearranged.
*)
fun tab 0 = print ""
  | tab n = (print " "; tab(n-1));

(*
;;;=================================================================
;;;    NAME: displaynode
;;;  ARG(S): A variable, an int, and the print type.
;;; RETURNS: Returns void, prints a node.
*)
fun displaynode (var, n, printType)
  = (tab n; printType(var); print "\n");

(*
;;;=================================================================
;;;    NAME: dash
;;;  ARG(S): An int.
;;; RETURNS: Returns void, or the result of displaynode.
*)
fun dash n = displaynode("-", n, print);(*print "-\n";*)

(*
;;;=================================================================
;;;    NAME: displaytreeindent
;;;  ARG(S): A bTree, an int, and a print type.
;;; RETURNS: Returns void, prints a binary tree.
*)
fun displaytreeindent (empty, n, printType) = dash(n)
  | displaytreeindent (bTree(root,empty,empty), n, printType)
    = displaynode (root, n, printType)
  | displaytreeindent (bTree(root,right,left), n, printType)
    = (displaynode (root, n, printType);
       displaytreeindent(right, n+indentlevel, printType);
       displaytreeindent(left, n+indentlevel, printType));

(*
;;;=================================================================
;;;    NAME: Displaytree
;;;  ARG(S): A bTree, and a print type.
;;; RETURNS: Returns void, or the result of displaytreeindent.
*)
fun Displaytree (something,printType) = displaytreeindent(something, 0, printType);


