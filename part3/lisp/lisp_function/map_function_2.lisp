(defun cubeMylist(list)
    (mapcar #'(lambda(x) (* x x x)) list)
)

(write (cubeMylist '(2 3 4 5 6 7 8 9)))