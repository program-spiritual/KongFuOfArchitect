
assume cs:code,ds:data

data segment
  db 'conversation',0
data ends

code segment
start:
  mov ax,data
  mov ds,ax
  mov si,0
  call capital

; 说明：将一个全是字母，以 0 结尾的字符串，转化为大写
; 参数：ds:si 指向字符串的首地址
; 结果：没有返回值
capital:
  mov cl,[si]
  mov ch,0
  jcxz ok 
  and byte ptr [si],11011111b
  inc si
  jmp short capital
ok:
  ret  
code ends

end start

