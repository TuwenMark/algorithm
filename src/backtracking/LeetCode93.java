package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.Ye
 * @description: LeetCode93.复原IP地址(https://leetcode.cn/problems/restore-ip-addresses/description/)——中等
 * @createDate: 2024/12/01
 */
public class LeetCode93 {
  public static void main(String[] args) {
    String s = "0279245587303";
    System.out.println(restoreIpAddresses(s));
  }

  private static List<String> result = new ArrayList<>();
  private static String subString = "";

  public static List<String> restoreIpAddresses(String s) {
    StringBuilder sb = new StringBuilder(s);
    backTracking(sb, 0, 0);
    return result;
  }

  private static void backTracking(StringBuilder s, int pointSum, int startIndex) {
    // 终止条件
    if (pointSum == 3) {
      // 注意句号在末尾
      if (startIndex < s.length() && isValid(s.substring(startIndex))) {
        result.add(s.toString());
      }
      return;
    }
    // 单层搜索逻辑
    for (int i = startIndex; i < s.length(); i++) {
      subString = s.substring(startIndex, i + 1);
      if (!isValid(subString)) {
        return;
      }
      // 添加句点
      s.insert(i + 1, '.');
      pointSum++;
      // 递归
      backTracking(s, pointSum, i + 2);
      // 回溯
      s.deleteCharAt(i + 1);
      pointSum--;
    }
  }

  private static boolean isValid(String s) {
    // 长度不能大于3
    if (s.length() > 3) {
      return false;
    }
    // 大于1位数不能含有前导0
    if (s.length() > 1 && s.charAt(0) == '0') {
      return false;
    }
    // 数字在0-255之间
    int segment = Integer.parseInt(s);
    if (segment > 255) {
      return false;
    }
    return true;
  }
}
