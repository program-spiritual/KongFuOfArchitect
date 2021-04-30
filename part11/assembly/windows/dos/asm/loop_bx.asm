assume cs:code
code segment
  mov ax,0ffffh
  mov ds,ax
  mov bx,0     ;初始化ds:bx 指向 ffff:0
  mov dx,0     ;初始化累加寄存器 dx
  mov cx,12    ;初始化循环计数器 cx (cx)=12
s:mov al,[bx] 
  mov ah,0
  add dx,ax    ; 间接传值
  inc bx
  loop s
  mov ax,4c00h
  int 21h
code ends
end