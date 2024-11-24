package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: 17.电话号码的字母组合(https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/)——中等
 * @createDate: 2024/11/24
 */
public class LeetCode17 {

  private String[] letterArray = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
  private List<String> result = new ArrayList<>();
  private StringBuilder path = new StringBuilder();

  public List<String> letterCombinations(String digits) {
    if (("").equals(digits)) {
      return Collections.emptyList();
    }
    backtracking(digits, 0);
    return result;
  }

  private void backtracking(String digits, int index) {
    // 终止条件
    if (path.length() == digits.length()) {
      result.add(path.toString());
      return;
    }
    // 单层递归逻辑
    String letter = letterArray[Character.getNumericValue(digits.charAt(index))];
    for (int i = 0; i < letter.length(); i++) {
      // 处理节点
      path.append(letter.charAt(i));
      // 递归，index控制遍历第几个字符串
      backtracking(digits, index + 1);
      // 回溯
      path.deleteCharAt(path.length() - 1);
    }
  }
}
