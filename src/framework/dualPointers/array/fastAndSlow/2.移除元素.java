package framework.dualPointers.array.fastAndSlow;

/**
 * @author: Mr. Ye
 * @description: 27. 移除元素：对数组中的某些元素进行「原地删除」
 * @createDate: 2024/04/06
 */

class Solution {
  public int removeElement(int[] nums, int val) {
    // 初始化快慢指针索引为0
    int slow = 0;
    int fast = 0;
    // fast指针到达数组末尾结束
    while (fast < nums.length) {
      if (nums[fast] != val) {
        // 注意和删除有序数组中的重复项的区别，第一个元素一定保留，此处第一个元素可能需要移除，故下面步骤顺序相反
        // 保证nums[0..slow-1]不包含重复元素
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    // slow已经+1过了
    return slow;
  }
}
