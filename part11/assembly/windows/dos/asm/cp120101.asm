assume cs:code

code segment
start:
; 设置源地址
  mov ax,cs
  mov ds,ax
  mov si,offset do0
; 设置目标地址
  mov ax,0
  mov es,ax
  mov di,200h
; 设置传输长度
  mov cx,offset do0end= offset do0
; 设置传输方向为正
  cld 
  rep movsb
  ; 设置中断向量表
  mov ax,4c00h
  int 21h
do0:
do0end:nop
code ends

end start