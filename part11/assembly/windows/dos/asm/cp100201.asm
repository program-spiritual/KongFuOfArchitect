assume cs:code,ds:data

data segment
 db 'word',0
 db 'unix',0
 db 'wind',0
 db 'good',0
data ends

code segment
start:
  mov ax,data
  mov ds,ax
  mov bx,0

  mov cx,4
s:
  mov si,bx
  call capital
  add bx,5 
  loop s 
capital:
  push cx
  push si
change:
  mov cl,[si]  
  mov ch,0
  jcxz ok
  and byte ptr [si],11011111b
  inc si
  jmp short change  
ok:
  pop si
  pop cx
  ret  
code ends

end start