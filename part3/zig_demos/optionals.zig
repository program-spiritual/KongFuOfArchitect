const std = @import("std");
const expect = std.testing.expect;

fn foundIndex() !void {
    var found_index: ?usize = null;
    const data = [5]i8{ 1, 2, 3, 4, 5 };
    for (data, 0..) |item, index| {
        if (item == 3) found_index = index;
    }
    std.debug.print("found_index==null: {?}\n", .{found_index});
}

fn use_or_else() !void {
    var a: ?f32 = null;
    var b = a orelse 0;
    try expect(b == 0);
    try expect(@TypeOf(b) == f32);
}

fn orelseUnreachable() !void {
    const a: ?f32 = 5;
    const b = a orelse unreachable;
    const c = a.?;
    std.debug.print("b {d}\n", .{b});
    std.debug.print("c {d}\n", .{c});
}

fn ifOptionalPayloadCapture() !void {
    const a: ?i32 = 5;
    if (a != null) {
        const value = a.?;
        std.debug.print("value {d}\n", .{value});
    }
    var b: ?i32 = 5;
    if (b) |*value| {
        value.* += 1;
    }
    std.debug.print("b {?}\n", .{b});
}

var numbers_left: u32 = 4;
fn eventuallyNullSequence() ?u32 {
    if (numbers_left == 0) {
        return null;
    }
    numbers_left -= 1;
    return numbers_left;
}

fn withWhile() !void {
    var sum: u32 = 0;
    while (eventuallyNullSequence()) |value| {
        sum += value;
    }
    std.debug.print("sum {d}\n", .{sum});
}

pub fn main() !void {
    try foundIndex();
    use_or_else() catch |err| {
        std.debug.print("error: {s}\n", .{@errorName(err)});
    };
    orelseUnreachable() catch |err| {
        std.debug.print("error: {s}\n", .{@errorName(err)});
    };
    ifOptionalPayloadCapture() catch |err| {
        std.debug.print("error: {s}\n", .{@errorName(err)});
    };
    withWhile() catch |err| {
        std.debug.print("error: {s}\n", .{@errorName(err)});
    };
}
