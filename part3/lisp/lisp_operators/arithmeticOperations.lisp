(setq a 10)
(setq b 20)
;; 加
(format t "~% A + B = ~d" (+ a b))
;; 减
(format t "~% A - B = ~d" (- a b))
;; 乘
(format t "~% A x B = ~d" (* a b))
;; 除
(format t "~% B / A = ~d" (/ b a))
;; 增量运算符通过指定的第二个参数来增加整数值
(format t "~% Increment A by 3 = ~d" (incf a 3))
;; 减量运算符通过指定的第二个参数减少整数值
(format t "~% Decrement A by 4 = ~d" (decf a 4))