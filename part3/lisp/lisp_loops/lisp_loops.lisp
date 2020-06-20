(setq a 10)
(loop 
    (setq a (+ a 1))
    (write a)
    (terpri)
    (when (> a 17) (return a))
)