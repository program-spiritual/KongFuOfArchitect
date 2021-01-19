class Solution2:
  def maxProduct(self, nums):
    if nums is None: return 0
    dp = [[0 for _ in range(2)] for _ in range(2)]
    dp[0][0], dp[0][1], res = nums[0], nums[0], nums[0]
    for i in range(1, len(nums)):
      x, y = i % 2, (i - 1) % 2
      dp[x][0] = max(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i])
      dp[x][1] = min(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i])
      res = max(res, dp[x][0])
    return res


if __name__ == '__main__':
  print([[0 for _ in range(2)] for _ in range(2)])
  a = Solution2()
  print(a.maxProduct([1,2,4,-5,10,22,-3,12]))