class Solution():
  def generateParentesis(self, n):
    self.list = []
    self._generator(0, 0, n, "")
    return self.list

  def _generator(self, left, right, n, result):
    if left == n and right == n:
      self.list.append(result)
      return
    if left < n:
      self._generator(left + 1, right, n, result + "(")
    if left > right and right < n:
      self._generator(left, right + 1, n, result + ")")


if __name__ == '__main__':
  aaa = Solution()
  res = aaa.generateParentesis(3)
  print(res)
