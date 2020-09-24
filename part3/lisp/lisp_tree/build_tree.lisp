(defun make-tree (item)
   "it creates a new node with item."
   (cons (cons item nil) nil)
)

(defun add-child (tree child)
   (setf (car tree) (append (car tree) child))
   tree)

(defun first-child (tree)
   (if (null tree)
      nil
      (cdr (car tree))
   )
)

(defun next-sibling (tree)
   (cdr tree)
)

(defun data (tree)
   (car (car tree))
)

(setq tr '((1 2 (3 4 5) ((7 8) (7 8 9)))))
(setq mytree (make-tree 10))

(write (data mytree))
(terpri)
(write (first-child tr))
(terpri)
(setq newtree (add-child tr mytree))
(terpri)
(write newtree)