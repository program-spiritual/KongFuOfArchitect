
def running_avg():
    total = 0.0
    count = 0
    avg = 0
    while True:
        num = yield avg
        total += num
        count += 1
        avg = total/count

#生成协程，不会有任何输出
ra = running_avg()
#运行到yield
next(ra)

print(ra.send(2))
print(ra.send(3))
print(ra.send(4))
print(ra.send(7))
print(ra.send(9))
print(ra.send(11))

#关掉协程
ra.close