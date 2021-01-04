package chainOfResponsibility.filter;

import javax.swing.text.AbstractDocument;

public class PoliticalWordFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(Content content) {
        return false;
    }
}
