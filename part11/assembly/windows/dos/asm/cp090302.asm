assume cs:code

code segment

start:
    mov ax,0123h
    mov ax,ds:[0123h]
    push ds:[0123h]
s:
    inc ax    
code ends

end