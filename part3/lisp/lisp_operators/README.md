运算符是一个符号，告诉编译器执行特定的数学或逻辑操作。
LISP允许对数据执行大量操作，并由各种功能，宏和其他构造支持。

允许对数据进行的操作可以归类为-
- 算术运算
- 比较操作
- 逻辑运算
- 按位运算

## 算术运算

```
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

```

## 比较运算符

```
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

```

## 布尔值的逻辑运算

```
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


```

## 位运算符与数值

[bitwiseOp.lisp](bitwiseOp.lisp)