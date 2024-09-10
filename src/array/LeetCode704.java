package array;

/**
 * @author: Mr. Ye
 * @description: LeetCode704.
 *               二分查找(https://leetcode.cn/problems/binary-search/description/)
 *               —— 简单
 * @createDate: 2024/09/09
 */
public class LeetCode704 {

  public int search(int[] nums, int target) {
    // 左闭右闭
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] > target) {
        right = middle - 1;
      } else if (nums[middle] < target) {
        left = middle + 1;
      } else {
        return middle;
      }
    }
    return -1;
  }
}
