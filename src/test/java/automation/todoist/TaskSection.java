package automation.todoist;

import org.openqa.selenium.By;

import automation.control.Button;
import automation.control.TextBox;

public class TaskSection {
     public TextBox taskNameTextBox = new TextBox(By.xpath("//p[@data-placeholder=\"Nombre de la tarea\"]"));
    public Button sendButton = new Button(By.xpath("//button[@data-testid=\"task-editor-submit-button\"]"));
}