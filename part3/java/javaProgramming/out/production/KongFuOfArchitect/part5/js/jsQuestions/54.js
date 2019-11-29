(() => {
  let x = (y = 10);
})();

console.log(typeof x);
console.log(typeof y);
