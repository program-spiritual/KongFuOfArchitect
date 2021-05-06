assume cs:code,ds:data

data segment
 db 'BaSiC'
 db 'MinIX'
data ends

code segment
 start: mov ax,data
        mov ds,ax
        mov bx,0
     s: mov cx,5
        mov al,0[bx];定位第一个字符串的字符
        and al,11011111B
        mov 0[bx],al
        mov al,5[bx]; 定位第二个字符串的字符
        or al,00100000B
        mov 5[bx],al
        inc bx
        loop s

code ends
end start