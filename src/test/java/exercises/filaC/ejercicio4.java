package exercises.filaC;
import automation.todoly.MainPage;
import automation.todoly.MenuSection;
import automation.todoly.LoginSection;
import automation.todoly.SettingsPage;
import automation.session.Session;
import automation.todoly.SignUpSection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.junit.jupiter.api.Assertions;

import automation.todoly.DashboardSection;
public class ejercicio4 {
    
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    SettingsPage settingsPage = new SettingsPage();
    DashboardSection dashboardSection = new DashboardSection();
    SignUpSection signUpSection = new SignUpSection();
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void deleteAccount(){
        String email = "bhjbe@gmail.com";
        String fullNAme = "Brenda";
        String pass = "b32bihb";

        // 1st - Create user
        mainPage.signUpButton.click();
        signUpSection.fullNameTextbox.setText(fullNAme);
        signUpSection.emailTextbox.setText(email);
        signUpSection.passTextbox.setText(pass);
        signUpSection.checkTerms.click();
        signUpSection.signButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

        // 2nd - go to settings
        menuSection.settingsButton.click();
        settingsPage.accountButton.click();
        settingsPage.deleteAccountButton.click();

        // 3rd - Accept Alert
        Alert alert = Session.getInstance().getBrowser().switchTo().alert();
        alert.accept();

        // 4th Try to enter
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(email);
        loginSection.pwdTextBox.setText(pass);
        loginSection.loginButton.click();

        Assertions.assertTrue(loginSection.loginButton.isControlDisplayed(), "Error! Sigue existiendo el usuario");
    }
}
