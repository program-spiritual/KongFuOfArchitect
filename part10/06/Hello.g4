
lexer grammar Hello;  //lexer关键字意味着这是一个词法规则文件，名称是Hello，要与文件名相同

//关键字
If :               'if';
Int :              'int';

//字面量
IntLiteral:        [0-9]+;
StringLiteral:      '"' .*? '"' ;  //字符串字面量

//操作符
AssignmentOP:       '=' ;
RelationalOP:       '>'|'>='|'<' |'<=' ;
Star:               '*';
Plus:               '+';
Sharp:              '#';
SemiColon:          ';';
Dot:                '.';
Comm:               ',';
LeftBracket :       '[';
RightBracket:       ']';
LeftBrace:          '{';
RightBrace:         '}';
LeftParen:          '(';
RightParen:         ')';

//标识符
Id :                [a-zA-Z_] ([a-zA-Z_] | [0-9])*;

//空白字符，抛弃
Whitespace:         [ \t]+ -> skip;
Newline:            ( '\r' '\n'?|'\n')-> skip;