const std = @import("std");

fn stacksInArray() !void {
    const string = "(()())";
    var stack = std.ArrayList(usize).init(std.heap.page_allocator);
    defer stack.deinit();
    const Pair = struct { open: usize, close: usize };
    var pairs = std.ArrayList(Pair).init(std.heap.page_allocator);
    defer pairs.deinit();
    for (string, 0..) |char, i| {
        if (char == '(') {
            try stack.append(i);
        }
        if (char == ')') {
            try pairs.append(.{
                .open = stack.pop(),
                .close = i,
            });
        }
    }

    for (pairs.items, 0..) |pair, i| {
        _ = i;
        std.debug.print("{d} {d}\n", .{ pair.open, pair.close });
    }
}

pub fn main() !void {
    try stacksInArray();
}
