const std = @import("std");
const expect = std.testing.expect;
const eql = std.testing.expectEqual;
const Place = struct {
    latitude: f32,
    longitude: f32,
};
fn jsonString() !void {
    const x = Place{
        .latitude = 51.997664,
        .longitude = -0.740687,
    };

    var buf: [100]u8 = undefined;
    var fba = std.heap.FixedBufferAllocator.init(&buf);
    var string = std.ArrayList(u8).init(fba.allocator());
    try std.json.stringify(x, .{}, string.writer());
    std.debug.print("{s}\n", .{string.items});
}

fn jsonStringV2() !void {
    const yy = Place{
        .latitude = 51.997664,
        .longitude = -0.740687,
    };

    var buf: [100]u8 = undefined;
    var fba = std.heap.FixedBufferAllocator.init(&buf);
    var string = std.ArrayList(u8).init(fba.allocator());
    try std.json.stringify(yy, .{}, string.writer());

    try expect(eql(u8, string.items,
        \\{"latitude":5.199766540527344e+01,"longitude":-7.406870126724243e-01}
    ));
}

fn jsonParsing() !void {
    const User = struct {
        name: []const u8,
        age: i32,
    };
    const allocator = std.heap.page_allocator;
    const parsed = try std.json.parseFromSlice(User, allocator,
        \\{ "name": "Joe", "age": 25 }
    , .{});
    defer parsed.deinit();
    const user = parsed.value;
    std.debug.print("{s}\n", .{user.name});
    std.debug.print("{d}\n", .{user.age});
}

fn add(a: u32, b: u32) callconv(.C) u32 {
    return a + b;
}
pub fn main() !void {
    // try jsonString();
    // try jsonStringV2();
    try jsonParsing();
}
