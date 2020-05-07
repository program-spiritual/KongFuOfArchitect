(setq a 60)
(setq b 13)

(format t "~% BITWISE AND of a and b is ~a" (logand a b))
(format t "~% BITWISE INCLUSIVE OR of a and b is ~a" (logior a b))
(format t "~% BITWISE EXCLUSIVE OR of a and b is ~a" (logxor a b))
(format t "~% A NOT B is ~a" (lognor a b))
(format t "~% A EQUIVALANCE B is ~a" (logeqv a b))

(terpri)
(terpri)

(setq a 10)
(setq b 0)
(setq c 30)
(setq d 40)

(format t "~% Result of bitwise and operation on 10, 0, 30, 40 is ~a" (logand a b c d))
(format t "~% Result of bitwise or operation on 10, 0, 30, 40 is ~a" (logior a b c d))
(format t "~% Result of bitwise xor operation on 10, 0, 30, 40 is ~a" (logxor a b c d))
(format t "~% Result of bitwise eqivalance operation on 10, 0, 30, 40 is ~a" (logeqv a b c d))
