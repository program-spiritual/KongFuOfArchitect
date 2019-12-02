package main

func main() {
	// 字面量
	//212         /* Legal */
	//215u        /* Legal */
	//0xFeeL      /* Legal */
	//078         /* Illegal: 8 is not an octal digit */
	//032UU       /* Illegal: cannot repeat a suffix */
	//85         /* decimal */
	//0213       /* octal */
	//0x4b       /* hexadecimal */
	//30         /* int */
	//30u        /* unsigned int */
	//30l        /* long */
	//30ul       /* unsigned long */
	//3.14159       /* Legal */
	//314159E-5L    /* Legal */
	//510E          /* Illegal: incomplete exponent */
	//210f          /* Illegal: no decimal or exponent */
	//.e55          /* Illegal: missing integer or fraction */

//	转义序列
//	\\	\ character
//	\'	' character
//	\"	" character
//	\?	? character
//	\a	Alert or bell
//	\b	Backspace
//	\f	Form feed
//	\n	Newline
//	\r	Carriage return
//	\t	Horizontal tab
//	\v	Vertical tab
//	\ooo	Octal number of one to three digits
//	\xhh . . .	Hexadecimal number of one or more digits
}
