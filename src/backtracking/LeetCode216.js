/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function (k, n) {
  let result = [],
    path = []
  sum = 0

  const backtracking = function (_k, _n, startIndex) {
    // 终止条件
    if (path.length == _k) {
      if (sum == _n) {
        // 收集结果
        result.push(path.slice())
        return
      }
    }
    // 单层搜索逻辑：剪枝1: 边界条件
    for (let i = startIndex; i <= 9 - (k - path.length) + 1; i++) {
      // 节点处理
      path.push(i)
      sum += i
      // 剪枝2：超出范围
      if (sum > _n) {
        // 回溯
        path.pop()
        sum -= i
        return
      }
      // 递归
      backtracking(_k, _n, i + 1)
      // 回溯
      path.pop()
      sum -= i
    }
  }

  backtracking(k, n, 1);
  return result;
}
