const std = @import("std");
const expect = std.testing.expect;
const dump = @import("dump.zig").dump;
fn testStructLiteral() void {
    const Point = struct {
        x: u32,
        y: u32,
    };
    var point: Point = .{
        .x = 1,
        .y = 2,
    };
    std.debug.print("{}\n", .{point});
}

fn testFullAnonymousStruct() void {
    try dump(.{
        .int = @as(u32, 1234),
        .float = @as(f64, 12.34),
        .b = true,
        .s = "hello",
    });
}

fn testTuples() void {
    const values = .{
        @as(u32, 1234),
        @as(f64, 12.34),
        true,
        "hello",
    } ++ .{false} ** 2;
    std.debug.print("{}\n", .{values});
    std.debug.print("{}\n", .{values[0]});
    std.debug.print("{}\n", .{values[4]});
    inline for (values, 0..) |v, i| {
        if (i != 2) {
            continue;
        }
        std.debug.print("{}\n", .{v});
    }
    std.debug.print("values.len: {}\n", .{values.len});
    std.debug.print("values 3 [0]: {}\n", .{values.@"3"[0]});
}

fn testSentinelTerminatedArray() void {
    const terminated = [4:0]u8{ 1, 2, 3, 4 };
    //  try expect(@as(*const [4]u8, @ptrCast(&terminated))[3] == 0);
    const casted_value = @as(*const [5]u8, @ptrCast(&terminated));
    std.debug.print("{s}\n", .{terminated});
    std.debug.print("{s}\n", .{casted_value});
    std.debug.print("{}\n", .{casted_value[4]});
}

pub fn main() void {
    // testStructLiteral();
    // testFullAnonymousStruct();
    // testTuples();
    testSentinelTerminatedArray();
}
