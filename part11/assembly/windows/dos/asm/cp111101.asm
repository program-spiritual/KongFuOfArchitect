assume cs:code,ds:data

data segment
db 256 dup(0)
data ends

code segment
start:
  mov ax,0
  push ax
  popf 
  mov ax,0fff0h
  mov ax,0010h
  pushf
  pop ax
  and al,11000101B
  and ah, 00001000B
code ends
 
end start
