package fourth;

public class Trie {
  private final TrieNode root;

  public Trie() {
    this.root = new TrieNode();
    root.val = ' ';
  }

  public void insert(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null) {
        ws.children[c - 'a'] = new TrieNode(c);
      }
      ws = ws.children[c - 'a'];
    }
    ws.isWord = true;
  }

  public boolean search(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null) {
        return false;
      }
      ws = ws.children[c - 'a'];
    }
    return ws.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode ws = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (ws.children[c - 'a'] == null) {
        return false;
      }
      ws = ws.children[c - 'a'];
    }
    return true;
  }

}
