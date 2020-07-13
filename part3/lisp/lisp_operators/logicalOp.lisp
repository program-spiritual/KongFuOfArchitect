;;and 从左到右评估参数。
;;如果所有参数的计算结果均为非nil，则返回最后一个参数的值。
;;否则返回nil。

;; or 自变量从左到右求值，直到一个值不为nil，在这种情况下，返回参数值，否则返回nil。

;; not  它接受一个参数，如果参数的值为nil，则返回t。

(setq a 10)
(setq b 20)

(format t "~% A and B is ~a" (and a b))
(format t "~% A or B is ~a" (or a b))
(format t "~% not A is ~a" (not a))

(terpri)
(setq a nil)
(setq b 5)

(format t "~% A and B is ~a" (and a b))
(format t "~% A or B is ~a" (or a b))
(format t "~% not A is ~a" (not a))

(terpri)
(setq a nil)
(setq b 0)

(format t "~% A and B is ~a" (and a b))
(format t "~% A or B is ~a" (or a b))
(format t "~% not A is ~a" (not a))

(terpri)
(setq a 10)
(setq b 0)
(setq c 30)
(setq d 40)

(format t "~% Result of and operation on 10, 0, 30, 40 is ~a" (and a b c d))
(format t "~% Result of and operation on 10, 0, 30, 40 is ~a" (or a b c d))

(terpri)
(setq a 10)
(setq b 20)
(setq c nil)
(setq d 40)

(format t "~% Result of and operation on 10, 20, nil, 40 is ~a" (and a b c d))
(format t "~% Result of and operation on 10, 20, nil, 40 is ~a" (or a b c d))


