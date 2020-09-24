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
  
;wooden-box class inherits the box class  
(defclass wooden-box (box)
((price :accessor box-price)))

;setting the values 
(setf item (make-instance 'wooden-box))
(setf (box-length item) 10)
(setf (box-breadth item) 10)
(setf (box-height item) 5)
(setf (box-price item) 1000)

; displaying values
(format t "Length of the Wooden Box is ~d~%" (box-length item))
(format t "Breadth of the Wooden Box is ~d~%" (box-breadth item))
(format t "Height of the Wooden Box is ~d~%" (box-height item))
(format t "Volume of the Wooden Box is ~d~%" (volume item))
(format t "Price of the Wooden Box is ~d~%" (box-price item))