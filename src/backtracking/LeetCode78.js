/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
  let result = [],
    path = []

  const backTracking = function (_nums, startIndex) {
    // 收集结果
    result.push(path.slice())
    // 终止条件
    if (startIndex >= _nums.length) {
      return
    }
    // 单层搜索逻辑
    for (let i = startIndex; i < _nums.length; i++) {
      path.push(_nums[i])
      // 递归
      backTracking(_nums, i + 1)
      // 回溯
      path.pop()
    }
  }

  backTracking(nums, 0)
  return result
}
