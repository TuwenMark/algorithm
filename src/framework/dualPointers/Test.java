package framework.dualPointers;

import java.util.HashMap;
import java.util.Map;

public class Test {
  /**
   * 字符串的排列
   * 
   * @param s1 子串
   * @param s2 目标字符串
   * @return 是否存在 s1 的排列之一是 s2 的子串
   */
  public static boolean checkInclusion(String s1, String s2) {
    // 初始化
    int left = 0, right = 0, valid = 0;
    Map<Character, Integer> need = new HashMap<>(5);
    Map<Character, Integer> window = new HashMap<>(5);
    // need赋值
    for (char c : s1.toCharArray()) {
      updateMap(need, c, 1);
    }

    // 窗口滑动
    while (right < s2.length()) {
      // 窗口增大
      char cRight = s2.charAt(right);
      right++;
      // 更新数据
      if (need.containsKey(cRight)) {
        updateMap(window, cRight, 1);
        if (window.get(cRight).equals(need.get(cRight))) {
          valid++;
        }
      } else {
        left = right - 1;
        valid = 0;
        window.clear();
      }

      // 缩小窗口（维护定长窗口，此处只判断一次，可改为if）
      while (right - left >= s1.length()) {
        if (valid == need.size()) {
          System.out.println(cRight);
          char charAt = s2.charAt(left);
          System.out.println(1);
          return true;
        }
        // 更新数据
        char cLeft = s2.charAt(left);
        left++;
        if (need.containsKey(cLeft)) {
          if (window.get(cLeft).equals(need.get(cLeft))) {
            valid--;
          }
          updateMap(window, cLeft, -1);
        }
      }
    }
    return false;
  }

  /**
   * 更新map的目标字符个数
   * 
   * @param map 目标map
   * @param c   目标字符
   * @param num 更新的字符个数
   */
  public static void updateMap(Map<Character, Integer> map, char c, int num) {
    if (map.containsKey(c)) {
      map.put(c, map.get(c) + num);
    } else {
      map.put(c, 1);
    }
  }

  public static void main(String[] args) {
    String s1 = "qff";
    String s2 = "ifisnoskikfqzrmzlv";

    System.out.println(checkInclusion(s1, s2));
  }
}
