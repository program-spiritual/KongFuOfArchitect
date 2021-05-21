assume cs:code

code segment

start:
    mov ax,0
    mov bx,0
    jmp short s
    add ax,1
s:
    inc ax    
code ends

end