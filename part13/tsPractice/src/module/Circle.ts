import {shape} from "./IShape";

export namespace circle{
  import IShape = shape.IShape;

  export class Circle implements IShape {
    draw() {
      console.log("Cirlce is drawn (external module)");
    }

  }

}
