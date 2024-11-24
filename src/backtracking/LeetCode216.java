package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: 216.组合总和 III(https://leetcode.cn/problems/combination-sum-iii/)——中等
 * @createDate: 2024/11/24
 */
public class LeetCode216 {

  private List<List<Integer>> result = new ArrayList<>();
  private List<Integer> path = new ArrayList<>();
  private int sum = 0;

  public List<List<Integer>> combinationSum3(int k, int n) {
    backtracking(k, n, 1);
    return result;
  }

  private void backtracking(int k, int n, int startIndex) {
    // 终止条件
    if (path.size() == k) {
      if (sum == n) {
        result.add(new ArrayList<>(path));
      }
      return;
    }

    // 单层递归逻辑，剪枝1：边界范围
    for (int i = startIndex; i <= (9 - (k - path.size()) + 1); i++) {
      // 节点处理
      path.add(i);
      sum += i;
      // 剪枝2：总和超过范围
      if (sum > n) {
        // 剪枝前先回溯
        path.remove(path.size() - 1);
        sum -= i;
        return;
      }
      // 递归
      backtracking(k, n, i + 1);
      // 回溯
      path.remove(path.size() - 1);
      sum -= i;
    }
  }
}
