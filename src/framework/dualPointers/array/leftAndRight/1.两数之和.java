package framework.dualPointers.array.leftAndRight;

/**
 * @author: Mr. Ye
 * @description: 167. 两数之和 - 输入有序数组
 * @createDate: 2024/04/06
 */

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    // 初始化左右指针索引，相向而行
    int left = 0;
    int right = numbers.length - 1;
    // 左右移动寻找target
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target) {
        return new int[] { left + 1, right + 1 };
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[]{-1, -1};
  }
}
