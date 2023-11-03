const divExact = @import("std").math.divExact;
const print = @import("std").debug.print;
const expect = @import("std").testing.expect;
pub fn main() !void {
    var x: i32 = 10;
    switch (x) {
        -1...1 => {
            x = -x;
        },
        10...100 => {
            x = @divExact(x, 10);
        },
        else => {
            x = 333;
        },
    }
    print("{}", .{x});
}

test "switch expression" {
    var x: i8 = 10;
    x = switch (x) {
        -1...1 => -x,
        10, 100 => @divExact(x, 10),
        else => x,
    };
    try expect(x == 1);
}
