class Solution():
  def solveNQueens(self, n):

    def DFS(queens, diff, sum):
      p = len(queens)
      if p == n:
        result.append(queens)
        return None
      for q in range(n):
        if q not in queens and p + q not in sum and p - q not in diff:
          DFS(queens + [q], diff + [p - q], sum + [p + q])

    result = []
    DFS([], [], [])
    return [["." * i + "Q" + "." * (n - i - 1) for i in s] for s in result]


if __name__ == '__main__':
  aaa = Solution()
  res = aaa.solveNQueens(4)
  print(res)
