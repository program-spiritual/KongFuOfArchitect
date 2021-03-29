import {shape} from "./IShape";
import {circle} from "./Circle";
import {triangle} from "./Triangle";

function drawAllShapes(shapeToDraw: shape.IShape) {
  shapeToDraw.draw();
}
drawAllShapes(new circle.Circle());
drawAllShapes(new triangle.Triangle());
