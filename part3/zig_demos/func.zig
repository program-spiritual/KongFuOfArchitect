const std = @import("std");
fn addFive(x: u32) u32 {
    return x + 5;
}

test "function" {
    const y = addFive(5);
    std.debug.print("{}", .{y});
    try std.testing.expect(@TypeOf(y) == u32);
    try std.testing.expect(y == 10);
}
fn fibonacci(n: u16) u16 {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

test "fibonacci recursion" {
    try std.testing.expect(fibonacci(10) == 55);
 }

pub fn main() !void {
    const x = fibonacci(10);
    std.debug.print("{}", .{x});
}