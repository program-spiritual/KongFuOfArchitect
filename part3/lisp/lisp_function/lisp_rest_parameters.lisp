(defun show-members (a b &rest values)
    (write (list  a b values))
)

(show-members  1 2 3)
(terpri)

(show-members 'a 'b 'c 'd)
(terpri)

(show-members 'a 'b)
(terpri)

(show-members 1 2 3 4)
(terpri)

(show-members 1 2 3 4 5 6 7 8 9)