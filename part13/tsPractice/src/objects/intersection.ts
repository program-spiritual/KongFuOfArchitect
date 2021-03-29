interface Colorful {
  color:string
}

interface Circle {
  radius:number
}

type ColorfulCircle = Colorful & Circle

function draw(circle: Colorful & Circle) {
  console.log(`Color was ${circle.color}`);
  console.log(`Radius was ${circle.radius}`);
}
draw({ color: "blue", radius: 42 });

