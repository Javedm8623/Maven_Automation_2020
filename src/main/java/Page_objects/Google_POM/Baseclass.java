package Page_objects.Google_POM;

import Reusable_Library.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Baseclass extends Abstract_Class {
    public Baseclass (WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }//end of page of constructor

    ////Object for google home page
    public static Homepage homepage() {
        Homepage homepage = new Homepage(driver);
        return homepage;
    }

    //object for search result page
    public static SearchResultpage searchresultpage() {
        SearchResultpage searchresultpage = new SearchResultpage(driver);
        return searchresultpage;
    }

}
