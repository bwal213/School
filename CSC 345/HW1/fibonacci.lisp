(defun fibonacci (n)
  "a double recursive fibonacci function"
  (cond ((equal n 0) 0)
	((equal n 1) 1)
	(t(+ (fibonacci(- n 1)) (fibonacci (- n 2)))))
  )

(defun fibonacci-TR (n)
  "a tail recursive fibonacci function"
  (labels ((fib-tr (n k1 k2)
	     (cond ((equal n 0) k1)
		   (t(fib-tr (- n 1) k2 (+ k1 k2))))))
	   (fib-tr n 0 1)))
