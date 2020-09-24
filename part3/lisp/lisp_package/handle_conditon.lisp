(define-condition on-division-by-zero (error)
   ((message :initarg :message :reader message))
)
   
(defun handle-infinity ()
   (restart-case
      (let ((result 0))
         (setf result (division-function 10 0))
         (format t "Value: ~a~%" result)
      )
      (just-continue () nil)
   )
)
     
(defun division-function (value1 value2)
   (restart-case
      (if (/= value2 0)
         (/ value1 value2)
         (error 'on-division-by-zero :message "denominator is zero")
      )

      (return-zero () 0)
      (return-value (r) r)
      (recalc-using (d) (division-function value1 d))
   )
)

(defun high-level-code ()
   (handler-bind
      (
         (on-division-by-zero
            #'(lambda (c)
               (format t "error signaled: ~a~%" (message c))
               (invoke-restart 'return-zero)
            )
         )
         (handle-infinity)
      )
   )
)

(handler-bind
   (
      (on-division-by-zero
         #'(lambda (c)
            (format t "error signaled: ~a~%" (message c))
            (invoke-restart 'return-value 1)
         )
      )
   )
   (handle-infinity)
)

(handler-bind
   (
      (on-division-by-zero
         #'(lambda (c)
            (format t "error signaled: ~a~%" (message c))
            (invoke-restart 'recalc-using 2)
         )
      )
   )
   (handle-infinity)
)

(handler-bind
   (
      (on-division-by-zero
         #'(lambda (c)
            (format t "error signaled: ~a~%" (message c))
            (invoke-restart 'just-continue)
         )
      )
   )
   (handle-infinity)
)

(format t "Done."))