class Solution:
  def hammingWeight(self, n):
    rst = 0
    mask = 1
    for i in range(32):
      if n & mask:
        rst += 1
      mask = mask << 1
    return rst


if __name__ == '__main__':
  a = Solution()
  print(a.hammingWeight(34))