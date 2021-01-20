class Solution6:
  def minDistance(self, word1, word2):
    m, n = len(word1), len(word2)
    dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    for i in range(m + 1):
      dp[i][0] = i
    for j in range(n + 1):
      dp[0][j] = j

    for i in range(1, m + 1):
      for j in range(1, n + 1):
        dp[i][j] = min(dp[i - 1][j - 1] + (0 if word1[i - 1] == word2[j - 1] else 1),
                       dp[i - 1][j] + 1,
                       dp[i][j - 1] + 1
                       )
        return dp[i][j]


if __name__ == '__main__':
  a = Solution6()
  print(a.minDistance('attention', 'tation'))
