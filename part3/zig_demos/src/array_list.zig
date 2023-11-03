const std = @import("std");
const eql = std.mem.eql;
const ArrayList = std.ArrayList;
const GeneralPurposeAllocator = std.heap.GeneralPurposeAllocator;
fn testArrayList() !void {
    var gpa = GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const allocator = gpa.allocator();
    var list = ArrayList(u8).init(allocator);
    defer list.deinit();
    try list.append('H');
    try list.append('e');
    try list.append('l');
    try list.append('l');
    try list.append('o');
    try list.appendSlice(" World!");
    std.debug.print("list.items equals 'Hello World!' = {}\n", .{eql(u8, list.items, "Hello World!")});
}

pub fn main() !void {
    try testArrayList();
}
