(defclass Box () 
   (length 
   breadth 
   height)
)


(defclass Box2 ()
   ((length :accessor length)
      (breadth :accessor breadth)
      (height :accessor height)
   )
)

(defclass Box3 ()
   ((length :reader get-length :writer set-length)
      (breadth :reader get-breadth :writer set-breadth)
      (height :reader get-height :writer set-height)
   )
)