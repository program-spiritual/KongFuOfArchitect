const std = @import("std");
const expect = std.testing.expect;
const allocator = std.heap.page_allocator;
test "allocation" {
    const memory = try allocator.alloc(u8, 100);
    defer allocator.free(memory);

    try expect(memory.len == 100);
    try expect(@TypeOf(memory) == []u8);
}
