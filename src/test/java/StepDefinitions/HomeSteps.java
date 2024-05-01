package StepDefinitions;

import PageObjects.SalesForceHomePage;
import Utilities.TestContext;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeSteps {

    SalesForceHomePage salesForceHomePage;
    TestContext testContext;
    private String AccountName;

    public HomeSteps(TestContext context) {
        testContext = context;
        salesForceHomePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("Home page without authorizations")
    public void homePageWithoutAuthorizations() {
        Assert.assertTrue(salesForceHomePage.defaultHomePageIsDisplayed());
    }

    @Given("Login form in login page")
    public void goToLoginPage() {
        Assert.assertTrue(salesForceHomePage.defaultHomePageIsDisplayed());
    }

    @Then("This is for invalid locators")
    public void thisIsForInvalidLocators() {
        salesForceHomePage.getInvalidLocators();
    }

    @Given("Home page is displayed")
    public void homePageIsDisplayed() {
        Assert.assertTrue(salesForceHomePage.defaultHomePageLoaded());
    }

    @And("Click on accounts menu from home page")
    public void clickOnAccountsMenuFromHomePage() throws InterruptedException {
        Assert.assertTrue(salesForceHomePage.clickAccountsMenu(testContext));
    }

    @Then("Click on new button to create new account")
    public void clickOnNewButtonToCreateNewAccount() {
        Assert.assertTrue(salesForceHomePage.clickNewAccounts());
    }

    @And("User will enter account name as {string}")
    public void userWillEnterAccountNameAs(String accName) throws InterruptedException {
        if(accName.length()==0){
            accName = new Faker().name().username();
            AccountName = accName;
        }
        Assert.assertTrue(salesForceHomePage.enterAccName(testContext,accName));
    }

    @Then("Click on save button")
    public void clickOnSaveButton() throws InterruptedException {
        Assert.assertTrue(salesForceHomePage.clickSaveBtn(testContext));
//        Thread.sleep(5000);
    }

    @Then("verify {string} in account listing page")
    public void verifyInAccountListingPage(String accName) {
        if(accName.length()==0)
            accName = AccountName;
        Assert.assertTrue(salesForceHomePage.verifyAccNameOnAccountListingPage(testContext,accName));
    }


    @And("click on {string} account")
    public void clickOnAccount(String accName) {
        if(accName.length()==0)
            accName = AccountName;
        Assert.assertTrue(salesForceHomePage.clickOnExistingAcc(testContext,accName));
    }

    @And("click on modify account name")
    public void clickOnModifyAccountName() {
        Assert.assertTrue(salesForceHomePage.clickOnAccModifyBtn(testContext));
    }

    @And("user will update account name as {string}")
    public void userWillUpdateAccountNameAs(String accName) throws InterruptedException {
        if(accName.length()==0){
            AccountName = AccountName+"Modified";
            accName = AccountName;
        }
        Assert.assertTrue(salesForceHomePage.enterAccName(testContext,accName));
    }

    @Then("verify update {string} in account listing page")
    public void verifyUpdateInAccountListingPage(String accName) {
        if(accName.length()==0)
            accName = AccountName;
        System.out.println("YHG ="+ accName);
        Assert.assertTrue(salesForceHomePage.verifyAccNameOnAccountListingPage(testContext,accName));
    }

    @And("input account {string} for search")
    public void inputAccountForSearch(String accName) {
        Assert.assertTrue(salesForceHomePage.inputSearchString(accName));
    }
}
