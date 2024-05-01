package Managers;

import PageObjects.SalesForceHomePage;
import PageObjects.SalesForceLoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private SalesForceHomePage salesForceHomePage;
    private SalesForceLoginPage salesForceLoginPage;


    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Short Hand If...Else
    public SalesForceHomePage getHomePage() {
        return (salesForceHomePage == null) ? salesForceHomePage = new SalesForceHomePage(webDriver) : salesForceHomePage;
    }

    //General If...Else
    public SalesForceLoginPage getLoginPage() {

        if (salesForceLoginPage == null) {
            salesForceLoginPage = new SalesForceLoginPage(webDriver);
        }
        return salesForceLoginPage;
    }

}
