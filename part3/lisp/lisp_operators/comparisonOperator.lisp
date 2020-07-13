
(setq a 10)
(setq b 20)
;;检查操作数的值是否全部相等，如果是，则条件为真。
(format t "~% A==B is ~a" (= a b))
;; 检查操作数的值是否全部不同，如果值不相等，则条件为真。
(format t "~% A /= B is ~a" (/= a b))
;; 检查操作数的值是否单调递减。
(format t "~% A > B is ~a" (> a b))
;;检查操作数的值是否单调递增。
(format t "~% A < B is ~a" (< a b))
;; 检查任何左操作数的值是否大于或等于下一个右操作数的值，如果是，则条件为true。
(format t "~% A >= B is ~a" (>= a b))
;; 检查任何左操作数的值是否小于或等于其右操作数的值，如果是，则条件为true。
(format t "~% A <= B is ~a" (<= a b))
;; 它比较两个或多个参数并返回最大值。
(format t "~% Max of A and B is ~d" (max a b))
;; 它比较两个或多个参数并返回最小值。
(format t "~% Min of A and B is ~d" (min a b))
