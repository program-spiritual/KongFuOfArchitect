package strategy.sort;

public class AlgRange {
    private long start;
    private long end;
    private ISortAlg alg;

    public AlgRange(long start, long end, ISortAlg alg) {
        this.start = start;
        this.end = end;
        this.alg = alg;
    }

    public ISortAlg getAlg() {
        return alg;
    }

    public boolean inRange(long size) {
        return size >= start && size < end;
    }
}
