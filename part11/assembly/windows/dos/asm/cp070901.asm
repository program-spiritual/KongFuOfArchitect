assume cs:code,ds:data
code segment
start:   mov ax,data
         mov ds,ax
         mov bx,0000h
         mov si,0
         mov ax,[bx+2+si]
         inc si
         mov cx,[bx+2+si]
         inc si
         mov di,si
         add cx,[bx+2+di]
code ends
data segment
 dw 00BEh,0600h,6a00h,2200h
data ends
end start