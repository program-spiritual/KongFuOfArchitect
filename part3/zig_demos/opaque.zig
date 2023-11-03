const Window = opaque {};
const Button = opaque {};
extern fn show_window(*Window) callconv(.C) void;
fn testOpaque() void {
    var main_window: *Window = undefined;
    show_window(main_window);
    var button: *Button = undefined;
    show_window(button);
}

pub fn main() void {
    testOpaque();
}
