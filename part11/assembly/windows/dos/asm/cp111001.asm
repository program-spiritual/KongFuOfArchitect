assume cs:code
data segment
  db 'Welcome to masm!'
  db 16 dup(0)
data ends
code segment
start:
  mov ax,data
  mov ds,ax
  mov si,0 ; ds:si 指向
  mov es,ax
  mov di,16
  mov cx,16 ; rep 循环次数 16
  cld
  rep movsb
code ends

end start