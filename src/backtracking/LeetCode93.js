/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function (s) {
  let result = [],
    segment = ''

  const backTracking = function (_s, pointSum, startIndex) {
    // 终止条件
    if (pointSum == 3) {
      // 注意句号在末尾
      if(startIndex < _s.length && isValid(_s.slice(startIndex))) {
        console.log(_s)
        result.push(_s)
      }
      return
    }
    // 单层搜索逻辑
    for (let i = startIndex; i < _s.length; i++) {
      // IP段是否合法
      segment = _s.slice(startIndex, i + 1)
      if(!isValid(segment)) {
        return
      }
      // 添加句点
      _s = _s.slice(0, i + 1) + '.' + _s.slice(i + 1)
      pointSum++
      // 递归
      backTracking(_s, pointSum, i + 2)
      //回溯
      _s = _s.replace(new RegExp(`(.{${i+1}}).`), '$1')
      pointSum--
    }
  }

  // 是否合法IP段
  const isValid = function(_s) {
    // 长度小于3
    if(_s.length > 3) {
      return false
    }
    // 长度大于1不能有前导0
    if(_s.length > 1 && _s[0] == '0') {
      return false
    }
    // 数值在0-255之间
    if(Number(_s) > 255) {
      return false
    }
    return true
  }

  backTracking(s, 0, 0)
  return result
}

s = '25525511135'
let result = restoreIpAddresses(s)
console.log(result)