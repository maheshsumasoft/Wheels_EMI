package StepDefination;

import Utilities.ExcelUtilites;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WheelsEMISteps extends BaseClass  {

    ExcelUtilites exl=new ExcelUtilites();
    /*--------------Methods----------------------*/

    @Given("I launch chrome browser")
    public void i_lunch_chrome_browser() {
       preCondition();
    }

    @Then("I maximize page")
    public void i_maximize_page() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("I open SO user home page")
    public void i_open_so_user_home_page() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://115.124.101.73:8080/LmsUI/html/Sumasoft/login.html");
    }

    @When("I open CPA user home page")
    public void i_open_CPA_user_home_page() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://115.124.101.73:8080/LmsUI/html/Sumasoft/CPA-login.html");

    }

    @Then("I verify that the logo present on screen")
    public void i_verify_that_the_logo_present_on_screen() {
        boolean status = driver.findElement(By.xpath("//img[@class='logo-img']")).isDisplayed();
        Assert.assertEquals(true, status);
    }

    @When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_and(String username, String password) throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String inpUserName1 = exl.readExcel("Sheet1", username);
        String inpUserPsw1 = exl.readExcel("Sheet1", password);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(inpUserName1);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(inpUserPsw1);
    }

    @When("click on login button")
    public void click_on_login_button() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("start_button")).click();
    }

    @When("click on CPA login button")
    public void click_on_CPA_login_button() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("Sign In")).click();
    }

    @And("close browser")
    public void close_browser() {
        postContion();
    }

}