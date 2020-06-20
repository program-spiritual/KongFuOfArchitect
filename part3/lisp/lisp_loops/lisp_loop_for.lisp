(loop for x in '(tom dick harry)
    do(format t " ~s" x)
)

(terpri)

(loop for  a from 10 to 20 
    do(print a)
)

(terpri)

(loop for x from 10 to 20
    if(evenp x)
    do(print x)
)