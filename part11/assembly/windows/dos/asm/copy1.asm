assume cs:code
code segment
  mov ax,0ffffh 
  mov ds,ax; (ds)=0ffffh ds 时累加器，dl 是我们需要操作的内存单元 而非 ds 全部的数据
  mov ax,0020h
  mov es,ax ;(es)=0020h
  mov bx,0 ;此时 ds:bx 指向 ffff:0 es:bx 指向 0020：0
  mov cx,12;计数器，循环次数 12次
s: mov dl,[bx];将 ds:bx 的数据 ，此时 ffff:bx 的数据赋值给 dl
   mov es:[bx],dl ; 将 dl的数据送入 0020：bx
   inc bx
   loop s
  mov ax,4c00h
  int 21h 
code ends
end