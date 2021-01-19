export default class Solution2 {
  static countBits(num) {
    let bits = new Array(num+1).fill(0)
    for (let i = 1; i <= num; i++) {
      debugger
      bits[i]+=bits[i&(i-1)]+1
    }
    return bits;
  }
}

console.log(Solution2.countBits(3))