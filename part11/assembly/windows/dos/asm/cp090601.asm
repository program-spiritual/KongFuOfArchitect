assume cs:code,ds:data

data segment
    dd 12345678H
data ends

code segment
start:
    mov ax,data
    mov ds,ax
    mov bx,0
    mov [bx],ax
    mov [bx+2],bx
    jmp dword ptr ds:[0]
code ends

end start