/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function (candidates, target) {
  let result = [],
    path = [],
    sum = 0,
    temp = 0
  
  const backtracking = function(_candidates, _target, startIndex) {
    // 终止条件
    if (sum > _target) {
      return
    }
    if (sum == target) {
      result.push(path.slice())
      return
    }
    // 单层搜索
    for (let i = startIndex; i < _candidates.length; i++) {
      // 树层去重
      if (i > startIndex && _candidates[i] == _candidates[i - 1]) {
        continue
      }
      path.push(_candidates[i])
      sum += _candidates[i]
      // 递归
      backtracking(_candidates, _target, i + 1)
      // 回溯
      path.pop()
      temp = sum;
      sum -= _candidates[i]
    }
  }

  // 排序
  candidates = candidates.sort()
  backtracking(candidates, target, 0)
  return result
}
