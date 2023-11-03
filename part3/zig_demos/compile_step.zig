const std = @import("std");
const Builder = std.build.Builder;

pub fn build(b: *Builder) void {
  const exe = b.addExecutable(.{
    .name = "init-exe",
    .root_source_file = .{ .path = "src/main.zig" },
  });
  b.installArtifact(exe);

}