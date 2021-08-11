; 问题： 求一个 word 型数据的平方
; 参数： ax: 要计算的数据
; 返回值：dx、ax 中存放结果的高16位和低16位
; 应用举例： 求 2*3456^2
assume cs:code

code segment
start:
; 设置源地址和目标地址
  mov ax,cs
  mov ds,ax
  mov si,offset sqr
  mov ax,0
  mov es,ax
  mov di,200h
  mov cx,offset sqrend - offset sqr
  cld ; 设置传输方向位正
  rep movsb

  ; 设置中断向量表
  mov ax,0
  mov es,ax
  mov word ptr es:[7ch*4],200h
  mov word ptr es:[7ch*4+2],0
  
  mov ax,3456
  int 7ch ; 调用中断 7ch 的中断例程，计算 ax 的数据的平方
  add ax,ax ; 低位 *2
  adc dx,dx ; 高位 *2
 
  sqr:
    mul ax
    iret
  sqrend:nop  
  
  mov ax,4c00h
  int 21h
code ends

end start