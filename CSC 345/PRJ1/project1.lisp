;;;=================================================================
;;;Ben Walker
;;;10-30-18
;;;CSC345: Project 1
;;;=================================================================

;;;=================================================================
;;;    NAME: integral
;;;  ARG(S): A function (list), a predefined variable, optionally two numbers.
;;; RETURNS: Returns the solution or equation for the integral of F.

(defun integrate (F V &optional lo hi)
  "This will take in simple integrals and solve them."
  (def-integral (indef-integral F V) V lo hi))


;;;=================================================================
;;;    NAME: indef-integral
;;;  ARG(S): A function (list) and a predefined variable.
;;; RETURNS: Returns the solution or equation for the indefinite integral of F.

(defun indef-integral (F V)
  "This is the indefinite integral function for integrate."
  (cond ((number-p F)(make-product F V))
	((and (power-p F) (equal(power-operand-2 F) -1))(make-log F))
	((power-p F) (make-quotient
		      (make-power (power-operand-1 F) (make-sum (power-operand-2 F) 1))
		      (make-sum (power-operand-2 F) 1)))
	((and(variable-p F)(equal F V))(make-product 1/2 (make-power F 2)))
	((and(variable-p F)(not(equal F V)))(make-product F V))
	((sum-p F)(make-sum (indef-integral (sum-operand-1 F) V)
			    (indef-integral (sum-operand-2 F) V)))
	((difference-p F)(make-difference
			  (indef-integral (difference-operand-1 F) V)
			  (indef-integral (difference-operand-2 F) V)))
	((negative-p F)(make-negative (indef-integral (rest F) V)))
	((and (listp F) (null (rest F))) (indef-integral  (first F) V))
	(t (list nil))
	)
  
  )

;;;=================================================================
;;;    NAME: def-integral
;;;  ARG(S): A function (list), a predefined variable, and two numbers.
;;; RETURNS: Returns the solution for the definite integral of F.

(defun def-integral (F V lo hi)
  "This is the definite integral function for integrate."
  (cond ((and(and (equal lo nil)
		  (equal hi nil))
	     (not(and (numberp lo)
		      (numberp hi))))
	 F)
	((variable-p F) (-(expt hi 1) (expt lo 1)))
	((listp F) (-(eval(my-replace V hi F)) (eval(my-replace V lo F))))
	(t(-(expt hi F) (expt lo F)))
     )
  )

;;;=================================================================
;;;    NAME: my-replace
;;;  ARG(S): two elements then a list
;;; RETURNS: Returns the the list with replacements done

(defun my-replace (e1 e2 L)
  "Will replace the first element \"e1\", with the second element \"e2\","
  + "in the list \"L\", and return that list."	
  (cond ((endp L) nil)
	((equal (first L) e1) (append (list e2) (my-replace e1 e2 (rest L))))
	((listp (first L)) (append (list(my-replace e1 e2 (first L)))
				   (my-replace e1 e2 (rest L))))
	(t(append (list(first L)) (my-replace e1 e2 (rest L))))))
	 

;;;============================================================================
;;; SYMBOLS
;;; These are predefined symbols used in the data.

