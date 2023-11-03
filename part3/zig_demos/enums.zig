const std = @import("std");
const Direction = enum {
    north,
    south,
    east,
    west,
};

const Value = enum(u2) {
    zero,
    one,
    two,
};

const Value2 = enum(u32) {
    hundred = 100,
    thousand = 1000,
    million = 1000000,
    next,
};

const Suit = enum {
    clubs,
    spades,
    diamonds,
    hearts,
    pub fn isClubs(self: Suit) bool {
        return self == Suit.clubs;
    }
};

const Mode = enum {
    var count: u32 = 0;
    on,
    off,
};

pub fn main() !void {
    const zero = @intFromEnum(Value.zero);
    const one = @intFromEnum(Value.one);
    const two = @intFromEnum(Value.two);
    std.debug.print("{}\n", .{zero});
    std.debug.print("{}\n", .{one});
    std.debug.print("{}\n", .{two});
    const next = @intFromEnum(Value2.next);
    std.debug.print("{}\n", .{next});
    const result = Suit.spades.isClubs() == Suit.isClubs(.spades);
    std.debug.print("{}\n", .{result});
    Mode.count += 1;
    std.debug.print("{}\n", .{Mode.count});
}
