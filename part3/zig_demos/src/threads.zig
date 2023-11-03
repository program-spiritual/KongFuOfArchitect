const std = @import("std");
fn ticker(step: u8) !void {
    while (true) {
        std.time.sleep(1000 * std.time.ns_per_ms);
        tick += @as(isize, step);
        std.debug.print("tick is {d}\n", .{tick});
    }
}

fn runThreads() !void {
    var thread = try std.Thread.spawn(.{}, ticker, .{@as(u8, 1)});
    _ = thread;
    std.time.sleep(3 * std.time.ns_per_s / 2);
    std.debug.print("tick is {d}\n", .{tick});
}

var tick: isize = 0;

pub fn main() !void {
    try runThreads();
}
