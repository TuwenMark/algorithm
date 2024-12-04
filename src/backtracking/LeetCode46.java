package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: LeetCode46.全排列(https://leetcode.cn/problems/permutations/description/)——中等
 * @createDate: 2024/12/05
 */
public class LeetCode46 {
  private List<List<Integer>> result = new ArrayList<>();
  private List<Integer> path = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    int[] used = new int[nums.length];
    backtracking(nums, used);
    return result;
  }

  private void backtracking(int[] nums, int[] used) {
    // 终止条件
    if (path.size() == nums.length) {
      // 收集结果
      result.add(new ArrayList<>(path));
      return;
    }
    // 单层搜索逻辑
    for (int i = 0; i < nums.length; i++) {
      // 去重
      if (used[i] == 1) {
        continue;
      }
      path.add(nums[i]);
      used[i] = 1;
      // 递归
      backtracking(nums, used);
      // 回溯
      path.remove(path.size() - 1);
      used[i] = 0;
    }
  }
}
