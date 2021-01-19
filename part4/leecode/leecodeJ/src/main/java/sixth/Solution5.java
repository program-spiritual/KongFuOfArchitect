package sixth;

import java.util.Arrays;

public class Solution5 {
  int coinChange(int[] coins, int amount) {
    var dp = new int[amount + 1];
    Arrays.fill(dp, 12);
    dp[0] = 0;
    for (int i = 0; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          var min = Math.min(dp[i], (dp[i - coin] + 1));
          dp[i] = min;
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    var a = new Solution5();
    System.out.println(a.coinChange(new int[]{1, 2, 5}, 11));
  }


}
