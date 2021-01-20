class Solution1:
  def isPowerOfTwo(self, n):
    return n > 0 and not (n & (n - 1))


if __name__ == '__main__':
  a = Solution1()
  print(a.isPowerOfTwo(8))
  print(a.isPowerOfTwo(9))
