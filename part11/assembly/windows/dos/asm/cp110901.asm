assume cs:code,ds:data
data segment
  db 8,11,8,1,8,5,63,38
data ends
code segment
start:
  mov ax,data
  mov ds,ax
  mov bx,0 ; ds:bx 指向第一个字节
  mov ax,0 ; 初始化累加器
  mov cx,8
s:
  cmp byte ptr [bx],8 ; 和 8 进行比较
  jne next ; 如果不相等，转到 next 继续循环
  inc ax ; 如果相等就将计数值加1
next:
  inc bx ;跳转到下一个节点
  loop s ; 继续进行比较
code ends


end start