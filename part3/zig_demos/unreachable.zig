const std = @import("std");
pub fn main() !void {
    const x: i32 = 1;
    const y: u32 = if (x == 2) 5 else unreachable;
    std.debug.print("{}", .{y});
}
// Here is an unreachable being used in a switch.
fn asciiToUppercase(x :u8) u8 {
  return switch (x) {
    'a'...'z' => x + 'A' - 'a',
    'A'...'Z' => x,
    else => unreachable,
  };
}

test "unreachable switch" {
  try std.testing.expect(asciiToUppercase('a') == 'A');
  try std.testing.expect(asciiToUppercase('A') == 'A');
}