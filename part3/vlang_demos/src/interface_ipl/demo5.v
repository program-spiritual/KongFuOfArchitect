pub interface Reader {
mut:
	read(mut buff []u8) ?int
}

pub interface Writer {
mut:
	write(buff []u8) ?int
}

// ReaderWriter embeds both Reader and Writer.
// The effect is the same as copy/pasting all of the
// Reader and all of the Writer methods/fields into
// ReaderWriter.

pub interface ReaderWriter {
	Reader
	Writer
}
