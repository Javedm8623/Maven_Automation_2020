package Day12_Selenium;

import Reusable_Library.Reusable_Methods;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Yahoo_boolean {
    WebDriver driver = null;

    @BeforeMethod
    public void openBrowser() throws IOException, BiffException {
        //quit all chrome driver which are open
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito", "start-maximized");
        driver = new ChromeDriver(option);

        //initiate implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }//end of before method annotation

    @Test
    public void usps() throws InterruptedException {
        driver.navigate().to("https://yahoo.com/");
        //click on yahoo sign in
        Reusable_Methods.click(driver,"//*[text()='Sign in']","Sign in");
        //verify that stay signed in checkbox is selected
        Thread.sleep(3000);
        Boolean checkbox = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if( checkbox == true){
            System.out.println("Stay Signed in checkbox is selected");
        } else {
            System.out.println("Stay signed in checkbox is not selected");
        }

        //Verify if create account button is there then click on it
        Boolean createAcc = driver.findElement(By.xpath("//*[@id='createacc']")).isEnabled();
        if( createAcc == true){
            driver.findElement(By.xpath("//*[@id='createacc']")).click();
            System.out.println("Create Account was enable");
        } else {
            System.out.println("Create account is not enabled");
        }

    }//end of after test

    @AfterMethod
    public void closeBrowser() {
        //driver.close

    }//end of after method

}
