import {shape} from "./IShape";

export namespace triangle{
  import IShape = shape.IShape;

  export class Triangle implements IShape{
    draw() {
      console.log("Triangle is drawn (external module)");
    }

  }
}
