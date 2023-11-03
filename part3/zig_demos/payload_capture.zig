const std = @import("std");
fn optional_if() void {
    var maybe_number: ?usize = 10;
    if (maybe_number) |n| {
        std.debug.print("{}\n", .{@TypeOf(n)});
        std.debug.print("{}\n", .{n});
    }
}

fn error_union_if() void {
    var ent_number: error{UnknownEntity}!u32 = 5;
    if (ent_number) |entity| {
        std.debug.print("{}\n", .{@TypeOf(entity)});
        std.debug.print("{}\n", .{entity});
    } else |err| {
        std.debug.print("err is:{}\n", .{err});
        unreachable;
    }
}

fn while_optional() void {
    var i: ?u32 = 10;
    while (i) |n| : (i.? -= 1) {
        std.debug.print("{}\n", .{@TypeOf(n)});
        std.debug.print("{}\n", .{n});
        if (n == 1) {
            i = null;
            break;
        }
    }
    std.debug.print("{any}", .{i});
}

var numbers_left2: u32 = 10;
fn eventuallyErrorSequence() !u32 {
    return if (numbers_left2 == 0) error.ReachedZero else blk: {
        numbers_left2 -= 1;
        break :blk numbers_left2;
    };
}

fn testWhileErrorUnionCapture() void {
    var sum: u32 = 0;
    numbers_left2 = 3;
    while (eventuallyErrorSequence()) |value| {
        sum += value;
    } else |err| {
        std.debug.print("err is:{}\n", .{err});
    }
}

fn testWhileErrorUnion() void {
    var sum: u32 = 0;
    while (eventuallyErrorSequence()) |value| {
        sum += value;
    } else |err| {
        std.debug.print("err is:{}\n", .{err});
    }
}

fn testForCapture() void {
    const x = [_]i8{ 1, 5, 120, -5 };
    for (x) |v| {
        std.debug.print("{}\n", .{@TypeOf(v)});
    }
}

const Info = union(enum) { a: u32, b: []const u8, c, d: u32 };

fn switchCapture() void {
    var b = Info{ .a = 10 };
    const x = switch (b) {
        .b => |str| blk: {
            std.debug.print("{}", .{@TypeOf(str)});
            break :blk 1;
        },
        .c => 2,
        //if these are of the same type, they
        //may be inside the same capture group
        .a, .d => |num| blk: {
            std.debug.print("{}\n", .{@TypeOf(num)});
            break :blk num * 2;
        },
    };
    std.debug.print("{}", .{x});
}

fn testWithPointerCapture() void {
    var data = [_]u8{ 1, 2, 3, 4, 5 };
    for (&data) |*v| {
        v.* += 1;
    }

    for (data) |v| {
        std.debug.print("value element is:{}\n", .{v});
    }
    std.debug.print("{any}", .{&data});
}

pub fn main() !void {
    // optional_if();
    // error_union_if();
    // while_optional();
    // testWhileErrorUnionCapture();
    // testForCapture();
    // switchCapture();
    testWithPointerCapture();
}
