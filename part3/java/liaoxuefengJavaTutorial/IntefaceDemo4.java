import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IntefaceDemo4 {
    public static void main(String[] args) {
       //在使用的时候，实例化的对象永远只能是某个具体的子类，但总是通过接口去引用它，因为接口比抽象类更抽象：
        List list = new ArrayList(); // 用List接口引用具体子类的实例
        Collection coll = list; // 向上转型为Collection接口
        Iterable it = coll; // 向上转型为Iterable接口
    }
}

//合理设计interface和abstract class的继承关系，可以充分复用代码。
//一般来说，公共逻辑适合放在abstract class中，具体逻辑放到各个子类，
//而接口层次代表抽象程度。可以参考Java的集合类定义的一组接口、抽象类以及具体子类的继承关系：
//┌───────────────┐
//│   Iterable    │
//└───────────────┘
//        ▲                ┌───────────────────┐
//        │                │      Object       │
//┌───────────────┐        └───────────────────┘
//│  Collection   │                  ▲
//└───────────────┘                  │
//        ▲     ▲          ┌───────────────────┐
//        │     └──────────│AbstractCollection │
//┌───────────────┐        └───────────────────┘
//│     List      │                  ▲
//└───────────────┘                  │
//              ▲          ┌───────────────────┐
//              └──────────│   AbstractList    │
//                         └───────────────────┘
//                                ▲     ▲
//                                │     │
//                                │     │
//                     ┌────────────┐ ┌────────────┐
//                     │ ArrayList  │ │ LinkedList │
//                     └────────────┘ └────────────┘

