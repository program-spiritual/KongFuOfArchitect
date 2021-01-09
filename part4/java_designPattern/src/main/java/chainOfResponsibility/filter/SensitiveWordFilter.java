package chainOfResponsibility.filter;


public interface SensitiveWordFilter {
    boolean doFilter(Content content);

    public default boolean filter(Content content) {
        if (!filterSexyWord(content)) {
            return false;
        }
        if (!filterAdsWord(content)) {
            return false;
        }
        if (!filterPoliticalWord(content)) {
            return false;
        }
        return true;
    }

    private boolean filterPoliticalWord(Content content) {
        return false;
    }

    private boolean filterAdsWord(Content content) {
        return false;
    }

    private boolean filterSexyWord(Content content) {
        //....
        return false;
    }
}
