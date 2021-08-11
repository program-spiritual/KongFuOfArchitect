assume cs:code

code segment
start:
    mov ax,6
    call ax
    inc ax
    mov bp,sp
    add ax,[bp]
code ends

end start