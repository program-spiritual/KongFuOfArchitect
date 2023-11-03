const std = @import("std");

const bufPrint = std.fmt.bufPrint;

fn hexFormat() !void {
    var b: [8]u8 = undefined;
    _ = try bufPrint(&b, "{X}", .{4294967294});
    _ = try bufPrint(&b, "{x}", .{4294967294});
    _ = try bufPrint(&b, "{}", .{std.fmt.fmtSliceHexLower("Zig!")});
    // std.debug.print("{any}\n", .{&b});
}

fn decimalFloat() !void {
    var b: [4]u8 = undefined;
    const buffer = try bufPrint(&b, "{d}", .{16.5});
    std.debug.print("{any}\n", .{buffer});
}

fn asciiFmt() !void {
    var b: [1]u8 = undefined;
    const buffer = try bufPrint(&b, "{c}", .{66});
    std.debug.print("{any}\n", .{buffer});
}

fn binaryFmt() !void {
    var b: [32]u8 = undefined;
    const buffer = try bufPrint(&b, "{}", .{std.fmt.fmtIntSizeDec(1)});
    std.debug.print("{any}\n", .{buffer});
}

fn octalFmt() !void {
    var b: [8]u8 = undefined;
    const buffer = try bufPrint(&b, "{o}", .{254});
    std.debug.print("{any}\n", .{buffer});
}

fn pointerFmt() !void {
    var b: [16]u8 = undefined;
    const buffer = try bufPrint(&b, "{*}", .{@as(*u8, @ptrFromInt(0xDEADBEEF))});
    std.debug.print("{any}\n", .{buffer});
}

fn scientific() !void {
    var b: [16]u8 = undefined;
    const buffer = try bufPrint(&b, "{e}", .{3.1415926});
    std.debug.print("{any}\n", .{buffer});
}

fn stringFmt() !void {
    var b: [6]u8 = undefined;
    const hello: [*:0]const u8 = "hello";
    const buffer = try bufPrint(&b, "{s}", .{hello});
    std.debug.print("{any}\n", .{buffer});
}

fn advanced() !void {
    var b: [3]u8 = undefined;
    const buffer = try bufPrint(&b, "{0s}{0s}{1s}", .{ "a", "b" });
    std.debug.print("{any}\n", .{buffer});
}

fn fillAlignmentWidth() !void {
    var b: [6]u8 = undefined;
    const buffer = try bufPrint(&b, "{s: <5}", .{"hi!"});
    std.debug.print("{s}\n", .{buffer});
    const buffer2 = try bufPrint(&b, "{s:_^6}", .{"hi!"});
    std.debug.print("{s}\n", .{buffer2});
    const buffer3 = try bufPrint(&b, "{s:!>4}", .{"hi!"});
    std.debug.print("{s}\n", .{buffer3});
}

fn precision() !void {
    var b: [4]u8 = undefined;
    const buffer = try bufPrint(&b, "{d:.2}", .{3.1415926});
    std.debug.print("{s}\n", .{buffer});
}

pub fn main() !void {
    // try hexFormat();
    // try decimalFloat();
    // try asciiFmt();
    // try binaryFmt();
    // try octalFmt();
    // try pointerFmt();
    // try scientific();
    // try stringFmt();
    // try advanced();
    try fillAlignmentWidth();
    try precision();
}
