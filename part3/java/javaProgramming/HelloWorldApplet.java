import java.applet.*;
import java.awt.*;

public class HelloWorldApplet extends Applet {
    public void paint (Graphics g) {
        g.drawString ("Hello World", 25, 50);
    }
}
