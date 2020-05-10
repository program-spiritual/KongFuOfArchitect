import java.util.Objects;

public class WriteGenericsDemo1 {
    public static void main(String[] args) {

    }
}

//首先，按照某种类型，例如：String，来编写类：

class Pair<T> {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?> pair = (Pair<?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(last, pair.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public Pair(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        first = clazz.newInstance();
        last = clazz.newInstance();
    }
    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }

    public T getLast() {
        return last;
    }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}
//特定类型String替换为T，并申明<T>：

