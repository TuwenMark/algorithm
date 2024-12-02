/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function (s) {
  let result = [],
    path = [],
    subString = ''

  const backTracking = function (_s, startIndex) {
    // 终止条件
    if (startIndex >= _s.length) {
      result.push(path.slice())
      return
    }
    // 单层搜索逻辑
    for (let i = startIndex; i < _s.length; i++) {
      // 是否回文子串
      subString = _s.slice(startIndex, i + 1)
      if (!isPalindrome(subString)) {
        continue
      }
      path.push(subString)
      // 递归
      backTracking(_s, i + 1)
      // 回溯
      path.pop()
    }
  }

  // 判断是否是回文子串
  const isPalindrome = function (s) {
    let left = 0,
      right = s.length - 1
    while (left < right) {
      if (s[left] != s[right]) {
        return false
      }
      left++
      right--
    }
    return true
  }

  backTracking(s, 0)
  return result
}
