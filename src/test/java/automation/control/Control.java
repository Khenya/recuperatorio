package automation.control;

import automation.session.Session;
import automation.session.Session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Control {
    protected By locator;
    protected WebElement control;

    public Control(By locator) {
        this.locator = locator;
    }

    public void getControl() {
        //control = Session1.getInstance().getBrowser().findElement(this.locator);
        control = Session2.getInstance().getBrowser().findElement(this.locator);
    }

    public void click() {
        getControl();
        this.control.click();
    }

    public boolean isControlDisplayed() {
        try{
            getControl();
            return control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
