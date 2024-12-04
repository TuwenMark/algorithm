/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
  let result = [],
    path = []

  const used = new Array(nums.length).fill(0)

  const backtracking = function (_nums) {
    // 终止条件
    if(path.length == _nums.length) {
      // 收集结果
      result.push(path.slice())
      return
    }
    // 单层搜索逻辑
    for(let i = 0; i < _nums.length; i++) {
      // 去重
      if(used[i] == 1) {
        continue;
      }
      path.push(_nums[i])
      used[i] = 1
      // 递归
      backtracking(_nums)
      // 回溯
      path.pop()
      used[i] = 0
    }
  }

  backtracking(nums)
  return result
}
