package exercises.filaA;
import automation.todoly.MainPage;
import automation.todoly.MenuSection;
import automation.todoly.LoginSection;
import automation.todoly.SettingsPage;
import automation.session.Session;
import apiTest.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import automation.todoly.DashboardSection;

public class Ejercicio3 {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    SettingsPage settingsPage = new SettingsPage();
    DashboardSection dashboardSection = new DashboardSection();
    
    @AfterEach
    public void close(){
        
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void createUserCreateProject(){

        // 1st - login
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(Configuration.user);
        loginSection.pwdTextBox.setText(Configuration.password);
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

        // 2nd Create Project
        String projectName = "pruebqa81";
        menuSection.addProjectButton.click();
        menuSection.newProjectTextBox.setText(projectName);
        menuSection.addButton.click();

        menuSection.setNewProjectButton(projectName);
        Assertions.assertTrue(menuSection.newProjectButton.isControlDisplayed(), "Error, no se creo el proyecto");

    }
}
