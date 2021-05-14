assume cs:code,ds:data

data segment
 db '1.  file        '
 db '2.  edit        '
 db '3.  search      '
 db '4.  view        '
 db '5.  options     '
 db '6.  help        '
data ends

code segment
 start: mov ax,data
 mov ds,ax ; 初始化段地址
 mov bx,0 ;初始化偏移地址
 mov cx,6; 循环次数
s: mov al,[bx+3] ;设置 第一行第一个首字母的位置的值
   and al,11011111b ; 转换为大写字母
   add bx,16 ; 切换到下一行 
   loop s
code ends

end start