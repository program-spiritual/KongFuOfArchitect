package chainOfResponsibility.filter;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.List;

public class SensitiveWordFilterChain {
    private final List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter) {
        this.filters.add(filter);
    }

    public boolean filter(Content content) {
        for (SensitiveWordFilter filter : filters) {
            if (!filter.doFilter(content)) {
                return false;
            }
        }
        return true;
    }
}
