package mediator.better;

import java.awt.*;

public interface Mediator {
    void handleEvent(Component component, String event);

    void setLoginButton(Button loginButton);
}
