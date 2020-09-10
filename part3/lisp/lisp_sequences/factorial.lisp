
(defun factorial (num)
   (cond ((zerop num) 1)
      (t ( * num (factorial (- num 1))))
   )
)
(setq n 6)
(format t "~% Factorial ~d is: ~d" n (factorial n))