(defconstant variable-symbols '(U V W X Y Z))
(defconstant negative-symbol '-)
(defconstant sum-symbol '+)
(defconstant difference-symbol '-)
(defconstant product-symbol '*)
(defconstant quotient-symbol '/)
(defconstant power-symbol 'expt)
(defconstant log-symbol 'log)

;;;============================================================================
;;; SELECTORS -- OPERATORS
;;; These are expected locations to find operators in the data.

(defun negative-operator (F) (first F))
(defun sum-operator (F) (first F))
(defun difference-operator (F) (first F))
(defun product-operator (F) (first F))
(defun quotient-operator (F) (first F))
(defun power-operator (F) (first F))
(defun log-operator (F) (first F))

;;; SELECTORS -- OPERANDS
;;; These are expected locations to find operands in the data.

(defun negative-operand (F) (second F))
(defun sum-operand-1 (F) (second F))
(defun sum-operand-2 (F) (third F))
(defun difference-operand-1 (F) (second F))
(defun difference-operand-2 (F) (third F))
(defun product-operand-1 (F) (second F))
(defun product-operand-2 (F) (third F))
(defun quotient-operand-1 (F) (second F))
(defun quotient-operand-2 (F) (third F))
(defun power-operand-1 (F) (second F))
(defun power-operand-2 (F) (third F))
(defun log-operand-1 (F) (second F))
(defun log-operand-2 (F) (third F))

;;;============================================================================
;;; PREDICATES
;;; These are custom predicates for integrate.

;;;=================================================================
;;;    NAME: number-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a number. T or nil.

(defun number-p (F)
  "this is the number predicate for integrate"
  (numberp F)
  )

;;;=================================================================
;;;    NAME: variable-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a variable. T or nil.

(defun variable-p (F)
  "This is the variable predicate for integrate"
  (member F  variable-symbols))

;;;=================================================================
;;;    NAME: negative-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a negative. T or nil.

(defun negative-p (F)
  "This is the negative predicate for integrate"
  (cond ((not(listp F)) nil)
	((and (equal (difference-operator F) difference-symbol)
	      (not(equal (negative-operator F) (difference-operand-1 F)))
	      (not(equal nil (difference-operand-2 F)))
	      ) nil)
	((equal (negative-operator F) negative-symbol) t)
	(t nil))
  )

;;;=================================================================
;;;    NAME: sum-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a summation. T or nil.

(defun sum-p (F)
  "This is the sum predicate for integrate"
  (cond ((and (equal (sum-operator F) sum-symbol)
	      (not(equal nil (sum-operand-2 F)))
	      ) t)
	(t nil))
  )

;;;=================================================================
;;;    NAME: difference-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a difference. T or nil.

(defun difference-p (F)
  "This is the difference predicate for integrate"
  (cond ((and (equal (difference-operator F) difference-symbol)
	      (not(equal (negative-operator F) (difference-operand-1 F)))
	      (not(equal nil (difference-operand-2 F)))
	      ) t)
	(t nil))
  )

;;;=================================================================
;;;    NAME: product-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a product. T or nil.

(defun product-p (F)
  "This is the product predicate for integrate"
  (cond ((and (equal (product-operator F) product-symbol)
	      (not(equal nil (product-operand-2 F)))
	      ) t)
	(t nil))
  )

;;;=================================================================
;;;    NAME: quotient-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a quotient. T or nil.

(defun quotient-p (F)
  "This is the quotient predicate for integrate"
  (cond ((and (equal (quotient-operator F) quotient-symbol)
	      (not(equal nil (quotient-operand-2 F)))
	      ) t)
	(t nil))
  )

;;;=================================================================
;;;    NAME: power-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a exponent. T or nil.

(defun power-p (F)
  "This is the power predicate for integrate"
  (cond ((not(listp F)) nil)
	((and (equal (power-operator F) power-symbol)
	      (not(equal nil (power-operand-2 F)))
	      ) t)
	(t nil))
  )


;;;The folowing function is unused but could be added in the future

;;;=================================================================
;;;    NAME: log-p
;;;  ARG(S): A list.
;;; RETURNS: Returns if the list is a log. T or nil.

;(defun log-p (F)
;  "this is the log predicate for integrate"
;  )

;;;============================================================================
;;; CONSTRUCTORS

;;;=================================================================
;;;    NAME: make-variable
;;;  ARG(S): A variable.
;;; RETURNS: Returns a variable.

(defun make-variable (V)
  "this is the make variable function for integrate"
  V)

;;;=================================================================
;;;    NAME: make-sum
;;;  ARG(S): Two variables.
;;; RETURNS: Returns a list that is a summation or the solution.

(defun make-sum (F G)
  "this is the make sum function for integrate"
  (cond ((eq 0 F) G)
	((eq 0 G) F)

	((and(numberp F)(numberp G))(+ F G))
	(t(list sum-symbol F G))))

;;;=================================================================
;;;    NAME: make-negative
;;;  ARG(S): A variable or list.
;;; RETURNS: Returns a list.

(defun make-negative (F)
  "this is the make negative function for integrate"
  (cond ((negative-p F)(first (rest F)))
	(t (list negative-symbol F)))
  )

;;;=================================================================
;;;    NAME: make-difference
;;;  ARG(S): Two variables.
;;; RETURNS: Returns a list that is a difference.

(defun make-difference (F G)
  "this is the make difference function for integrate"
  (list difference-symbol F G)
  )

;;;=================================================================
;;;    NAME: make-product
;;;  ARG(S): Two variables.
;;; RETURNS: Returns a list that is a product or the solution to it.

(defun make-product (F G)
  "this is the make product function for integrate"
  (cond ((equal 1 F) G)
	((equal 0 F) 0)
	((equal 1 G) F)
	((equal 0 G) 0)
	(t(list product-symbol F G))
	)
  )

;;;=================================================================
;;;    NAME: make-quotient
;;;  ARG(S): Two variables.
;;; RETURNS: Returns a list that is a quotient.

(defun make-quotient (F G)
  "this is the make quotient function for integrate"
  (list quotient-symbol F G)
  )

;;;=================================================================
;;;    NAME: make-power
;;;  ARG(S): Two variables.
;;; RETURNS: Returns a list that is an exponent.

(defun make-power (F G)
  "this is the make power function for integrate"
  (list power-symbol F G)
  )

;;;=================================================================
;;;    NAME: make-log
;;;  ARG(S): A list.
;;; RETURNS: Returns a log.

(defun make-log (F)
  "this is the make log function for integrate"
  (list log-symbol (power-operand-1 F))
  )

