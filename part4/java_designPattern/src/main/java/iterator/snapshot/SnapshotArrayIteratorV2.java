package iterator.snapshot;

import java.util.Iterator;

public class SnapshotArrayIteratorV2<E> implements Iterator<E> {
    private final long snapshotTimestamp;
    private int cursorInAll; // 在整个容器中的下标，而非快照中的下标
    private int leftCount;  //快照中还有几个元素未被遍历
    private final ArrayList<E> arrayList;

    public SnapshotArrayIteratorV2(ArrayList<E> arrayList) {
        this.snapshotTimestamp = System.currentTimeMillis();
        this.cursorInAll = 0;
        this.leftCount = arrayList.actualSize();
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return this.leftCount >= 0; // 注意是>=, 而非>
    }

    @Override
    public E next() {
        E currentItem = arrayList.get(cursorInAll);
        justNext();
        return currentItem;
    }

    private void justNext() {
        while (cursorInAll < arrayList.totalSize()) {
            long addTimestamp = arrayList.getAddTimestamp(cursorInAll);
            long delTimestamp = arrayList.getDelTimestamp(cursorInAll);
            if (snapshotTimestamp > addTimestamp && snapshotTimestamp < delTimestamp) {
                leftCount--;
                break;
            }
            cursorInAll++;
        }
    }
}
