package adapter.unify;

public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{
    private BSensitiveWordsFilter bSensitiveWordsFilter;
    @Override
    public String filter(String text) {
        String maskedText = bSensitiveWordsFilter.filter(text);
        return maskedText;
    }
}
