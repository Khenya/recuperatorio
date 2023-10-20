package automation.factoryBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firefox implements  IBrowser{
    @Override
    public WebDriver create() {
        // Setting properties on System
        System.setProperty("webdriver.geckodriver.driver","src/test/resources/firefox/geckodriver.exe");
        WebDriver chrome = new ChromeDriver();
        return chrome;
    }
}
