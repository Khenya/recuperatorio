package automation.session;

import automation.factoryBrowsers.FactoryBrowser;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Session2 {
    private static Session2 session;
    private WebDriver browser;
    private Session2(){

        browser = FactoryBrowser.make("firefox").create();
        // Browser needs to ocupate all the screen once initialized
        browser.manage().window().maximize();
        // An implicit time to run tests
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    }

    public static Session2 getInstance(){
        // Create a new instance if it is necessary
        if(session == null){
            session =  new Session2();
        }
        return session;
    }

    // To interact with browser elements
    public WebDriver getBrowser(){
        return browser;
    }

    public void closeSession(){
        // Erase session from memory to start another
        browser.quit();
        session = null;
    }
}
