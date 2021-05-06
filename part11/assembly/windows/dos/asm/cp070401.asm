assume cs:code,ds:data

data segment
db 'BaSiC'
db 'iNfOrMaTiOn'
data ends

code segment 
start:  mov ax,data
        mov ds,ax; 设置 ds 指向 data 段
        mov bx,0 ; ds:bx 指向 数据的第一个字母
        mov cx,5; 设置循环次数
      s:mov al,[bx]  
         and al,11011111B
         mov [bx],al
         inc bx
         loop s
        mov bx,5 ; 设置 bx=5 ,bx 指向 information 第一个字母
        mov cx,11 ; 设置循环次数为11 ,因为字母数量为11
      s0:mov al,[bx] 
         or al,00100000B
         mov [bx],al
         inc bx
         loop s0
         mov ax,4c00h
         int 21h
code ends

end start