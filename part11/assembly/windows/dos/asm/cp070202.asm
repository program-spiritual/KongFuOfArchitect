assume cs:code,ds:data
data segment
 db 'welcome to masm!'
 db '................'
data ends
code segment
 start: mov ax,data
        mov ds,ax
        mov si,0
        mov cx,8
     s: mov ax,0[si]
        mov 16[si],ax
        add si,2
        loop s

        mov ax,4c00h
        int 21h

code ends
end  start