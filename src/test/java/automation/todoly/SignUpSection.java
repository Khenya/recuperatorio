package automation.todoly;

import automation.control.Button;
import automation.control.TextBox;
import automation.control.Option;
import org.openqa.selenium.By;

public class SignUpSection {
public  TextBox fullNameTextbox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public  TextBox emailTextbox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public  TextBox passTextbox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public  Option checkTerms = new Option(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
    public  Button signButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));

}