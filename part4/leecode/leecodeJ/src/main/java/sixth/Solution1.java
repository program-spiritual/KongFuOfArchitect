package sixth;

public class Solution1 {
  public int climbStairs(int n) {
    if (n == 0 || n == 1 || n == 2) {
      return n;
    }
    int[] mem = new int[n];
    mem[0] = 1;
    mem[1] = 2;

    for (int i = 2; i < n; i++) {
      mem[i] = mem[n - 1] + mem[n - 2];
    }

    return mem[n - 1];
  }

  public static void main(String[] args) {
    var a = new Solution1();
    System.out.println(a.climbStairs(3));
  }
}
