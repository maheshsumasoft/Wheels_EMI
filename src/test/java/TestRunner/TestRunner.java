package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D://Selenium_BDD_WheelsEMI_Project//Wheels_EMI//Feature//c_LeadCreation.feature"},
        glue = {"StepDefination"},
        plugin = {"html:target/Cucumber-html-report"}

)

public class TestRunner {
}
