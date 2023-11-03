const std = @import("std");
fn total(values: []const u8) usize {
    var sum: usize = 0;
    for (values) |v| {
        sum += v;
    }
    return sum;
}

test "slice" {
    const array = [_]u8{ 1, 2, 3, 4, 5 };
    const slice = array[0..3];
    try std.testing.expect(total(slice) == 6);
}
test "slices 2" {
    const array = [_]u8{ 1, 2, 3, 4, 5 };
    const slice = array[0..3];
    try std.testing.expect(@TypeOf(slice) == *const [3]u8);
}

test "slices 3" {
    var array = [_]u8{ 1, 2, 3, 4, 5 };
    var slice = array[0..];
    _ = slice;
}
