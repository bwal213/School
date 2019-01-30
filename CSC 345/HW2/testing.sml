(* comments like this *)

fun function1 (x::xl) = [x] @ function1 (xl)
  | function1 (nil) = nil;


(* From the run to help remember what do

Standard ML of New Jersey v110.78 [built: Thu Jul 23 11:21:58 2015]
- 
[opening /home/bw840606/HW2/testing.sml]
val function1 = fn : 'a list -> 'a list
val it = () : unit
- 
[opening /tmp/emacs-region2466tuE]
val function1 = fn : 'a list -> 'a list
val it = () : unit
- function1(1,2,3,4,5,6,7,8,9);
stdIn:3.1-3.29 Error: operator and operand don't agree [tycon mismatch]
  operator domain: 'Z list
  operand:         [int ty] * [int ty] * [int ty] * [int ty] * [int ty] * 
                   [int ty] * [int ty] * [int ty] * [int ty]
  in expression:
    function1 (1,2,3,4,5,6,7,8,9)
- function1 [1,2,3,4,5,6,7,8,9]
= ;
val it = [1,2,3,4,5,6,7,8,9] : int list
- 

*)

fun reverseBy2 (x::y::xys) = [y] @ [x] @ reverseBy2 (xys)
  | reverseBy2 (x::xs) = [x] @ reverseBy2 (xs)
  | reverseBy2 (nil) = nil;

fun vowel (v) = if (v = #"a") orelse (v = #"A") orelse
		   (v = #"e") orelse (v = #"E") orelse
		   (v = #"i") orelse (v = #"I") orelse
		   (v = #"o") orelse (v = #"O") orelse
		   (v = #"u") orelse (v = #"U") then true
		else false;
    
fun pigSub (nil, bool) = nil
  | pigSub (x::xs, true) = if (vowel x)
				   then ([x] @ (xs) @ [#"y", #"a", #"y"])
				   else pigSub ((xs) @ [x], false)
  | pigSub (x::xs, false) = if (vowel x)
				    then ([x] @ (xs) @ [#"a", #"y"])
				    else pigSub ((xs) @ [x], false)

fun piglatinize (str) = implode(pigSub (explode (str), true));

fun pigSubOld (x::xs) = [x] @ (xs);


fun deleteIth (x::xs, i: int) = if (i > 1)    
				then [x] @ deleteIth (xs,i-1)
				else
				    (xs)
  | deleteIth (nil, i: int) = nil;
