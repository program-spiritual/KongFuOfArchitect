import java.util.ArrayList;

public class GenericDemo1 {
    public static void main(String[] args) {
//        为了解决新的问题，我们必须把ArrayList变成一种模板：ArrayList<T>，代码如下：
        /**
         * public class ArrayList<T> {
         *     private T[] array;
         *     private int size;
         *     public void add(T e) {...}
         *     public void remove(int index) {...}
         *     public T get(int index) {...}
         * }
         * */

//        T可以是任何class。这样一来，我们就实现了：编写一次模版，可以创建任意类型的ArrayList：
        // 创建可以存储String的ArrayList:
        ArrayList<String> strList = new ArrayList<String>();
// 创建可以存储Float的ArrayList:
        ArrayList<Float> floatList = new ArrayList<Float>();
// 创建可以存储Person的ArrayList:
        ArrayList<Person> personList = new ArrayList<Person>();
//        因此，泛型就是定义一种模板，例如ArrayList<T>，然后在代码中为用到的类创建对应的ArrayList<类型>：
//        ArrayList<String> strList = new ArrayList<String>();
        strList.add("hello"); // OK
        String s = strList.get(0); // OK
//        strList.add(new Integer(123)); // compile error!
//        Integer n = strList.get(0); // compile error!
        // 创建ArrayList<Integer>类型：
        ArrayList<Integer> integerList = new ArrayList<Integer>();
// 添加一个Integer：
        integerList.add(new Integer(123));
// “向上转型”为ArrayList<Number>：
        ArrayList<Integer> numberList = integerList;
// 添加一个Float，因为Float也是Number：
//        numberList.add(new Float(12.34));
// 从ArrayList<Integer>获取索引为1的元素（即添加的Float）：
        Integer n = integerList.get(1); // ClassCastException!
//         ArrayList<Integer>和ArrayList<Number>两者完全没有继承关系。
    }
}
