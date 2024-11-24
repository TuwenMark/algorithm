/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
  let result = [],
    path = []
  const backtracking = function (_n, _k, startIndex) {
    // 终止条件
    if (path.length == _k) {
      result.push(path.slice())
      return
    }
    // 单层搜索逻辑
    for (let i = startIndex; i <= _n - (_k - path.length) + 1; i++) {
      // 处理节点
      path.push(i)
      // 递归
      backtracking(_n, _k, i + 1)
      // 回溯
      path.pop()
    }
  }
  backtracking(n, k, 1)
  return result
}
