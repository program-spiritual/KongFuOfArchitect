const std = @import("std");
const expect = std.testing.expect;

test "nested continue" {}

fn nestedContinue() !void {
    var count: usize = 0;
    outer: for ([_]i32{ 1, 2, 3, 4, 5 }) |i| {
        std.debug.print("i {d}\n", .{i});
        for ([_]i32{ 1, 2, 3, 4, 5 }) |j| {
            std.debug.print("j {d}\n", .{j});
            count += 1;
            continue :outer;
        }
    }
    std.debug.print("count {d}\n", .{count});
}

fn rangeHasNumber(begin: usize, end: usize, number: usize) bool {
    var i = begin;
    return while (i < end) : (i += 1) {
        if (i == number) {
            break true;
        }
    } else {
        return false;
    };
}

pub fn main() !void {
    try nestedContinue();
    const result = rangeHasNumber(0, 10, 3);
    std.debug.print("{}\n", .{result});
}
