assume cs:code

code segment
start:
    mov ax,0
    call s
    inc ax
s:
    pop ax    
ends segment

end start