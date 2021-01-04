package iterator.basic;

public interface Iterator<E> {
    boolean hasNext();

    void next();

    E currentItem();
}
