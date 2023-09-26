module main

import os

enum State {
	normal
	write_log
	return_error
}

fn read_log() {
	mut ok := false
	mut f := os.open('log.txt') or { panic(err) }
	defer {
		f.close()
	}
	if !ok {
		return
	}
}

// write log file and return number of bytes written

fn write_log(s State) !int {
	mut f := os.open('log.txt') or { panic(err) }
	defer {
		f.close()
	}
	if s == .write_log {
		// `f.close()` will be called after `f.write()` has been
		// executed, but before `write_log()` finally returns the
		// number of bytes written to `main()`
		return f.writeln('This is a log file')
	} else if s == .return_error {
		// the file will be closed after the `error()` function
		// has returned - so the error message will still report
		// it as open
		return error('nothing written; file open: ${f.is_opened}')
	}
	//   the file will be closed here, too
	return 0
}

fn main() {
	n := write_log(.return_error) or {
		panic('Error: ${err}')
		0
	}
	println('${n} bytes written')
}
