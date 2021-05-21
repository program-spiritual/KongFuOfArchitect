assume cs:code,ds:data

data segment
dw 2356 dup(1)
data ends

code segment
start:
    mov ax,2000h
    mov ds,ax
    mov bx,0
s: 
    inc cx
    mov cl,[bx] 
    mov ch,0
    jcxz ok
    jmp short s
ok:
    mov dx,bx
    mov ax,4c00h
    int 21h       
code ends

end start