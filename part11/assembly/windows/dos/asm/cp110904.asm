assume cs:code2,ds:data
data segment
  db 8,11,8,1,8,5,63,38
data ends

code2 segment
start2:
  mov ax,data
  mov ds,ax
  mov ax,0
  mov bx,0
  mov cx,8
s:
  cmp byte ptr [bx],8
  jnb next
  inc ax
next:
  inc bx
  loop s    
code2 ends

end start2