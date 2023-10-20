package automation.todoist;

import org.openqa.selenium.By;

import automation.control.Button;
import automation.control.TextBox;

public class AddProjectSection {
    
public TextBox nametextBox = new TextBox(By.id("edit_project_modal_field_name"));
    public Button addButton = new Button(By.xpath("//button[@type=\"submit\"]"));
}
