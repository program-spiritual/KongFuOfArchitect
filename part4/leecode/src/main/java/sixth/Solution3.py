from pip._vendor.urllib3.connectionpool import xrange


class Solution3(object):
  def maxProfit(self, prices, maxint=10000):
    if not prices: return 0
    profit = [[[0 for _ in xrange(2)] for _ in xrange(3)] for _ in xrange(len(prices))]
    profit[0][0][0] = 0
    profit[0][0][1] = -prices[0]
    profit[0][1][0] = -maxint
    profit[0][1][1] = -maxint
    profit[0][2][0] = -maxint
    profit[0][2][1] = -maxint
    for i in range(1, len(prices)):
      profit[i][0][0] = profit[i - 1][0][0]
      profit[i][0][1] = max(profit[i - 1][0][1], profit[i][0][0] - prices[i])

      profit[i][1][0] = max(profit[i - 1][1][0], profit[i][0][1] + prices[i])
      profit[i][1][1] = max(profit[i - 1][1][1], profit[i][1][0] - prices[i])

      profit[i][2][0] = max(profit[i - 1][2][0], profit[i - 1][1][1] + prices[i])
    end = len(prices) - 1

    return max(profit[end][0][0], profit[end][1][0], profit[end][2][0])


if __name__ == '__main__':
  arr = [12, 3, 34, 45, 45, 56, 567]
  nested_arr = [[[0 for _ in xrange(2)] for _ in xrange(3)] for _ in xrange(len(arr))]
  print(nested_arr)
  a = Solution3()
  print(a.maxProfit(arr))
