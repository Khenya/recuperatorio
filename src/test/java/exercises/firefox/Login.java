package exercises.firefox;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import automation.todoly.LoginSection;
import automation.todoly.MainPage;
import automation.todoly.MenuSection;
import automation.session.Session2;

public class Login {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();

    @AfterEach
    public void close(){
        Session2.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session2.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void updatePassword() {

        //1st - LOGIN
        String email = "vugvefu@gmail.com";
        String pass = "vugvefu123";
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(pass);
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");
    }
}
