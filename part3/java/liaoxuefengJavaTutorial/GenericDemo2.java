import java.util.ArrayList;
import java.util.List;

public class GenericDemo2 {
    public static void main(String[] args) {
        // 编译器警告:
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        String first = (String) list.get(0);
        String second = (String) list.get(1);

        List<Number> list2 = new ArrayList<Number>();
        list2.add(new Integer(123));
        list2.add(new Double(12.34));
        Number first2 = list2.get(0);
        Number second2 = list2.get(1);
//        编译器如果能自动推断出泛型类型，就可以省略后面的泛型类型。例如，对于下面的代码：
        List<Number> list3 = new ArrayList<Number>();
        // 可以省略后面的Number，编译器可以自动推断泛型类型：
        List<Number> list4 = new ArrayList<>();
    }
}

//使用ArrayList时，如果不定义泛型类型时，泛型类型实际上就是Object：
//此时，只能把<T>当作Object使用，没有发挥泛型的优势。
//
//当我们定义泛型类型<String>后，List<T>的泛型接口变为强类型List<String>：

