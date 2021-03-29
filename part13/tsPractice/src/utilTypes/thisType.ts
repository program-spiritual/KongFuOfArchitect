type ObjectDescriptor<D, M> = {
  data?: D,
  methods?: M & ThisType<D & M>
}

function makeObject<D,M>(desc:ObjectDescriptor<D,M>):D&M {
  let data:object = desc.data || {}
  let methods:object =desc.methods || {}
  return { ...data, ...methods } as D & M;
}

let thisTypeObj = makeObject({
  data: {x: 0, y: 0},
  methods: {
    moveBy(dx: number, dy: number) {
      this.x += dx; // Strongly typed this
      this.y += dy; // Strongly typed this
    },
  },
})

thisTypeObj.x = 10;
thisTypeObj.y = 20;
thisTypeObj.moveBy(5, 5);
