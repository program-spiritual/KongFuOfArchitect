const std = @import("std");

var bar: i32 = 1;

fn suspendWithNoResume() !void {
    var frame = async func2();  //1
    resume frame;               //4
}

fn func2() void {
    bar += 1;                   //2
    suspend {}                  //3
    bar += 1;                   //5
}

pub fn main() !void {
    try suspendWithNoResume();
}