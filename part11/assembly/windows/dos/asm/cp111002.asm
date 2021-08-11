assume cs:code,ds:data

data segment
  db 16 dup(0)
data ends

code segment
start:  
 mov ax,0f000h
 mov ds,ax
 mov si,0ffffh; ds:si 指向 f000:ffff
 mov ax,data
 mov es,ax
 mov di,15 ; es:di 指向 data:000f
 mov cx,16
 std
 rep movsb
code ends

end start