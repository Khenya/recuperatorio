package automation.todoly;

import automation.control.Button;
import automation.control.TextBox;
import org.openqa.selenium.By;

public class SettingsSection {
    public TextBox fullNameBox = new TextBox(By.id("FullNameInput"));
    public Button confirmationButton = new Button(By.xpath("//span[@class='ui-button-text' and text()='Ok']"));
}
