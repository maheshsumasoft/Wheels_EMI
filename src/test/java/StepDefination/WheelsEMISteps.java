package StepDefination;

import Utilities.ExcelUtilites;
import Utilities.propertiesFileReader;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WheelsEMISteps extends BaseClass {

    ExcelUtilites exl = new ExcelUtilites();
    Select objDropdown;
    propertiesFileReader pro=new propertiesFileReader();


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

    @When("I Login as SO user")
    public void i_login_as_SO_user() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String SOurl = pro.readPropertiesData("SO_Url");
        String UserName=pro.readPropertiesData("SO_UserName");
        String Pssword=pro.readPropertiesData("SO_Password");
        driver.get(SOurl);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UserName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pssword);
        driver.findElement(By.xpath("//button[@id='Sign_In']")).click();
    }

    @When("I open CPA user home page")
    public void i_open_CPA_user_home_page() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String SOurl = pro.readPropertiesData("CPA_Url");
        String UserName=pro.readPropertiesData("SO_UserName");
        String Pssword=pro.readPropertiesData("SO_Password");
        driver.get(SOurl);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UserName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pssword);
    }

    @Then("I verify that the logo present on screen")
    public void i_verify_that_the_logo_present_on_screen() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean status = driver.findElement(By.xpath("//img[@class='logo-img']")).isDisplayed();
        Assert.assertEquals(true, status);
    }



    @When("^I navigate to header \"([^\"]*)\"$")
    public void i_navigate_to_header(String str) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'" + str + "')]")).click();
        Thread.sleep(5000);
    }

    @When("^I click on option \"([^\"]*)\"$")
    public void i_click_on_option(String str) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'" + str + "')]")).click();
        Thread.sleep(3000);
    }

    @Then("I verify New TW page on screen")
    public void i_verify_new_tw_page_on_screen() {
        boolean status = driver.findElement(By.xpath("//b[contains(text(),'New TW')]")).isDisplayed();
        Assert.assertEquals(true, status);
    }

    @When("^I select \"([^\"]*)\" as \"([^\"]*)\"$")
    public void i_select_as(String str1, String str2) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement select = driver.findElement(By.xpath("//select[@placeholder='" + str1 + "']"));
        objDropdown = new Select(select);
        objDropdown.selectByValue(str2);
        Thread.sleep(5000);
    }

    @When("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
    public void i_enter_as(String str1, String str2) throws IOException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String setdata = exl.readExcel("Sheet1", str2);
        driver.findElement(By.xpath("//input[@placeholder='"+str1+"']")).sendKeys(setdata);
    }



}