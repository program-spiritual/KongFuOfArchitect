(defstruct book
    title
    author
    subject
    book-id
)

;; init book1 
( setq book1 (make-book :title "C Programming"
   :author "Nuha Ali" 
   :subject "C-Programming Tutorial"
   :book-id "478")
)

;; init book2
( setq book2 (make-book :title "Telecom Billing"
   :author "Zara Ali" 
   :subject "C-Programming Tutorial"
   :book-id "501")
) 

(write book1)
(terpri)
(write book2)
(setq book3( copy-book book1))
(setf (book-book-id book3) 100) 
(terpri)
(write book3)