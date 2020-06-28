(write (mapcar '1+ '(23 34 45 56 67 78 89)))

(defun cubeMyList(list)
    (mapcar #'(lambda(x)(* x x x )) list)
)

(terpri)

(write (cubeMyList '(2 3 4 5 6 7 8 9)))

(terpri)


 (write (mapcar '+ '(1 3 5 7 9 11 13) '( 2 4 6 8)))