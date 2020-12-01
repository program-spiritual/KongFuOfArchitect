package prototype.simple;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ServiceVersion {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    public void refresh() {
        HashMap<String,SearchWord> newKeywords = new LinkedHashMap<>();
        // 从数据库中取出所有的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
        assert toBeUpdatedSearchWords != null;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            newKeywords.put(searchWord.getKeyword(), searchWord);
        }
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords() {
        return null;
    }
}
