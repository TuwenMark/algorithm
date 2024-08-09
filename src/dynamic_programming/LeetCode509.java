package dynamic_programming;

/**
 * @author: Mr. Ye
 * @description: LeetCode509.斐波那契数(https://leetcode.cn/problems/fibonacci-number/description/) —— 简单
 *               1. dp数组的含义：第n个斐波那契数的值；
 *               2. 递推公式：dp(n) = dp(n-1) + dp(n-2);
 *               3. 初始化：dp(0) = 1, dp(1) = 1;
 *               4. 遍历顺序：从左往右，从大到小；
 *               5. 打印dp数组
 * @createDate: 2024/08/09
 */
public class LeetCode509 {

  public static void main(String[] args) {
    System.out.println(fib(2));
    System.out.println(fib(3));
    System.out.println(fib(4));
  }

  public static int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    // 解法一：维护整个数组
    // int[] dp = new int[n + 1];
    // dp[0] = 0;
    // dp[1] = 1;
    // for (int i = 2; i <= n; i++) {
    //   dp[i] = dp[i - 1] + dp[i - 2];
    // }
    // return dp[n];

    // 解法二：只维护两个变量
    int[] dp = new int[2];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++) {
      int sum = dp[0] + dp[1];
      dp[0] = dp[1];
      dp[1] = sum;
    }
    return dp[1];
  } 
}
