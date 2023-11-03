const std = @import("std");
const Point = struct {
    x: isize,
    y: isize,
};

fn testHashing() !void {
    var map = std.AutoHashMap(isize, Point).init(std.heap.page_allocator);
    defer map.deinit();
    try map.put(1, Point{ .x = 1, .y = 1 });
    try map.put(2, Point{ .x = 2, .y = 2 });
    try map.put(3, Point{ .x = 3, .y = 3 });
    try map.put(4, Point{ .x = 4, .y = 4 });
    try map.put(5, Point{ .x = 5, .y = 5 });
    try map.put(6, Point{ .x = 6, .y = 6 });
    std.debug.print("{d}\n", .{map.count()});
    var sum = Point{ .x = 0, .y = 0 };
    var iterator = map.iterator();
    while (iterator.next()) |entry| {
        sum.x += entry.value_ptr.x;
        sum.y += entry.value_ptr.y;
    }
    std.debug.print("{d} {d}\n", .{ sum.x, sum.y });
}

pub fn main() !void {
    try testHashing();
}
