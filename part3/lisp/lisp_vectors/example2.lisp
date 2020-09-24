(setq a (make-array 5 :initial-element 0))
(setq b (make-array 5 :initial-element 2))

(dotimes (i 5)
   (setf (aref a i) i))
   
(write a)
(terpri)
(write b)
(terpri)