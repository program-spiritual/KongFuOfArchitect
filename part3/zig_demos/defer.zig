const std = @import("std");
test "defer" {
    var x: i16 = 5;
    {
        defer x+=2;
        try std.testing.expect(x == 5);
    }
    try std.testing.expect(x == 7);
}

test "multiple defer" {
    var x: f16 = 5;
    {
        defer x+=2;
        defer x/=2;
        try std.testing.expect(x == 5);
    }
    try std.testing.expect(x == 4.5);
}