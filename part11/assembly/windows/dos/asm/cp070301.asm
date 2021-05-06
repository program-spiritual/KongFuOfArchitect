assume cs:code,ds:data
data segment
  db 'unix'
  db 'fork'
  db 'unIX'
  db 'foRK'
data ends

code segment
start: mov al ,'a'
       mov bl,'b'
       mov ax,4c00h
       int 21h
code ends
end start