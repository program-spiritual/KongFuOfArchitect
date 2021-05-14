assume cs:code,ds:data

data segment
 db 'ibm             '
 db 'dec             '
 db 'dos             '
 db 'vax             '
data ends

code segment
 start:
   mov ax,data
   mov ds,ax
   mov bx,0
   mov cx,4
   s0: ;下一次进入循环之前 cx 自减
      mov ds:[40H],cx ; 将外层的cx 保存在data:40H 内存单元中
      mov si,0
      mov cx,3; 设置为内层循环的次数
      s: 
         mov al,[bx+si] ; 暂存当前处理的地址
         and al,11011111b ; 转换
         mov [bx+si],al ; 设置内存单元的内容
         inc si ; 增加当前行的列的偏移量
         loop s ; 继续循环
      mov cx,ds:[40H]   ; 从 data:40H 单元中的值恢复到 cx 寄存器中
      loop s0 ; 外层循坏的 循环指令将 cx 的计数值减1
      mov ax,4c00h
      int 21H

code ends

end start