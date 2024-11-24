/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  let letterArray = [
    '',
    '',
    'abc',
    'def',
    'ghi',
    'jkl',
    'mno',
    'pqrs',
    'tuv',
    'wxyz',
  ]
  let result = [],
    path = []
  const length = digits.length

  const backtracking = function (_digits, index) {
    // 终止条件
    if (path.length == length) {
      result.push(path.join(''))
      return
    }
    // 单层递归逻辑
    let letterString = letterArray[_digits[index]]
    for (const element of letterString) {
      // 处理节点
      path.push(element)
      // 递归
      backtracking(_digits, index + 1)
      // 回溯
      path.pop()
    }
  }

  if (digits == '') {
    return []
  }
  if (length == 1) {
    return letterArray[digits[0]].split("")
  }
  backtracking(digits, 0)
  return result
}
