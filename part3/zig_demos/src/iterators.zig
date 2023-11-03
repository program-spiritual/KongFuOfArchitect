const std = @import("std");
fn splitIterator() !void {
    const text = "robust,optimal,reusable,maintainable";
    var iter = std.mem.split(u8, text, ",");
    std.debug.print("{any}\n", .{iter.next()});
    std.debug.print("{any}\n", .{iter.next()});
    std.debug.print("{any}\n", .{iter.next()});
    std.debug.print("{any}\n", .{iter.next()});
    std.debug.print("{any}\n", .{iter.next()});
}

fn iteratorLooping() !void {
    var iter = (try std.fs.cwd().openIterableDir(".", .{})).iterate();
    var file_count: usize = 0;
    while (try iter.next()) |entry| {
        std.debug.print("{s}\n", .{entry.name});
        if (entry.kind == .file) {
            file_count += 1;
        }
    }
    std.debug.print("file_count = {d}\n", .{file_count});
}

const ContainsIterator = struct {
    strings: []const []const u8,
    needle: []const u8,
    index: usize = 0,
    fn next(self: *ContainsIterator) ?[]const u8 {
        const index = self.index;
        for (self.strings[index..]) |string| {
            self.index += 1;
            if (std.mem.indexOf(u8, string, self.needle)) |_| {
                return string;
            }
        }
        return null;
    }
};

fn customIterator() void {
    var iter = ContainsIterator{
        .strings = &[_][]const u8{ "one", "two", "three" },
        .needle = "e",
    };
    std.debug.print("{any}\n", .{iter.next()});
    std.debug.print("{any}\n", .{iter.next()});
    std.debug.print("{any}\n", .{iter.next()});
}

pub fn main() !void {
    // try splitIterator();
    // try iteratorLooping();
    customIterator();
}
