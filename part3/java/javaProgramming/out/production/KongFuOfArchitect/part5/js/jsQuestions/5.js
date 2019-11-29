const bird = {
  size: 'small'
}

const mouse = {
  name: 'Mickey',
  small: true
}
// console.log('A:');
// console.log(mouse.bird.size);
console.log('B');
console.log(mouse[bird.size]);
console.log('C');
console.log(mouse[bird["size"]]);
