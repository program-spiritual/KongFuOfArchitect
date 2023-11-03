const std = @import("std");
const Result = union(enum) {
    integer: i32,
    float: f32,
    bool: bool,
};

const Tag = enum {
    a,
    b,
    c,
};

const Tagged = union(Tag) {
    a: u8,
    b: f32,
    c: bool,
};

fn switchOnTagged(tagged: Tagged) void {
    switch (tagged) {
        .a => |*byte| {
            std.debug.print("a\n", .{});
            byte.* += 1;
        },
        .b => std.debug.print("b\n", .{}),
        .c => std.debug.print("c\n", .{}),
    }
}

fn switchOnTagge2() void {
    var value = Tagged{ .b = 1.5 };
    switch (value) {
        .a => |*byte| byte.* += 1,
        .b => |*float| float.* *= 2,
        .c => |*b| b.* = !b.*,
    }
    std.debug.print("value: {}\n", .{value.b});
}

pub fn main() !void {
    const result = Result{
        .integer = 1,
    };
    // unions.zig:32:11: error: access of union field 'float' while field 'integer' is active
    // result.float = 12.34;
    std.debug.print("{}\n", .{result});

    var value = Tagged{
        .c = true,
    };
    // const aValue = Tagged{
    //     .a = 1,
    // };
    // switchOnTagged(aValue);
    switchOnTagge2();
    switchOnTagged(value);
}
