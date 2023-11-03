const std = @import("std");
test "for loop1" {
    const string = [_]u8{ 'a', 'b', 'c' };
    for (string, 0..) |character, index| {
        _ = index;
        std.debug.print("{}", .{character});
    }
}

pub fn main() !void {
    const string = [_]u8{ 'a', 'b', 'c' };
    for (string, 0..) |character, index| {
        std.debug.print("index: {}\n", .{index});
        std.debug.print("{}\n", .{character});
    }
    for (string) |character| {
        std.debug.print("{}", .{character});
    }
    for (string, 0..) |character, index| {
        std.debug.print("3 index: {}\n", .{index});
        std.debug.print("3 {}\n", .{character});
     }

}
