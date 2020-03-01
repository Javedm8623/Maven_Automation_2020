package Google_POM_Testcases;

import Page_objects.Google_POM.Baseclass;
import Reusable_Library.Abstract_Class;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_GoogleSearchNumber extends Abstract_Class {

    @Test
    public void googleSearchResult() throws IOException, InterruptedException {
        driver.navigate().to("https://www.google.com");
        Baseclass.homepage().userSearch("Cars");
        Baseclass.homepage().submitOnSearchField();
        Baseclass.searchresultpage().captureSearchNumber();
    }
}
