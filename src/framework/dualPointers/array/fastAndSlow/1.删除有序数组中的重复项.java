package framework.dualPointers.array.fastAndSlow;

/**
 * @author: Mr. Ye
 * @description: 26. 删除有序数组中的重复项：原地去重数组
 * @createDate: 2024/04/06
 */

class Solution {
  public int removeDuplicates(int[] nums) {
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != nums[slow]) {
        slow++;
        // 维护[0...slow]无重复
        nums[slow] = nums[fast];
      }
      fast++;
    }
    // 数组的长度是索引 + 1
    return slow + 1;
  }
}
