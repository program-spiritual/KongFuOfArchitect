const std = @import("std");
const expect = std.testing.expect;
const decimal_int: i32 = 98222;
const hex_int: u8 = 0xff;
const another_hex_int: i32 = 0xDEADBEEF;
const octal_int: i32 = 0o777;
const binary_int: i32 = 0b101011;
const float: f32 = 1.23e3;

const one_billion: u64 = 1_000_000_000;
const binary_mask: u64 = 0b1000_0000_0000_0000_0000_0000_0000_0000;
const permissions: u64 = 0o777;
const _big_address: u64 = 0xFF80_0000_0000_0000;

pub fn main() !void {
    std.debug.print("{}", .{_big_address});
}

test "integer widening" {
    const a: u8 = 250;
    const b: u16 = a;
    const c: u32 = b;
    try expect(c == a);
}

test "@intCast" {
    const x: u64 = 200;
    const y = @as(u8, @intCast(x));
    try expect(@TypeOf(y) == u8);
}

test "well defined overflow" {
    var a: u8 = 255;
    a +%= 1;
    try expect(a == 0);
}

