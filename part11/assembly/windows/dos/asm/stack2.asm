assume cs:code,ds:data,ss:stack
data segment
  dw 0123h,0456h,0789h,0abch,0defh,0fedh,0cbah,0987h
data ends

stack segment
  dw 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
stack ends

code segment
start: mov ax,stack
mov ss,ax
mov sp,20h; 设置栈顶 ss:sp 指向 stack:20
mov ax,data
mov ds,ax ; ds 指向 data 段

mov bx,0 ; ds:bx 指向 data 段中的第一单元
mov cx,8

s:push [bx]
add bx,2
loop s

mov bx,0
mov cx,8

s0: pop[bx]
add bx,2
loop s0

mov ax,4c00h
int 21h
code ends
end start