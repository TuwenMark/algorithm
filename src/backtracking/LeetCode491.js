/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findSubsequences = function (nums) {
  let result = [],
    path = []

  const backtracking = function (_nums, startIndex) {
    // 收集结果
    if (path.length > 1) {
      result.push(path.slice())
      // console.log('result: ' + result)
    }
    // 终止条件
    if (startIndex >= _nums.length) {
      return
    }
    // 树层去重集合
    const set = new Set()
    // 单层处理逻辑
    for (let i = startIndex; i < _nums.length; i++) {
      // 去重
      if (set.has(_nums[i])) {
        continue
      }
      // 递增判断
      if (path.length > 0 && path.at(-1) > _nums[i]) {
        continue
      }
      path.push(_nums[i])
      // console.log('path: ' + path)
      set.add(_nums[i])
      // 递归
      backtracking(_nums, i + 1)
      // 回溯
      path.pop()
    }
  }

  backtracking(nums, 0)
  return result
}

let nums = [4, 6, 7, 7]
findSubsequences(nums)
