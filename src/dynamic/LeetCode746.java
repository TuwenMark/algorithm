package dynamic;

/**
 * @author: Mr. Ye
 * @description: LeetCode746.
 *               使用最小花费爬楼梯(https://leetcode.cn/problems/min-cost-climbing-stairs/description/)
 *               —— 简单
 *               1. dp数组的含义：爬到i层楼梯的最小花费dp[i]
 *               2. 递推公式：dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
 *               3. 初始化：dp[0] = 0, dp[1] = 0
 *               4. 遍历顺序：从左往右，从小往大
 *               5. 打印dp数组
 * @createDate: 2024/08/11
 */
public class LeetCode746 {

    public static void main(String[] args) {
        // 案例一：15
        // int[] cost = { 10, 15, 20 };
        // System.out.println(minCostClimbingStairs(cost));
        // 案例二：6
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        // 楼梯顶部是cost.length
        if (cost.length <= 1) {
            return 0;
        }
        // 初始化
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            int dpi = Math.min((dp[0] + cost[i - 2]), (dp[1] + cost[i - 1]));
            dp[0] = dp[1];
            dp[1] = dpi;
        }
        return dp[1];
    }
}
