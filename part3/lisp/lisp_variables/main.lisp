;; 全局变量

(defvar x 234)
(format t "x = ~2d " x )

;; 局部变量
(setq x 10)
(setq y 20)
(format t "x = ~2d y = ~2d ~%" x y)


(setq x 100)
(setq y 200)
(format t "x = ~2d y = ~2d" x y)



;; let 的使用

(let ((x 'a) (y 'b)(z 'c))
  (format t "x = ~a y = ~a z = ~a" x y z)
)


;; prog 使用
(prog ((x '(a b c))(y '(1 2 3))(z '(p q 10)))
   (format t "x = ~a y = ~a z = ~a" x y z))

