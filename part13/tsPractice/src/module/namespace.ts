export namespace Tutorial{
  export function add(x, y) {
    return x + y;
  }
}

// 等价于
var TutorialPoint;
(function (TutorialPoint) {
  function add(x, y) {
    console.log(x + y);
  }
  TutorialPoint.add = add;
})(TutorialPoint || (TutorialPoint = {}));
