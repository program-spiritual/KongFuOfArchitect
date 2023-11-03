const std = @import("std");

fn sorting() !void {
    var data = [_]u8{ 10, 240, 0, 0, 10, 5 };
    std.mem.sort(u8, &data, {}, comptime std.sort.asc(u8));
    std.debug.print("{any}\n", .{data});
    std.mem.sort(u8, &data, {}, comptime std.sort.desc(u8));
    std.debug.print("{any}\n", .{data});
}

pub fn main() !void {
    sorting() catch |err| {
        std.debug.print("error: {s}\n", .{@errorName(err)});
    };
}
