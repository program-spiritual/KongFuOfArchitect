const std = @import("std");
const expect = std.testing.expect;
const mem = std.mem;
fn testAllocators() !void {
    const allocator = std.heap.page_allocator;
    const memory = try allocator.alloc(u8, 100);
    defer allocator.free(memory);
}

fn fixedBufferAllocator() mem.Allocator {
    var buffer: [1000]u8 = undefined;
    var fixed_buffer_allocator = std.heap.FixedBufferAllocator.init(&buffer);
    const allocator = fixed_buffer_allocator.allocator();
    const memory = try allocator.alloc(u8, 100);
    defer allocator.free(memory);
    std.debug.print("memory .len = {d}\n", .{memory.len});
    std.debug.print("@typeOf(memory) = {}\n", .{@TypeOf(memory)});
    return allocator;
}

fn arenaAllocator() void {
    var arena = std.heap.ArenaAllocator.init(std.heap.page_allocator);
    defer arena.deinit();
    const allocator = arena.allocator();
    const memory = try allocator.alloc(u8, 1);
    std.debug.print("memory .len = {d}\n", .{memory.len});
}

fn createAndDestroy() !void {
    const byte = try std.heap.page_allocator.create(u8);
    defer std.heap.page_allocator.destroy(byte);
    byte.* = 128;
}

fn gpaFunc() !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const allocator = gpa.allocator();
    const bytes = try allocator.alloc(u8, 100);
    defer allocator.free(bytes);
    std.debug.print("bytes .len = {d}\n", .{bytes.len});
}

pub fn main() !void {
    // try testAllocators();
    // try fixedBufferAllocator();
    // arenaAllocator();
    // try createAndDestroy();
    gpaFunc() catch |err| {
        std.debug.print("error: {s}\n", .{@errorName(err)});
    };
}
