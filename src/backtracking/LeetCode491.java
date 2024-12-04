package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Mr.Ye
 * @description: LeetCode491.非递减子序列(https://leetcode.cn/problems/non-decreasing-subsequences/description/)——中等
 * @createDate: 2024/12/03
 */
public class LeetCode491 {
  private List<List<Integer>> result = new ArrayList<>();
  private List<Integer> path = new ArrayList<>();

  public List<List<Integer>> findSubsequences(int[] nums) {
    backtracking(nums, 0);
    return result;
  }

  private void backtracking(int[] nums, int startIndex) {
    // 收集结果
    if (path.size() > 1) {
      result.add(new ArrayList<>(path));
    }
    // 去重集合
    Set<Integer> set = new HashSet<>();
    // 终止条件
     if (startIndex >= nums.length) {
      return;
     }
    // 单层搜索逻辑
    for (int i = startIndex; i < nums.length; i++) {
      // 去重
      if (set.contains(nums[i])) {
        continue;
      }
      // 子序列条件：递增
      if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]) {
        continue;
      }
      path.add(nums[i]);
      set.add(nums[i]);
      // 递归
      backtracking(nums, i + 1);
      // 回溯
      path.remove(path.size() - 1);
    }
  }
}
