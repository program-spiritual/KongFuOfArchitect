const std = @import("std");
const FileOpenError = error{
    AccessDenied,
    OutOfMemory,
    FileNotFound,
};
const AllocationError = error{
    OutOfMemory,
};

test "coerce error from a subset to  a superset" {
    const err: FileOpenError = FileOpenError.OutOfMemory;
    try std.testing.expect(err == FileOpenError.OutOfMemory);
}

test "error union" {
   const maybe_error: AllocationError!u16 = 10;
   const no_error = maybe_error catch 0;
   try std.testing.expect(no_error == 10);
   try std.testing.expect(@TypeOf(no_error) == u16);
}

fn failingFunction() error{Oops}!void {
    return error.Oops;
}

fn failFn() error{Oops}!i32 {
   try failingFunction();
   return 12;
}

test "try " {
    var v = failFn() catch |err| {
        try std.testing.expect(err == error.Oops);
        return;
    };
    try std.testing.expect(v == 12);
}

test "returning an error" {
    failingFunction() catch |err| {
        try std.testing.expect(err == error.Oops);
        return;
    };
}

var problems: u32 = 98;
fn failFnCounter() error{Oops}!void {
    errdefer problems += 1;
    try failingFunction();
}

test "errdefer" {
    failFnCounter() catch |err| {
        try std.testing.expect(err == error.Oops);
        try std.testing.expect(problems == 99);
        return;
    };
}

fn createFile() !void {
    return error.AccessDenied;
}

test "inferred error set" {
 // type coercion successfully takes place
    const x: error{AccessDenied}!void = createFile();
    _ = x catch |err| {
        try std.testing.expect(err == error.AccessDenied);
    };
}

// merge error sets

const A = error{NotDir,PathNotFound};
const B = error{OutOfMemory, PathNotFound};
const C = A || B;

