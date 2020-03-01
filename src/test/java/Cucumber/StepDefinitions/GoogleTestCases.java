package Cucumber.StepDefinitions;

import Reusable_Library.Reusable_Methods;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class GoogleTestCases {
    //declare webdriver outside since it will
    WebDriver driver;

    @Given("^I navigate to google home$")
    public void navigate () throws IOException, InterruptedException {
        //quit all open chrome browsers
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f /t");
        //wait few seconds
        Thread.sleep(3000);
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //set pre agrs using chromeOPTIONS
        ChromeOptions options = new ChromeOptions();
        //chrome option
        options.addArguments("start-maximized", "incognito");
        //define driver
        driver = new ChromeDriver(options);
        //declare google path
        driver.navigate().to("https://www.google.com");
    }//end of given method

    @When("^I verify the expected title as Google$")
    public void verifyTitle(){
        Reusable_Methods.verifyPageTitle(driver,"Google");
    }//end of first when

    @When("^I type Cars (.*) in google search field$")
    public void typeOnSearch( String Cars){
        Reusable_Methods.type(driver,"//*[@name='q']",Cars,"Search Field");
    }//end of second when

    @And("^I submit or click on google search$")
    public void clickOnSearch(){
        Reusable_Methods.submit(driver, "//*[@name='q']","Search Field");
    }//end of and

    @Then("^I capture and extract the search number$")
    public void getSearchNumber() throws InterruptedException {
        Thread.sleep(2000);
        String message=Reusable_Methods.captureText(driver, "//*[@id='mBMHK' or @id='result-stats']", "Search Result");
        String[] arrayMsg = message.split(" ");
        Reporter.addStepLog("My search number for car is " + arrayMsg[1]);
        System.out.println("My search number for car is " + arrayMsg[1]);
    }//end of then

}
