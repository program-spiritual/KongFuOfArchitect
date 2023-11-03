const std = @import("std");
const eql = std.mem.eql;
const FILE_NAME = "example.tx t";
fn createFile() !void {
    const file = try std.fs.cwd ().createFile(FILE_NAME, .{ .read = true });
    defer file.close();

    const bytes_written = try file.write("Hello World!");
    std.debug.print("bytes_written = {d}\n", .{bytes_written});
}

fn readFile() !void {
    const file = try std.fs.cwd().openFile(FILE_NAME, .{});
    defer file.close();
    var buffer: [100]u8 = undefined;
    try file.seekTo(0);
    const bytes_read = try file.readAll(&buffer);
    std.debug.print("bytes_read = {d}\n", .{bytes_read});
    // print buffer[0..bytes_read]
    std.debug.print("{s}\n", .{buffer[0..bytes_read]});
}

fn readFileStats() !void {
    const file = try std.fs.cwd().openFile(FILE_NAME, .{});
    defer file.close();
    const stat = try file.stat();
    std.debug.print("size = {d}\n", .{stat.size});
    // stat kind
    std.debug.print("kind = {s}\n", .{@tagName(stat.kind)});
    // stat permissions
    std.debug.print("ctime  = {d}\n", .{stat.ctime});
    std.debug.print("ctime  = {d}\n", .{stat.mtime});
    std.debug.print("ctime  = {d}\n", .{stat.atime});
}

fn makekDir() !void {
    // if dir exists, delete it
    std.fs.cwd().deleteTree("test-tmp") catch unreachable;
    try std.fs.cwd().makeDir("test-tmp");
    var iter_dir = try std.fs.cwd().openIterableDir("test-tmp", .{});
    defer {
        iter_dir.close();
        std.fs.cwd().deleteTree("test-tmp") catch unreachable;
    }
    _ = try iter_dir.dir.createFile("x", .{});
    _ = try iter_dir.dir.createFile("y", .{});
    _ = try iter_dir.dir.createFile("z", .{});

    var file_count: usize = 0;
    var iter = iter_dir.iterate();
    while (try iter.next()) |entry| {
        if (entry.kind == .file) {
            file_count += 1;
        }
    }
    std.debug.print("file_count = {d}\n", .{file_count});
}

pub fn main() !void {
    // try createFile();
    // try readFile();
    // try readFileStats();
    try makekDir();
}
