const std = @import("std");
const expect = std.testing.expect;

fn randomNumber() !void {
    var prng = std.rand.DefaultPrng.init(blk: {
        var seed: u64 = undefined;
        try std.os.getrandom(std.mem.asBytes(&seed));
        break :blk seed;
    });
    const rand = prng.random();

    const a = rand.float(f32);
    const b = rand.boolean();
    const c = rand.int(u8);
    const d = rand.intRangeAtMost(u8, 0, 255);
    std.debug.print("{d}\n", .{a});
    std.debug.print("{}\n", .{b});
    std.debug.print("{d}\n", .{c});
    std.debug.print("{d}\n", .{d});
}

fn fetchPut() !void {
    var map = std.StringHashMap(enum { cool, uncool }).init(std.heap.page_allocator);
    defer map.deinit();
    try map.put("loris", .uncool);
    try map.put("me", .cool);
    const me_value = map.get("me").?;
    std.debug.print("{}\n", .{me_value});
    const loris_value = map.get("loris").?;
    std.debug.print("{}\n", .{loris_value});
}

pub fn main() !void {
    // try randomNumber();
    try fetchPut();
}
