(*
;;;=================================================================
;;;Ben Walker
;;;11-14-18
;;;CSC345: ML Homework
;;;=================================================================
*)

(*
;;;=================================================================
;;;    NAME: flip
;;;  ARG(S): A list.
;;; RETURNS: Returns a list with elements rearranged.
*)

fun flip (nil) = nil
  | flip (x::y::xys) = [y] @ [x] @ flip (xys)
  | flip (x::xs) = [x] @ flip (xs);

(*
;;;=================================================================
;;;    NAME: deleteIth
;;;  ARG(S): A list, and an int.
;;; RETURNS: Returns a list without the element at the position of the int.
*)

fun deleteIth (x::xs, i: int) = if (i > 1)    
				then [x] @ deleteIth (xs,i-1)
				else (xs)
  | deleteIth (nil, i: int) = nil;

(*
;;;=================================================================
;;;    NAME: vowel
;;;  ARG(S): A char.
;;; RETURNS: Returns true or false.
*)

fun vowel (v) = if (v = #"a") orelse (v = #"A") orelse
		   (v = #"e") orelse (v = #"E") orelse
		   (v = #"i") orelse (v = #"I") orelse
		   (v = #"o") orelse (v = #"O") orelse
		   (v = #"u") orelse (v = #"U") then true
		else false;

(*
;;;=================================================================
;;;    NAME: pigSub
;;;  ARG(S): A char list.
;;; RETURNS: Returns a char list.
*)

fun pigSub (nil, bool) = nil
  | pigSub (x::xs, true) = if (vowel x)
				   then ([x] @ (xs) @ [#"y", #"a", #"y"])
				   else pigSub ((xs) @ [x], false)
  | pigSub (x::xs, false) = if (vowel x)
				    then ([x] @ (xs) @ [#"a", #"y"])
				    else pigSub ((xs) @ [x], false)

(*
;;;=================================================================
;;;    NAME: flip
;;;  ARG(S): A string.
;;; RETURNS: Returns a string.
*)
						
fun piglatinize (str) = implode(pigSub (explode (str), true));
