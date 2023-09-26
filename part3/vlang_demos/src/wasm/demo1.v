import wasm
import os

fn main() {
	mut m := wasm.Module{}
	m.new_function_import('imports', 'imported_func', [.i32_t], [
		.i32_t,
	])
	mut func := m.new_function('add', [.i32_t, .i32_t], [.i32_t])
	{
		func.local_get(0) // | local.get 0
		func.local_get(1) // | local.get 1
		func.add(.i32_t) // | i32.add
	}
	m.commit(func, true)
	mod := m.compile()
	os.write_file_array('./add.wasm', mod) or { panic(err) }
}
