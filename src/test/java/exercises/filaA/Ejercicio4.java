package exercises.filaA;
import automation.todoist.LoginPage;
import automation.todoist.MenuSection;
import automation.todoist.TaskSection;
import automation.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Ejercicio4 {
    LoginPage loginPage = new LoginPage();
    MenuSection menuSection = new MenuSection();
    TaskSection taskSection = new TaskSection();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void addTask()  {

        // 1st - Login
        loginPage.emailTextBox.setText("vugvefu@gmail.com");
        loginPage.pwdTextBox.setText("vugvefu123");
        loginPage.loginButton.click();

        // 2nd - Create task
        String task = "tarea1";
        menuSection.addTaskButton.click();
        taskSection.taskNameTextBox.click();
        taskSection.taskNameTextBox.setText(task);
        taskSection.sendButton.click();
        menuSection.setTaskName(task);

        menuSection.inboxButton.click();

        Assertions.assertTrue(menuSection.taskName.isControlDisplayed(), "ERROR la tarea no existe!");

    }

}
