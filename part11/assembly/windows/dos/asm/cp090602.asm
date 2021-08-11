assume cs:code,ds:data

data segment
db 256 dup('abc','ABC')
data ends

code segment
start:
    mov ax,0123h
    mov [bx],ax
    mov word ptr [bx+2],0
    jmp dword ptr [bx]
code ends

end start