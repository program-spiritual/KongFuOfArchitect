export default class Solution {
  constructor() {
  }

  static sqrt(y, flag) {
    if (y === 0 || y === 1) {
      return y
    }
    let l = 1
    let r = y
    let res
    while (l <= r) {
      let mid = (l + r) / 2
      const str = (Math.abs(mid - mid.toFixed(0))).toString().substr(2)
      const len = str.length
      if (mid === y / mid) {
        return mid
      } else if (mid > y / mid) {
        r = mid
        if (len >= flag) {
          res = mid
          break
        }
      } else {
        l = mid
        res = mid
        if (len >= flag) {
          break
        }
      }
    }
    return res
  }

}