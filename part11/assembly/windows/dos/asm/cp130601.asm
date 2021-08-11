assume cs:code

code segment
start:
  mov ah,9
  mov al,'a'
  mov bl,7
  mov bh,0
  mov cx,3
  int 10h
code ends

end start