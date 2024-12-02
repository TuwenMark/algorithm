package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: 40.组合总和II(https://leetcode.cn/problems/combination-sum-ii/description/)——中等
 * @createDate: 2024/11/28
 */
public class LeetCode40 {
  public static void main(String[] args) {
    int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
    int target = 8;
    // 1 1 2 5 6 7 10
    combinationSum2(candidates, target);
  }

  private static List<List<Integer>> result = new ArrayList<>();
  private static List<Integer> path = new ArrayList<>();
  private static int sum = 0;
  private static int temp = sum;

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    // int[] used = new int[candidates.length];
    candidates = Arrays.stream(candidates).sorted().toArray();
    // backtracking(candidates, target, 0, used);
    backtracking(candidates, target, 0);
    return result;
  }

  // 方法一：使用used数组去重
  // private static void backtracking(int[] candidates, int target, int
  // startIndex, int[] used) {
  // // 终止条件
  // if (sum > target) {
  // return;
  // }
  // if (sum == target) {
  // // 收集结果
  // result.add(new ArrayList<>(path));
  // return;
  // }
  // // 循环
  // for (int i = startIndex; i < candidates.length; i++) {
  // // 剪枝去重：至少从第二个元素开始，和前面元素相同，且前面元素没有取
  // if (i > 0 && candidates[i - 1] == candidates[i] && used[i - 1] == 0) {
  // continue;
  // }
  // // 剪枝：若上一个元素和已经大于target，下一个肯定更大，没有必要放入进行比较
  // if (temp >= target) {
  // return;
  // }
  // // 单层搜索逻辑
  // path.add(candidates[i]);
  // sum += candidates[i];
  // used[i] = 1;
  // // 递归
  // backtracking(candidates, target, i + 1, used);
  // // 回溯
  // path.remove(path.size() - 1);
  // // 记录上一个元素的和
  // temp = sum;
  // sum -= candidates[i];
  // used[i] = 0;
  // }
  // }

  // 方法二：使用startIndex去重
  private static void backtracking(int[] candidates, int target, int startIndex) {
    // 终止条件
    if (sum > target) {
      return;
    }
    if (sum == target) {
      result.add(new ArrayList<>(path));
      return;
    }
    // 单层搜索逻辑
    for (int i = startIndex; i < candidates.length; i++){
      // 树层去重，树枝不去重
      if (i > startIndex && candidates[i] == candidates[i - 1]) {
        continue;
      }
      // 剪枝：若上一个元素和已经大于target，下一个肯定更大，没有必要放入进行比较
      if (temp >= target) {
        return;
      }
      path.add(candidates[i]);
      sum += candidates[i];
      // 递归
      backtracking(candidates, target, i + 1);
      // 回溯
      path.remove(path.size() - 1);
      // 记录上一个元素的和
      temp = sum;
      sum -= candidates[i];
    }
  }
}
