package dynamic_programming;

/**
 * @author: Mr. Ye
 * @description: LeetCode63.不同路径
 *               II(https://leetcode.cn/problems/unique-paths-ii/description/)
 *               —— 中等
 *               1. 确定dp数组的含义：到达[i,j]点总共有dp[i][j]种不同的路径
 *               2. 递推公式：dp[i][j] = dp[i][j-1] + dp[i-1][j]
 *               3. 初始化：dp[0][j] = 1, dp[i][0] = 1 && obstacleGrid[i][j] == 0
 *               4. 确定遍历顺序：从上到下，从左到右
 *               5. 打印dp数组
 * @createDate: 2024/08/11
 */
public class LeetCode63 {

    public static void main(String[] args) {
        // 2
        // int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        // 1
        int[][] obstacleGrid = { { 0, 1 }, { 0, 0 } };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 处理边界
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        // 递推公式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    static void printArray(int[][] array) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append('[');
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]).append(',');
            }
            sb.deleteCharAt(sb.length() - 1).append("],");
        }
        sb.deleteCharAt(sb.length() - 1).append(']');
        System.out.println(sb);
    }
}
