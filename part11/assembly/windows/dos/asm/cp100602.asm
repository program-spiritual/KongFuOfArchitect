assume cs:code

code segment
start:
    mov sp,10h
    mov ax,0123h
    mov ds:[0],ax
    mov word ptr ds:[2],0
    call dword ptr ds:[0]
code ends 

end start