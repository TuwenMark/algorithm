/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
  let result = [],
  path = [],
  sum = 0

  const backtracking = function(_candidates, _target, startIndex) {
    // 终止条件
    if (sum > target) return
    if (sum == target) {
      result.push(path.slice())
    }
    // 单层递归逻辑
    for (let i = startIndex; i < _candidates.length; i++) {
      // 处理节点
      path.push(_candidates[i])
      sum += _candidates[i]
      // 递归
      backtracking(_candidates, _target, i)
      // 回溯
      path.pop()
      sum -= _candidates[i]
    }
  }

  backtracking(candidates, target, 0)
  return result;
}
