package useIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//虽然ReverseList和ReverseIterator的实现类稍微比较复杂，但是，注意到这是底层集合库，
//只需编写一次。而调用方则完全按for each循环编写代码，
//根本不需要知道集合内部的存储逻辑和遍历逻辑。

public class ReverseList<T> implements Iterable<T> {

  private List<T> list = new ArrayList<>();

  public void add(T t) {
    list.add(t);
  }

  @Override
  public Iterator<T> iterator() {
    return new ReverseIterator(list.size());
  }

  class ReverseIterator implements Iterator<T> {

    int index;

    ReverseIterator(int index) {
      this.index = index;
    }

    @Override
    public boolean hasNext() {
      return index > 0;
    }

    @Override
    public T next() {
      index--;
      return ReverseList.this.list.get(index);
    }
  }
}
//在编写Iterator的时候，我们通常可以用一个内部类来实现Iterator接口，
//这个内部类可以直接访问对应的外部类的所有字段和方法。
//例如，上述代码中，内部类ReverseIterator可以用ReverseList.this获得当前外部类的this引用，
//然后，通过这个this引用就可以访问ReverseList的所有字段和方法。
