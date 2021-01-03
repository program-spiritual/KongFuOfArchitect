package adapter.unify;

public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{
   private CSensitiveWordsFilter cSensitiveWordsFilter;

    @Override
    public String filter(String text) {
        return cSensitiveWordsFilter.filter(text,"");
    }
}
