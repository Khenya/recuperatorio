package automation.todoly;

import automation.control.Button;
import automation.control.TextBox;
import org.openqa.selenium.By;
public class DashboardSection {
    
    public TextBox addItemTextBox = new TextBox(By.id("NewItemContentInput"));
    public Button addItemButton = new Button(By.id("NewItemAddButton"));
    public TextBox itemContentTextBox;
    public TextBox itemUpdateTextBox = new TextBox(By.xpath("//textarea[@id=\"ItemEditTextbox\"]"));
    public Button itemContentButton;

    public void setItemContent(String path) {
        this.itemContentTextBox = new TextBox(By.xpath("//div[@class=\"ItemContentDiv\"][text()=\""+ path +"\"]"));
        this.itemContentButton = new Button(By.xpath("//div[@class=\"ItemContentDiv\"][text()=\""+ path +"\"]"));
    }

    public void setItemContentUpdated(String newItemName) {
        this.itemContentTextBox = new TextBox(By.xpath("//div[@class=\"ItemContentDiv\"][text()=\""+ newItemName +"\"]"));
        this.itemContentButton = new Button(By.xpath("//div[@class=\"ItemContentDiv\"][text()=\""+ newItemName +"\"]"));
    }
}
