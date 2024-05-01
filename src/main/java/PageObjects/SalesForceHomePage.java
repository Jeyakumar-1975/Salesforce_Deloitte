package PageObjects;

import Utilities.TestContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesForceHomePage {

    public SalesForceHomePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }
    @FindBy(xpath = "//*[@id='Login']")
    private WebElement loginBtn;

    @FindBy(xpath ="//*[@id='username']")
    private WebElement userName;

    @FindBy(xpath ="//a[@title='Accounts']")
    private WebElement accountsMenu;
    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//li[@class='slds-button slds-button--neutral']")
    private WebElement newAccBtn;

    @FindBy(xpath = "//input[@name='Name']")
    private WebElement accNameInputBox;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveBtn;

    @FindBy(xpath = "//input[@name='Account-search-input']")
    private WebElement searchBtn;

    @FindBy(xpath = "//button[@title='Edit Account Name']")
    private WebElement editAccNameBtn;


    @FindBy(xpath = "//span[contains(text(),'Login')]//parent::button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='theloginform']")
    private WebElement loginForm;


    @FindBy(xpath = "//div[contains(@placeholder,'Cari produk asli')]//div//a")
    private WebElement searchProductLink;

    @FindBy(xpath = "//*[invalid locators]")
    private WebElement invalidLocators;

    public boolean defaultHomePageIsDisplayed() {
        loginForm.isDisplayed();
        loginBtn.isDisplayed();
        userName.isDisplayed();
        password.isDisplayed();
        return true;
    }

    public void clickLoginButton() {
        loginButton.isDisplayed();
        loginButton.isEnabled();
        loginButton.click();
    }

    public void clickCartButton() {
        password.isEnabled();
        password.click();
    }

    public void setSearchInput(String product) {
        userName.isEnabled();
        userName.click();
        userName.sendKeys(product);
    }

    public String getSearchProductLink() {
        searchProductLink.isDisplayed();
        return searchProductLink.getText();
    }

    public void getInvalidLocators() {
        invalidLocators.isDisplayed();
    }


    public boolean clickAccountsMenu(TestContext testContext) throws InterruptedException {
        accountsMenu.isEnabled();
//        Thread.sleep(6000);
        JavascriptExecutor executor = (JavascriptExecutor)testContext.getDriverManager().getDriver();
        executor.executeScript("arguments[0].click();", accountsMenu);
        System.out.println("Check Here "+accountsMenu.getAttribute("title"));
//        accountsMenu.click();
        return true;
    }

    public boolean defaultHomePageLoaded() {
        accountsMenu.isDisplayed();
        return true;
    }

    public boolean clickNewAccounts() {
        newAccBtn.isEnabled();
        System.out.println();
        newAccBtn.click();
        return true;
    }

    public boolean enterAccName(TestContext testContext, String accName) throws InterruptedException {
        accNameInputBox.isEnabled();
        accNameInputBox.clear();
//        accNameInputBox.clear();
        new WebDriverWait(testContext.getDriverManager().getDriver(), 20).until(ExpectedConditions.elementToBeClickable(accNameInputBox)).isDisplayed();
//        Thread.sleep(6000);
//        String js = "arguments[0].setAttribute('value','"+accName+"')";
//        ((JavascriptExecutor) testContext.getDriverManager().getDriver()).executeScript(js, accNameInputBox);
        accNameInputBox.sendKeys(accName);
        return true;
    }

    public boolean clickSaveBtn(TestContext testContext) throws InterruptedException {
        saveBtn.isEnabled();
//        JavascriptExecutor executor = (JavascriptExecutor)testContext.getDriverManager().getDriver();
//        executor.executeScript("arguments[0].click();", saveBtn);
        saveBtn.click();
        Thread.sleep(6000);
        return true;
    }

    public boolean verifyAccNameOnAccountListingPage(TestContext testContext, String accName) {
        String xpath= "//a[text()='*']".replace("*",accName);
        return new WebDriverWait(testContext.getDriverManager().getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed();

    }

    public boolean clickOnExistingAcc(TestContext testContext, String accName) {
        String xpath= "//a[text()='*']".replace("*",accName);
//        new WebDriverWait(testContext.getDriverManager().getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();

        WebElement element = new WebDriverWait(testContext.getDriverManager().getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        ((JavascriptExecutor)testContext.getDriverManager().getDriver()).executeScript("arguments[0].click();", element);
        return true;
    }

    public boolean clickOnAccModifyBtn(TestContext testContext) {
        editAccNameBtn.isEnabled();
        ((JavascriptExecutor)testContext.getDriverManager().getDriver()).executeScript("arguments[0].click();", editAccNameBtn);
//        editAccNameBtn.click();
        return true;
    }

    public boolean inputSearchString(String accName) {
        searchBtn.isEnabled();
        searchBtn.clear();
        searchBtn.sendKeys(accName);
//        searchBtn.click();
        searchBtn.sendKeys(Keys.ENTER);
        return true;
    }
}
