(defun show-members (&key a b c d)
  (write (list a b c d))

  )

(show-members :a 1 :c 2 :d 3)

(terpri)

(show-members :a 'p :b 'q :c 'r :d 's)

(terpri)

(show-members :a 'p :d 'q)

(terpri)

(show-members :a 1 :b 2)




