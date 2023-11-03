const std = @import("std");
const Window = opaque {
    fn show(self: *Window) void {
        show_window(self);
    }
};
extern fn show_window(*Window) callconv(.C) void;

fn testOpaque() void {
    var main_window: *Window = undefined;
    show_window(main_window);
}

pub fn main() void {
    testOpaque();
}
