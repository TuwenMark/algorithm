package dynamic;

/**
 * @author: Mr. Ye
 * @description: LeetCode343.整数拆分(https://leetcode.cn/problems/integer-break/description/) —— 中等
 * 1. dp数组的含义：对i进行拆分，得到的最大乘积为dp[i]
 * 2. 递推公式：dp[i] = Math.max(i * (i - j), i * dp[i-j],dp[i])
 * 3. 初始化：i>=2，dp[2] = 1
 * 4. 遍历顺序：从小到大
 * 5. 打印dp数组
 * @createDate: 2024/08/11
 */
public class LeetCode343 {

    public static void main(String[] args) {
        // 1
        System.out.println(integerBreak(2));
        //36
        System.out.println(integerBreak(10));
    }
    
    public static int integerBreak(int n) {
        // 边界条件，初始化
        if (n == 2) {
            return 1;
        }
        // 递推公式
        int[] dp = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                // dp[i] = Math.max(Math.max(j * (i - j), j * dp[i-j]), dp[i]);
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = temp > dp[i] ? temp : dp[i];
            }
        }
        return dp[n];
    }
}
