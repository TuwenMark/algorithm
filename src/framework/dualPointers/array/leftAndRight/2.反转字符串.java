package framework.dualPointers.array.leftAndRight;

/**
 * @author: Mr. Ye
 * @description: 344. 反转字符串
 * @createDate: 2024/04/06
 */

class Solution {
  public void reverseString(char[] s) {
    // 初始化左右指针索引相向而行
    int left = 0;
    int right = s.length - 1;
    while (left < right) {
      // 交换左右指针的值
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;
      left++;
      right--;
    }
  }
}
