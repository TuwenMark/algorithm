package framework.dualPointers.array.fastAndSlow.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Mr. Ye
 * @description: 76. 最小覆盖子串
 * @createDate: 2024/04/10
 */

class Solution {
  /**
   * s 中涵盖 t 所有字符的最小子串
   * 
   * @param s 原字符串
   * @param t 目标字符串
   * @return s 中涵盖 t 所有字符的最小子串
   */
  public String minWindow(String s, String t) {
    int strLen = s.length();
    // 初始化快慢指针为索引0，即窗口为0，有效字符数
    int left = 0, right = 0, valid = 0;
    // 分别记录需要的字符数和窗口中的目标字符数
    Map<Character, Integer> need = new HashMap<>(strLen), window = new HashMap<>(strLen);
    // 初始化子串的起始索引和长度
    int start = 0, end = 0, len = Integer.MAX_VALUE;

    // 记录需要的字符数
    for (char c : t.toCharArray()) {
      updateMap(c, need, 1);
    }

    while (right < strLen) {
      // 扩大窗口
      char cRight = s.charAt(right);
      right++;
      // 更新数据，添加目标字符数
      if (need.containsKey(cRight)) {
        updateMap(cRight, window, 1);
        // 更新有效字符数
        if (window.get(cRight).equals(need.get(cRight))) {
          valid++;
        }
      }

      // 缩小窗口（有效字符数达到了目标字符数）
      while (valid == need.size()) {
        if (right - left < len) {
          // 左闭右开
          start = left;
          end = right;
          len = right - left;
        }
        char cLeft = s.charAt(left);
        left++;
        // 更新数据，移除目标字符
        if (need.containsKey(cLeft)) {
          // 更新有效字符数（此处顺序和updateMap不能颠倒，不等于可能是大于）
          if (window.get(cLeft).equals(need.get(cLeft))) {
            valid--;
          }
          updateMap(cLeft, window, -1);
        }
      }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
  }

  /**
   * 更新map的目标字符个数
   * 
   * @param c 目标字符
   * @param map 目标map
   * @param num 更新的字符个数
   */
  public void updateMap(char c, Map<Character, Integer> map, int num) {
    if (map.containsKey(c)) {
      map.put(c, map.get(c) + num);
    } else {
      map.put(c, 1);
    }
  }
}
