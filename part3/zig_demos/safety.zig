const std = @import("std");
test "out of bounds access" {
  const a = [3]u8{ 1, 2, 3 };
  var index :u8 = 5;
  const b = a[index];
  std.debug.print("{}", .{b});
}