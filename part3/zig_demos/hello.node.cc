// hello.node.cc
#include <node.h>
#include "hello.zig.h" // Zig模块的头文件

void SayHello(const v8::FunctionCallbackInfo<v8::Value>& args) {
  v8::Isolate* isolate = args.GetIsolate();
  
  // 调用Zig模块的函数
  sayHello();

  args.GetReturnValue().SetUndefined();
}

void Initialize(v8::Local<v8::Object> exports) {
  NODE_SET_METHOD(exports, "sayHello", SayHello);
}

NODE_MODULE(NODE_GYP_MODULE_NAME, Initialize)