assume cs:code

code segment
start:
    jmp short s 
    db 218 dup(0)
s:
    mov ax,0ffffh    
code ends
end

