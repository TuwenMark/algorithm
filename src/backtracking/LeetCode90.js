/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
  let result = [],
    path = []

  const backTracking = function (_nums, startIndex) {
    // 收集结果
    result.push(path.slice())
    // 终止条件
    // 单层搜索逻辑
    for (let i = startIndex; i < _nums.length; i++) {
      // 去重
      if (i > startIndex && _nums[i] == _nums[i - 1]) {
        continue
      }
      path.push(_nums[i])
      // 递归
      backTracking(_nums, i + 1)
      // 回溯
      path.pop()
    }
  }

  // 排序
  nums = nums.sort()
  backTracking(nums, 0)
  return result
}
