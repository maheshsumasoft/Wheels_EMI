package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D://Selenium_BDD_WheelsEMI_Project//Wheels_EMI//Feature//a_SOLogin.feature",
                    "D://Selenium_BDD_WheelsEMI_Project//Wheels_EMI//Feature//b_CPALogin.feature"},
        glue = {"StepDefination"}
)

public class TestRunner {
}
