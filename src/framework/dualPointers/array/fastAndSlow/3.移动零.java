package framework.dualPointers.array.fastAndSlow;

/**
 * @author: Mr. Ye
 * @description: 283. 移动零：原地移动零至数组尾端
 * @createDate: 2024/04/06
 */

class Solution {
  public void moveZeroes(int[] nums) {
    // 快慢指针初始化为索引0
    int slow = 0;
    int fast = 0;
    // 快指针移动到数组末端结束
    while (fast < nums.length) {
      if (nums[fast] != 0) {
        // 交换非0的元素
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    // 数组剩余元素归0
    for (int i = slow; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
