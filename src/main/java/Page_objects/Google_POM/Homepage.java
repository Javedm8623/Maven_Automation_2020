package Page_objects.Google_POM;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods_Reports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Homepage extends Abstract_Class {
    //declare your logger locally when you use page object
    ExtentTest logger;
    // constructor method is when a child/sub-class having identical
    //name as parent class
    public Homepage (WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }//end of page object constructor

    String searchFieldloc = "//*[@name='q']";

    public Homepage userSearch (String useValue) throws IOException, InterruptedException {
        Reusable_Methods_Reports.type(driver,searchFieldloc,logger,useValue,"Search Field");
        return new Homepage(driver);
    }//end of userSearch method

    //clicking on submit
    public Homepage submitOnSearchField() throws IOException, InterruptedException {
        Reusable_Methods_Reports.submit(driver,searchFieldloc,logger,"Search Field");
        return new Homepage (driver);
    }//end of submit

}
