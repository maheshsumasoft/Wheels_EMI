package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    WebDriver driver=null;

    public void preCondition()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Wheels_EMI\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver=driver;
       // SOSteps(driver);
    }


    public void postContion()
    {
        driver.close();
    }
}
