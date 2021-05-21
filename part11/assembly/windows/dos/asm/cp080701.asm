assume cs:code

code segment
 start:  
    mov dx,1
    mov ax,86a1h
    mov bx,100
    div bx
code ends
end start