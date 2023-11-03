const std = @import("std");
// hello.zig
pub fn sayHello() void {
    var message: []const u8 = "Hello from Zig!";
    std.debug.print(message);
}