package dynamic;

/**
 * @author: Mr. Ye
 * @description: LeetCode62.
 *               不同路径(https://leetcode.cn/problems/unique-paths/description/) —— 中等
 * 1. 确定dp数组的含义：到达第[i,j]点总共有dp[i,j]种不同的路径
 * 2. 递推公式：dp[i,j] = dp[i,j-1] + dp[i-1,j]
 * 3. 初始化：dp[0,j] = 1, dp[i,0] = 1
 * 3. 确定遍历顺序：先上左，再下右
 * 4. 打印dp数组
 * @createDate: 2024/08/11
 */
public class LeetCode62 {

    public static void main(String[] args) {
        // 28
        System.out.println(uniquePaths(3, 7));
        // 3
        System.out.println(uniquePaths(3, 2));
        // 28
        System.out.println(uniquePaths(7, 3));
        // 6
        System.out.println(uniquePaths(3, 3));
    }
    
    public static int uniquePaths(int m, int n) {
        // 边界处理
        if (m == 1 || n == 1) {
            return 1;
        }
        // 初始化
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 递推公式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j- 1] + dp[i - 1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
