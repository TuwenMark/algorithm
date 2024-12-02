package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: LeetCode78.子集(https://leetcode.cn/problems/subsets/description/)——中等
 * @createDate: 2024/12/02
 */
public class LeetCode78 {
  private List<List<Integer>> result = new ArrayList<>();
  private List<Integer> path = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    backTracking(nums, 0);
    return result;
  }

  private void backTracking(int[] nums, int startIndex) {
    // 收集结果：保证[]和全集合都能收集
    result.add(new ArrayList<>(path));
    // 终止条件：可以省略，for循环会自动终止
    if (startIndex >= nums.length) {
      return;
    }
    // 单层搜索逻辑
    for (int i = startIndex; i < nums.length; i++) {
      path.add(nums[i]);
      // 递归
      backTracking(nums, i + 1);
      // 回溯
      path.remove(path.size() - 1);
    }
  }
}
