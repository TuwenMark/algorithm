package array;

/**
 * @author: Mr. Ye
 * @description: LeetCode27.
 *               移除元素(https://leetcode.cn/problems/remove-element/description/) —— 简单
 * 快指针：找到新数组的元素
 * 慢指针：指向新数组元素放置的位置
 * @createDate: 2024/09/10
 */
public class LeetCode27 {
  
  public int removeElement(int[] nums, int val) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
    }
    return slow;
  }
}
