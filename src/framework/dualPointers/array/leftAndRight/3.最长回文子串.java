package framework.dualPointers.array.leftAndRight;

/**
 * @author: Mr. Ye
 * @description: 5. 最长回文子串
 * @createDate: 2024/04/06
 */

class Solution {
  /**
   * 最长回文子串
   * 
   * @param s 目标字符串
   * @return 目标字符串的最长回文子串
   */
  public String longestPalindrome(String s) {
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      // 寻找长度为奇数的回文串
      String s1 = palindrome(s, i, i);
      // 寻找长度为偶数的回文串
      String s2 = palindrome(s, i, i + 1);
      res = res.length() > s1.length() ? res : s1;
      res = res.length() > s2.length() ? res : s2;
    }
    return res;
  }

  /**
   * 给定两个起始中间点求回文串
   * 
   * @param s     目标字符串
   * @param left  目标字符串的左索引
   * @param right 目标字符串的右索引
   * @return 从左右索引向两边的回文串
   */
  public String palindrome(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }

  /**
   * 是否回文串
   * 
   * @param s 目标字符串
   * @return 字符串是否是回文串
   */
  public boolean isPalindrome(String s) {
    // 初始化左右指针索引相向而行
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      // 若有任意左右字符不相等，则此字符串非回文串
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
    }
    return true;
  }
}
