class SolutionV2 {
  static mySqrt(x) {
    let r = x
    while (r * r > x) {
      r = (r + x / r) / 2;
    }
    return r
  }
}