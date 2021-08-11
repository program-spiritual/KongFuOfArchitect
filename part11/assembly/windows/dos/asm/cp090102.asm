assume cs:code

code segment
s: mov ax,bx ; mov ax,bx 机器码占两个字节
mov si,offset s
mov di,offset s0
mov ax,cs:[si]
mov cs:[di],ax
s0:
nop ; nop 的机器码占一个字节
nop
code ends

end