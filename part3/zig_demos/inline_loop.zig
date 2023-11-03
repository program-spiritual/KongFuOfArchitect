const std = @import("std");
fn testInlineForLoop() void {
    const types = [_]type{ u8, u16, u32, u64 };
    var sum: usize = 0;
    inline for (types) |T| sum += @sizeOf(T);
    std.debug.print("{}\n", .{sum});
}


pub fn main() void {
    // testInlineForLoop();
}
