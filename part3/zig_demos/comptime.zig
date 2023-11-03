const std = @import("std");
fn fibonacci(n: u16) u16 {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
fn comptimeBlocks() void {
    var x = comptime fibonacci(10);
    std.debug.print("{}", .{x});
    var y = comptime blk: {
        break :blk fibonacci(10);
    };
    std.debug.print("{}", .{y});
}

fn comptimeInt() void {
    const x = comptime 5;
    std.debug.print("{}\n", .{x});
    const a = 12;
    const b = a + 10;

    const c: u4 = a;
    std.debug.print("{}\n", .{c});
    const d: f32 = b;
    std.debug.print("{}\n", .{d});
}

fn brachingOnTypes() void {
    const a = 5;
    const b: if (a < 10) f32 else i32 = 10;
    std.debug.print("{}\n", .{b});
}

fn Martrix(comptime T: type, comptime width: comptime_int, comptime height: comptime_int) type {
    return [height][width]T;
}

fn addSmallInts(comptime T: type, a: T, b: T) T {
    return switch (@typeInfo(T)) {
        .ComptimeInt => a + b,
        .Int => |info| if (info.bits <= 16) a + b else @compileError("ints too big"),
        else => @compileError("only ints allowed"),
    };
}

fn GetBiggerInt(comptime T: type) type {
    return @Type(.{ .Int = .{ .bits = @typeInfo(T).Int.bits + 1, .signedness = @typeInfo(T).Int.signedness } });
}

fn plusOne(x: anytype) @TypeOf(x) {
    return x + 1;
}

fn plusplus() void {
    const x: [4]u8 = [4]u8{ 1, 2, 3, 4 };
    const y = x[0..];
    std.debug.print("y is:{s}\n", .{y});
    const a: [6]u8 = [6]u8{ 1, 2, 3, 4, 5, 6 };
    const b = a[0..];
    std.debug.print("b is:{s}\n", .{b});
    const new = y ++ b;
    std.debug.print("new is:{s}\n", .{new});
    const pattern = [_]u8{ 0xCC, 0xAA };
    const memory = pattern ** 3;
    std.debug.print("memory is:{s}\n", .{memory});
}

pub fn main() !void {
    comptimeBlocks();
    comptimeInt();
    brachingOnTypes();
    const matrix = Martrix(f32, 4, 4);
    std.debug.print("{}\n", .{matrix});
    //  error: ints too big
    // const x = addSmallInts(i32, 20, 30);
    const x = addSmallInts(u16, 20, 30);
    std.debug.print("{}\n", .{x});
    const plus_number = plusOne(10);
    std.debug.print("{}\n", .{plus_number});
    plusplus();
}
