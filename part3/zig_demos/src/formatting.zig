const std = @import("std");
fn fmt1() !void {
    const allocator = std.heap.page_allocator;
    const string = try std.fmt.allocPrint(allocator, "{d} + {d} = {d}", .{ 9, 10, 19 });
    defer allocator.free(string);
    std.debug.print("{s}\n", .{string});
}

fn getStdOut() !void {
    const out_file = std.io.getStdOut();
    try out_file.writer().print("Hello World! {s}\n", .{"world"});
}

fn arrayPrinting() !void {
    const array = [_]u8{ 1, 2, 3 };
    const string = try std.fmt.allocPrint(std.heap.page_allocator, "{d} + {d} = {d}", .{ array[0], array[1], array[0] + array[1] });
    defer std.heap.page_allocator.free(string);
    std.debug.print("{s}\n", .{string});
}

fn arrayPrintingV2() !void {
    const string = try std.fmt.allocPrint(
        std.heap.page_allocator,
        "{any} + {any} = {any}",
        .{
            @as([]const u8, &[_]u8{ 1, 4 }),
            @as([]const u8, &[_]u8{ 2, 5 }),
            @as([]const u8, &[_]u8{ 3, 9 }),
        },
    );
    defer std.heap.page_allocator.free(string);

    std.debug.print("{s}\n", .{string});
}

const Person = struct {
    name: []const u8,
    birth_year: i32,
    death_year: ?i32,
    pub fn format(self: Person, comptime fmt: []const u8, options: std.fmt.FormatOptions, writer: anytype) !void {
        _ = fmt;
        _ = options;
        try writer.print("{s} ({}-", .{ self.name, self.birth_year });
        if (self.death_year) |year| {
            try writer.print("  {})\n", .{year});
        }
        try writer.writeAll(")");
    }
};

fn customFormat() !void {
    const john = Person{
        .name = "John",
        .birth_year = 1990,
        .death_year = null,
    };
    const john_string = try std.fmt.allocPrint(std.heap.page_allocator, "{s}", .{john});
    defer std.heap.page_allocator.free(john_string);
    std.debug.print("{s}\n", .{john_string});
    const claude = Person{
        .name = "Claude",
        .birth_year = 1992,
        .death_year = 2001,
    };
    const claude_string = try std.fmt.allocPrint(std.heap.page_allocator, "{s}", .{claude});
    defer std.heap.page_allocator.free(claude_string);
    std.debug.print("{s}\n", .{claude_string});
}

pub fn main() !void {
    try customFormat();
}
