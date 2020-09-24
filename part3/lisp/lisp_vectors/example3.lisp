(setq a (make-array 5 :fill-pointer 0))
(write a)

(vector-push 'a a)
(vector-push 'b a)
(vector-push 'c a)

(terpri)
(write a)
(terpri)

(vector-push 'd a)
(vector-push 'e a)

;this will not be entered as the vector limit is 5
(vector-push 'f a)

(write a)
(terpri)

(vector-pop a)
(vector-pop a)
(vector-pop a)

(write a)