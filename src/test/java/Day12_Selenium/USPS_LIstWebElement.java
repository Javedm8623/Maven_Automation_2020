package Day12_Selenium;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class USPS_LIstWebElement {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrowser() throws IOException, BiffException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito", "start-maximized");
        driver = new ChromeDriver(option);

        //initiate implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }//end of before method annotation

    @Test
    public void usps() {
        driver.navigate().to("https://usps.com/");

        //declare and define the WebDriverWait for explicit wait
        WebDriverWait wait = new WebDriverWait(driver,7);

        //store your fine element using List command to get the group count
        //List<WebElement> linkCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'lang-')]")));
       List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class, 'lang-')]"));
        //print out size to get the count
        System.out.println("My list count is " + linkCount.size());

    }//end of after test

    @AfterMethod
    public void closeBrowser() {
        //driver.close

    }//end of after method


}
