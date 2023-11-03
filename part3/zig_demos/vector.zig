const std = @import("std");
const meta = std.meta;
const eql = meta.eql;

fn testVectorAdd() void {
    const x: @Vector(4, f32) = .{ 1, 2, 3, 4 };
    const y: @Vector(4, f32) = .{ 5, 6, 7, 8 };
    const z = x + y;
    std.debug.print("{}\n", .{z});
    // vector is indexed from 0
    std.debug.print("{}\n", .{z[3]});
    std.debug.print("{}\n", .{z[0]});
    std.debug.print("{}\n", .{z[1]});
}

pub fn main() !void {
    testVectorAdd();
    scalar();
    const arr: [4]f32 = @Vector(4, f32){ 1, 2, 3, 4 };
    std.debug.print("{any}\n", .{arr});
}

fn scalar() void {
    const x: @Vector(3, f32) = .{ 12.5, 37.5, 2.5 };
    std.debug.print("{}\n", .{x});
    const y = x * @as(@Vector(3, f32), @splat(2));
    std.debug.print("{}\n", .{y});
}

fn coerce() void {
    const x: @Vector(4, u8) = .{ 255, 0, 255, 0 };
    std.debug.print("{}\n", .{x});
}

fn vectorLoop() void {
    const x = @Vector(4, u8){ 255, 0, 255, 0 };
    var sum = blk: {
        var tmp: u10 = 0;
        var i: u8 = 0;
        while (i < 4) : (i += 1) tmp += x[i];
        break :blk tmp;
    };
    std.debug.print("{}\n", .{sum});
}
