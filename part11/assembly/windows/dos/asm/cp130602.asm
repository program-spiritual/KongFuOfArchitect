assume cs:code

code segment
start:
  mov ah,2 ; 置光标
  mov bh,0 ; 第0页
  mov dh,5 ; dh 中放行号
  mov dl,12 ; dl 中放列号
  int 10h

  mov ah,9 ; 在光标位置显示字符
  mov al,'a' 
  mov bl,11001010b ; 颜色属性
  mov bh,0 ; 第0页
  mov cx,3 
  int 10h

  mov ax,4c00h
  int 21h
code ends

end start