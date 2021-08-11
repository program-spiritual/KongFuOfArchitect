assume cs:code2,ds:data
data segment
  db 8,11,8,1,8,5,63,38
data ends

code2 segment
start2:
  mov ax,data
  mov ds,ax
  mov bx,0 ;ds:bx 指向第一个字节
  mov ax,0 ; 初始化累加器
  mov cx,8
s2:
  cmp byte ptr [bx],8 ; 和 8 进行比较
  je ok ; 如果相等转到 ok
  jmp short next ; 如果不相等就转 next ， 继续循环
ok:
  inc ax ; 如果相等  
next:
  inc bx
  loop s2 
code2 ends

end start2