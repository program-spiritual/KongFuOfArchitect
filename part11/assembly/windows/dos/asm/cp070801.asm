assume cs:code,ds:data
code segment
start:   mov ax,data
         mov ds,ax
         mov bx,0000h
         mov si,0
         mov ax,[bx+si]
         inc si
         mov cx,[bx+si]
         inc si
         mov di,si
         add cx,[bx+di]
code ends
data segment
 dw 00BEh,0600h,0000h
data ends
end start