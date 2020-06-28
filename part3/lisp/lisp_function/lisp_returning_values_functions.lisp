(defun add-all (a b c d )
  (+ a b c d)
  )

(setq sum (add-all 10 20 30 40))

(write sum )

(terpri)

(write (add-all 23.4 56.7 34.9 10.0))

(defun myfunc (num)
  (return-from myfunc 10)
    num
  )


(write (myfunc 20))


(defun myfunc-second (num)
  (return-from myfunc-second 10)
  write num

  )


(write (myfunc-second 20))






