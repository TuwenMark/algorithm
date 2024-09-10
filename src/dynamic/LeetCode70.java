package dynamic;

/**
 * @author: Mr. Ye
 * @description: LeetCode70.爬楼梯(https://leetcode.cn/problems/climbing-stairs/description/) —— 简单
 * 1. dp数组的含义：爬到第i阶楼梯总共有dp[i]种不同的方法
 * 2. 递推公式：第i阶楼梯只能从第i-1阶楼梯爬1阶或者第i-2阶楼梯爬2阶，故dp[i]=dp[i-1]+dp[i-2]
 * 3. 初始化：dp[1]=1, dp[2]=1
 * 4. 遍历顺序：从左往右，从小到大
 * 5. 打印dp数组
 * @createDate: 2024/08/09
 */
public class LeetCode70 {
  public static void main(String[] args) {
    System.out.println(climbStairs(2));
    System.out.println(climbStairs(3));
  }
  
  public static int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    // 维护前两阶台阶的状态
    int first = 1;
    int second = 2;
    for (int i = 3; i <= n; i++) {
      int sum = first + second;
      first = second;
      second = sum;
    }
    return second;
  }
}
