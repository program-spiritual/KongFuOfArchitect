(defclass box ()
   ((length :accessor box-length)
      (breadth :accessor box-breadth)
      (height :accessor box-height)
      (volume :reader volume)
   )
)

; method calculating volume   

(defmethod volume ((object box))
   (* (box-length object) (box-breadth object)(box-height object))
)

 ;setting the values 

(setf item (make-instance 'box))
(setf (box-length item) 10)
(setf (box-breadth item) 10)
(setf (box-height item) 5)

; displaying values

(format t "Length of the Box is ~d~%" (box-length item))
(format t "Breadth of the Box is ~d~%" (box-breadth item))
(format t "Height of the Box is ~d~%" (box-height item))
(format t "Volume of the Box is ~d~%" (volume item))