package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: LeetCode90.子集II(https://leetcode.cn/problems/subsets-ii/description/)——中等
 * @createDate: 2024/12/02
 */
public class LeetCode90 {
  private List<List<Integer>> result = new ArrayList<>();
  private List<Integer> path = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // 排序
    nums = Arrays.stream(nums).sorted().toArray();
    backTracking(nums, 0);
    return result;
  }

  private void backTracking(int[] nums, int startIndex) {
    // 收集结果
    result.add(new ArrayList<>(path));
    // 终止条件
    // 单层搜索逻辑
    for (int i = startIndex; i < nums.length; i++) {
      // 去重
      if (i > startIndex && nums[i] == nums[i - 1]) {
        continue;
      }
      path.add(nums[i]);
      // 递归
      backTracking(nums, i + 1);
      // 回溯
      path.remove(path.size() - 1);
    }
  }
}
