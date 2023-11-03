const std = @import("std");

pub fn main() !void {
    const foo: u32 = 42;
    var bar: u8 = 10;
   // print constant and variable
    std.debug.print("Constant: {}\n", .{foo});
    std.debug.print("Variable: {}\n", .{bar});
    const a: i32 = undefined;
    const b: u32=undefined;
    std.debug.print("a: {}\n", .{a});
    std.debug.print("b: {}\n", .{b});
}