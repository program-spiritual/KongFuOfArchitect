package mediator.better;


import mediator.basic.Input;
import mediator.basic.Selection;
import mediator.basic.Text;


import java.awt.*;

public class LandingPageDialog implements Mediator {
    private Button loginButton;
    private Button regButton;
    private Selection selection;
    private Input usernameInput;
    private Input passwordInput;
    private Input repeatedPswdInput;
    private Text hintText;

    @Override
    public void handleEvent(Component component, String event) {
        if (component.equals(loginButton)) {
            String username = usernameInput.text();
            String password = passwordInput.text();
        } else if (component.equals(regButton)) {
            // ...
        } else if (component.equals(selection)) {
            String selectedItem = selection.select();
            if (selectedItem.equals("login")) {
                usernameInput.show();
                passwordInput.show();
                repeatedPswdInput.hide();
                hintText.hide();
            } else if (selectedItem.equals("register")) {
            }
        }
    }

    @Override
    public void setLoginButton(Button loginButton) {

    }
}