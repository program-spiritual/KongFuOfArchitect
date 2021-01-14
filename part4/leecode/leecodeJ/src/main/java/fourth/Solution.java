package fourth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  Set<String> res = new HashSet<>();

  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word :
      words) {
      trie.insert(word);
    }
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(board, visited, "", i, j, trie);
      }
    }
    return new ArrayList<String>(res);
  }

  private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
    if (x < 0 || x > board.length || y < 0 || y > board[0].length) {
      return;
    }
    if (visited[x][y]) {
      return;
    }
    str += board[x][y];
    if (!trie.startsWith(str)) {
      return;
    }
    if (trie.search(str)) {
      res.add(str);
    }
    visited[x][y] = true;
    dfs(board, visited, str, x - 1, y, trie);
    dfs(board, visited, str, x + 1, y, trie);
    dfs(board, visited, str, y - 1, y, trie);
    dfs(board, visited, str, y + 1, y, trie);

    visited[x][y] = true;
  }
}
