package chainOfResponsibility.filter;


public class AdsWordFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(Content content) {
        return false;
    }
}
