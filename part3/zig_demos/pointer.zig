const std = @import("std");
fn increment(num: *u8) void {
    num.* += 1;
}

test "pointer increment" {
    var x: u8 = 1;
    increment(&x);
    try std.testing.expect(x == 2);
}

test "naughty pointer" {
    // var x: u16 = 0;
    // var y: *u8 = @ptrFromInt(x);
    // std.debug.print("{}", .{y});
}

pub fn main1() !void {
    // pointer.zig:21:7: error: cannot assign to constant
    const x: u8 = 1;
    var y = &x;
    y.* += 1;
}
test "usize" {
    try std.testing.expect(@sizeOf(usize) == @sizeOf(*u8));
    try std.testing.expect(@alignOf(isize) == @alignOf(*u8));
}

pub fn main() !void {
}