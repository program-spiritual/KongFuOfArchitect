class BridgeTest {
    public static void main(String[] args) {
        DrawAPI redPen = new RedPen();
        Shape circle = new Circle(5, redPen);
        circle.draw();
    }
}
