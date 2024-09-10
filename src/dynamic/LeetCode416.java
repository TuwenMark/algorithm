package dynamic;

/**
 * @author: Mr. Ye
 * @description: LeetCode416.
 *               分割等和子集(https://leetcode.cn/problems/partition-equal-subset-sum/description/)
 *               —— 中等
 *               1. dp数组的含义：容量为j的背包所能装下的最大价值，上限为target的子集的最大元素和；
 *               2. 递推公式：dp[j] = dp[j] + dp[j - nums[i]] +
 *               nums[i](此处的nums[i]既是重量又是价值)
 *               3. 初始化：整个数组均为0
 *               4. 遍历顺序：先物品后背包，背包倒序遍历
 *               5. 打印dp数组
 * @createDate: 2024/08/13
 */
public class LeetCode416 {

    public static void main(String[] args) {
        // true
        // int[] nums = { 1, 5, 11, 5 };
        // false
        int[] nums = { 1, 2, 3, 5 };
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        // 边界条件
        if (nums.length <= 1) {
            return false;
        }
        // 计算target
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 初始化
        int target = sum / 2;
        // 包括0元素
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if (dp[dp.length - 1] != target) {
            return false;
        }
        return true;
    }
}
