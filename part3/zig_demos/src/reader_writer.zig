const std = @import("std");
const ArrayList = std.ArrayList;
fn io_writer_usage() !void {
    var list = ArrayList(u8).init(std.heap.page_allocator);
    defer list.deinit();
    const bytes_written = try list.writer().write("Hello World!");
    std.debug.print("bytes_written = {d}\n", .{bytes_written});
    std.debug.print("{s}\n", .{list.items});
}

fn ioReaderUsage() !void {
    const message = "Hello File!";
    const file = try std.fs.cwd().createFile("junk_file2.txt", .{ .read = true });
    defer file.close();
    try file.writeAll(message);
    try file.seekTo(0);
    const contents = try file.reader().readAllAlloc(std.heap.page_allocator, message.len);
    defer std.heap.page_allocator.free(contents);

    std.debug.print("{s}\n", .{contents});
}

fn nextLine(reader: anytype, buffer: []u8) !?[]const u8 {
    var line = (try reader.readUntilDelimiterOrEof(
        buffer,
        '\n',
    )) orelse return null;
    if (@import("builtin").os.tag == .windows) {
        return std.mem.trimRight(u8, line, "\r");
    } else {
        return line;
    }
}

fn readUNtilNextLine() !void {
    const stdout = std.io.getStdOut();
    const stdin = std.io.getStdIn();
    try stdout.writeAll("What is your name?");
    var buffer: [100]u8 = undefined;
    const input = (try nextLine(stdin.reader(), &buffer)).?;
    try stdout.writer().print("Hello, {s}!\n", .{input});
}

const MyBytesList = struct {
    data: [100]u8 = undefined,
    items: []u8 = &[_]u8{},
    const Writer = std.io.Writer(
        *MyBytesList,
        error{EndOfBuffer},
        appendWrite,
    );
    fn appendWrite(self: *MyBytesList, data: []const u8) error{EndOfBuffer}!usize {
        if (self.items.len + data.len > self.data.len) {
            return error.EndOfBuffer;
        }
        std.mem.copy(
            u8,
            self.data[self.items.len..],
            data,
        );
        self.items = self.data[0 .. self.items.len + data.len];
        return data.len;
    }

    fn writer(self: *MyBytesList) Writer {
        return .{
            .context = self,
        };
    }
};

fn customWriter() !void {
    var list = MyBytesList{};
    const writer = list.writer();
    _ = try writer.write("Hello");
    _ = try writer.write(" Writer!");
    std.debug.print("{s}\n", .{list.items});
}

pub fn main() !void {
    // try io_writer_usage();
    // try ioReaderUsage();
    // try readUNtilNextLine();
    try customWriter();
}
