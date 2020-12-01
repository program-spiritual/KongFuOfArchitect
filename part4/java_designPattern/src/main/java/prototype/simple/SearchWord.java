package prototype.simple;

public class SearchWord {
    private Long count;
    private String keyword;
    private long lastUpdateTime;

    public SearchWord(Long count, String keyword, long lastUpdateTime) {
        this.count = count;
        this.keyword = keyword;
        this.lastUpdateTime = lastUpdateTime;
    }

    public SearchWord(String keyword, Long count, long lastUpdateTime) {
        this.count = count;
        this.keyword = keyword;
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getLastUpdateTime() {
        return 123;
    }

    public String getKeyword() {
        return null;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
