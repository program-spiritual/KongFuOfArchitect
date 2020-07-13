import java.util.List;

public class extendsWildcardDemo2 {
    public static void main(String[] args) {

    }
//注意到List<? extends Integer>的限制：
//允许调用get()方法获取Integer的引用；
//不允许调用set(? extends Integer)方法并传入任何Integer的引用（null除外）。
//    因此，方法参数类型List<? extends Integer>表明了该方法内部只会读取List的元素，
//   不会修改List的元素（因为无法调用add(? extends Integer)、remove(? extends Integer)这些方法。
//  换句话说，这是一个对参数List<? extends Integer>进行只读的方法（恶意调用set(null)除外）。
    int sumOfList(List<? extends Integer> list) {
        int sum = 0;
        for (int i=0; i<list.size(); i++) {
            Integer n = list.get(i);
            sum = sum + n;
        }
        return sum;
    }
}
