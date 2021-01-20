package sixth;

public class Solution4 {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    var res = 1;
    var len = nums.length;
    var dp = new int[len + 1];
    for (int i = 0; i < len; i++) {
      dp[i] = 1;
    }
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
