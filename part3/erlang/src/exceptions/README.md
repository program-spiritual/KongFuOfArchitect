任何编程语言都需要异常处理来处理运行时错误，以便可以维持应用程序的正常运行。
异常通常会中断应用程序的正常流程，这就是为什么我们需要在应用程序中使用异常处理的原因。

通常，当 `Erlang` 中发生异常或错误时，将显示以下消息：

```text
{"init terminating in do_boot", {undef,[{helloworld,start,[],[]}, 
{init,start_it,1,[]},{init,start_em,1,[]}]}}
```

故障转储将被写入 `erl_crash.dump` -

```text
init terminating in do_boot ()
```

异常的分类

- 错误

调用 `erlang:error(Reason)`
将在当前进程中结束执行，并在捕获到该函数时包含最后一个函数及其参数调用的堆栈跟踪。

- 退出

有两种出口：“内部” 退出 和“外部” 退出。
通过调用函数 `exit/1` 触发内部退出，并使当前进程停止执行。
外部出口用 `exit/2` 调用，并且在 `Erlang` 的并发方面必须处理多个进程。

- 抛出

抛出是一类异常，用于可以期望程序员处理的情况。
与退出和错误相比，它们实际上没有进行任何“崩溃过程”！
他们背后的意图，而是来源于他们控制流程。
当您在期望程序员处理异常的同时使用异常时，通常最好在使用异常的模块中记录它们的用法。


`try ... catch`是一种评估表达式的方式，同时让您处理成功的案例以及遇到的错误。 
`try catch`表达式的一般语法如下。


```erlang
try Expression of 
SuccessfulPattern1 [Guards] -> 
Expression1; 
SuccessfulPattern2 [Guards] -> 
Expression2 

catch 
TypeOfError:ExceptionPattern1 -> 
Expression3; 
TypeOfError:ExceptionPattern2 -> 
Expression4 
end
```