import os

fn main() {
	embedded_file := $embed_file('v.png', .zlib)
	os.write_file('exported.png', embedded_file.to_string())!
}
