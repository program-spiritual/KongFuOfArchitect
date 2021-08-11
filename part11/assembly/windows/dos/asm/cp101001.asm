assume cs:code

data segment
  dw 1,2,3,4,5,6,7,8
  dd 0,0,0,0,0,0,0,0
data ends  
code segment
start:
  mov ax,data
  mov ds,ax
  mov si,0 ;ds:si 指向第一组 word 单元
  mov di,16;ds:di 指向第二组 double word 单元

  mov cx,8
s:
  mov bx,[si]  
  call cube
  mov [di],ax
  mov [di].2,``
  add si,2 ; ds:si 指向下一个word单元
  add di,4 ; ds:di 指向下一个 double word 单元
  loop s

  mov ax,4c00h
  int 21h
; 说明：计算 N 的三次方
; 参数： (bx)=N
; 结果：(dx:ax)=N^3
cube:
  mov ax,bx
  mul bx
  mul bx
  ret
code ends

end start