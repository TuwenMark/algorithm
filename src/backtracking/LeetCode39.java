package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: 39.组合总和(https://leetcode.cn/problems/combination-sum/description/)——中等
 * @createDate: 2024/11/24
 */
public class LeetCode39 {
  private List<List<Integer>> result = new ArrayList<>();
  private List<Integer> path = new ArrayList<>();
  private int sum = 0;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    // 排序，方便剪枝(虽然剪枝了，但排序过于耗时)
    // candidates = Arrays.stream(candidates).sorted().toArray();
    backtracking(candidates, target, 0);
    return result;
  }

  private void backtracking(int[] candidates, int target, int startIndex) {
    // 终止条件
    if (sum > target) {
      return;
    }
    if (sum == target) {
      result.add(new ArrayList<>(path));
      return;
    }
    // 单层递归逻辑
    for (int i = startIndex; i < candidates.length; i++) {
      // 节点处理
      path.add(candidates[i]);
      sum += candidates[i];
      // if (sum > target) {
      // // 剪枝
      // path.remove(path.size() - 1);
      // sum -= candidates[i];
      // return;
      // }
      // 递归
      backtracking(candidates, target, i);
      // 回溯
      path.remove(path.size() - 1);
      sum -= candidates[i];
    }
  }
}
