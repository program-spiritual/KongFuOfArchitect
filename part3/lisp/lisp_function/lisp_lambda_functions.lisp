(write ((lambda (a b c x)
   (+ (* a (* x x)) (* b x) c))
   4 2 9 3)
)
(terpri)

(write (
    
    (lambda ( a b c d)
        (+ a b c d)
    )

    1 2 3 4
    )
)