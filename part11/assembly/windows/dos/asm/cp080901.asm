assume cs:code,ds:data

code segment
code ends

data segment
db 3 dup (0) ;定义3个字节
db 3 dup(0,1,2) ; 定义9 个字节 
db 3 dup ('abc','ABC')
db 200 dup (0)
data ends