;sorting the strings
(write (sort (vector "Amal" "Akbar" "Anthony") #'string<))
(terpri)

;merging the strings
(write (merge 'vector (vector "Rishi" "Zara" "Priyanka") (vector "Anju" "Anuj" "Avni") #'string<))