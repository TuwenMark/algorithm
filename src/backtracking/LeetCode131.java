package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: LeetCode131.分割回文串(https://leetcode.cn/problems/palindrome-partitioning/description/)——中等
 * @createDate: 2024/12/01
 */
public class LeetCode131 {
  private List<List<String>> result = new ArrayList<>();
  private List<String> path = new ArrayList<>();

  public List<List<String>> partition(String s) {
    backTracking(s, 0);
    return result;
  }

  private void backTracking(String s, int startIndex) {
    String substring = "";
    // 终止条件
    if (startIndex >= s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    // 单层搜索逻辑
    for (int i = startIndex; i < s.length(); i++) {
      // 切割线：startIndex，子串范围：[startIndex, i]
      // 获取子串
      substring = s.substring(startIndex, i + 1);
      // 非回文子串，则继续搜索
      if (!isPalindrome(substring)) {
        continue;
      }
      path.add(substring);
      // 递归
      backTracking(s, i + 1);
      // 回溯
      path.remove(path.size() - 1);
    }
  }

  private boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
