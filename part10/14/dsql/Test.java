
package dsql;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import dsql.parser.*;

public class Test {
    public static void main(String[] args) {
        String sql = "select order_id from orders where cust_id = 'SDYT987645'";

//词法分析
        SQLiteLexer lexer = new SQLiteLexer(CharStreams.fromString(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

//语法分析
        SQLiteParser parser = new SQLiteParser(tokens);
        ParseTree tree = parser.sql_stmt();

//输出lisp格式的AST
        System.out.println(tree.toStringTree(parser));
    }
}