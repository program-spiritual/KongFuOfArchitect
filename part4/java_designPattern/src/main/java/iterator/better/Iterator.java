package iterator.better;

public interface Iterator<E> {
    boolean hasNext();

    E next();

    E currentItem();
}
