package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.UUID;

public class Abstract_Class {
    public static ExtentReports reports;
    public static WebDriver driver;
    public static ExtentTest logger;

    @BeforeSuite
    public void openBrowser() {
        //define the path where you  want to save the extent report
        reports = new ExtentReports("src\\main\\java\\Extent_Reports\\Automation.html", true);
        //create a path to chrome
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //set pre agrs using chromeOPTIONS
        ChromeOptions options = new ChromeOptions();
        //chrome option
        options.addArguments("start-maximized", "incognito");
        //define driver
        driver = new ChromeDriver(options);
    }//end of before suite

    //before method will be used to capture the test name and start the report
    @BeforeMethod
    public void getTestName(Method methodName) {
        logger = reports.startTest(methodName.getName());
    }//end of before method

    @AfterMethod
    public void endReport(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void quiteSession(){
        //write all your logs beck to report
        reports.flush();
        //quite driver if your need to
        driver.quit();
    }//end of after suite


}//end of Abstract Class
