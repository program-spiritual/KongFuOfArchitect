module main

import os

enum State {
	normal
	write_log
	return_error
}

fn write_log(s State) !int {
	println('write log')
	mut f := os.create('log.txt')!
	defer {
		f.close()
	}
	if s == .write_log {
		return f.writeln('this is a log file')
	} else if s == .return_error {
		return error('nothing written; file open: ${f.is_opened}')
	}
	return 0
}

fn main() {
	n := write_log(.return_error) or {
		println('Error: ${err}')
		0
	}
	println('${n} bytes written')
	//   write log
	m := write_log(.write_log) or {
		println('write Error: ${err}')
		0
	}
	println('${m} bytes written')
}
