const std = @import("std");
pub fn dump(args: anytype) !void {
    // for (args) |arg| {
    //     std.debug.print("{}", .{arg});
    // }
    std.debug.print("{}\n", .{args.int});
    std.debug.print("{}\n", .{args.float});
    std.debug.print("{}\n", .{args.b});
    std.debug.print("{s}\n", .{args.s});
}
