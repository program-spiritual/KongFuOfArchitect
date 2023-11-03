const std = @import("std");
pub fn testSentinelTermination() void {
    const c_string: [*:0]const u8 = "hello";
    var array: [5]u8 = undefined;
    var i: usize = 0;
    while (c_string[i] != 0) : (i += 1) {
        array[i] = c_string[i];
    }
    std.debug.print("{s}\n", .{array});
}

pub fn main() !void {
    // testSentinelTermination();
    // testCoercion();
    testSentinelSlicing();
}

fn testCoercion() void {
    // var a: [*:0]u8 = undefined;
    // const b: [*]u8 = a;
    // std.debug.print("{s}\n", .{b});
    var c: [5:0]u8 = undefined;
    const d: [5]u8 = c;
    std.debug.print("{s}\n", .{d});
    var e: [:10]f32 = undefined;
    const f = e;
    std.debug.print("{any}\n", .{f});
}

fn testSentinelSlicing() void {
    var x = [_:0]u8{255} ** 3;
    const y = x[0..3 :0];
    std.debug.print("{}\n", .{y[3]});
}
