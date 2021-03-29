import {Circle} from "./Circle";
import {Triangle} from "./Triangle";

function drawAllShapes(shape:Drawing.IShape) {
  shape.draw();
}
drawAllShapes(new Circle());
drawAllShapes(new Triangle());
