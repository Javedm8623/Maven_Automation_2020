package Cucumber.Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //new changeccccc
        features = {"src/test/java/Cucumber/Feature/GoogleTest1.feature"},
        glue = {"Cucumber.StepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
)//end of your feature path

public class executableClass {
    //class is empty
}
