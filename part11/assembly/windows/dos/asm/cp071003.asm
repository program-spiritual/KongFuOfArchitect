assume cs:code,ds:data

data segment
 db 'ibm             '
 db 'dec             '
 db 'dos             '
 db 'vax             '
data ends

stack segment
dw 0,0,0,0,0,0,0,0 ; 定义一个段 ，作为栈段，容量是 16字节  8 字
stack ends

code segment
 start:
  mov ax,stack
  mov ss,ax ; 初始化 栈段地址
  mov sp,16 ; 初始化 栈偏移地址

  mov ax,data
  mov ds,ax ; 初始化数据段地址
  mov bx,0 ; 初始化偏移地址

  mov cx,4

  s0:
    push cx ; 将外层循环的 cx 值 压入栈
    mov si,0 
    mov cx,3 ; cx 设置为内层循环的次数
    s:
      mov al,[bx+si]
      and al,11011111b
      mov [bx+si],al
      inc si
    loop s
    add bx,16
    pop cx ; 从栈顶弹出原 cx 的值 ， 恢复 cx
   loop s0 ; 外层循环的 loop 指令 将 cx 中的计数值 减去 1
   mov ax,4c00h
   int 21H

code ends

end start