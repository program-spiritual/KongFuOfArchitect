assume cs:code
code segment
mov ax,0ffffh
mov ds,ax
mov bx,6 ;到此为止，设置 ds:bx 指向物理地址
mov al,[bx]
mov ah,0 ;设置 al 的值等于 上面指向的物理地址的值，此时 ah 为 00 
mov dx,0 ; 清空累加器的值
mov cx,3; 设置累加次数
s: add dx,ax
loop s
mov ax,4c00h
int 21h; 程序返回
code ends
end