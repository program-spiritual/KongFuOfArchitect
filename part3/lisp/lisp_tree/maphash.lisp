(setq empList (make-hash-table)) 
(setf (gethash '001 empList) '(Charlie Brown))
(setf (gethash '002 empList) '(Freddie Seal)) 
(setf (gethash '003 empList) '(Mark Mongoose)) 

(maphash #'(lambda (k v) (format t "~a => ~a~%" k v)) empList)