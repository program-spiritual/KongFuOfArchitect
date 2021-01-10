package mediator.better;

import mediator.basic.Input;
import mediator.basic.Selection;
import org.w3c.dom.Text;

import java.awt.*;

public class UIControl {
    private static final String LOGIN_BTN_ID = "login_btn";
    private static final String REG_BTN_ID = "reg_btn";
    private static final String USERNAME_INPUT_ID = "username_input";
    private static final String PASSWORD_INPUT_ID = "pswd_input";
    private static final String REPEATED_PASSWORD_INPUT_ID = "repeated_pswd_input";
    private static final String HINT_TEXT_ID = "hint_text";
    private static final String SELECTION_ID = "selection";

    public static void main(String[] args) {
        Button loginButton = (Button) findViewById(LOGIN_BTN_ID);
        Button regButton = (Button) findViewById(REG_BTN_ID);
        Input usernameInput = (Input) findViewById(USERNAME_INPUT_ID);
        Input passwordInput = (Input) findViewById(PASSWORD_INPUT_ID);
        Input repeatedPswdInput = (Input) findViewById(REPEATED_PASSWORD_INPUT_ID);
        Text hintText = (Text) findViewById(HINT_TEXT_ID);
        Selection selection = (Selection) findViewById(SELECTION_ID);
        Mediator dialog = new LandingPageDialog();
        dialog.setLoginButton(loginButton);
    }

    private static Object findViewById(String loginBtnId) {
        return null;
    }

}
