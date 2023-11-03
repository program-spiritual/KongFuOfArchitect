const std = @import("std");
const Vec3 = struct {
    x: f32,
    y: f32,
    z: f32,
};

const Vec4 = struct {
    x: f32,
    y: f32,
    z: f32 = 0,
    w: f32 = undefined,
};

const Stuff = struct {
    x: i32,
    y: i32,
    fn swap(self: *Stuff) void {
        const tmp = self.x;
        self.x = self.y;
        self.y = tmp;
    }
};

pub fn main() !void {
    const v1 = Vec3{
        .x = 1,
        .y = 2,
        .z = 3,
    };
    std.debug.print("{}\n", .{v1});

    const my_vector = Vec4{
        .x = 25,
        .y = -50,
    };
    std.debug.print("{}\n", .{my_vector});
    var thing = Stuff{
        .x = 10,
        .y = 20,
    };
    thing.swap();
    std.debug.print("{}\n", .{thing});
}
