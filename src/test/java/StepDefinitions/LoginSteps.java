package StepDefinitions;

import PageObjects.SalesForceLoginPage;
import Utilities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    TestContext testContext;
    SalesForceLoginPage salesForceLoginPage;

    public LoginSteps(TestContext context) {
        testContext = context;
        salesForceLoginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Then("Login page is displayed")
    public void loginPageIsDisplayed() {
        Assert.assertTrue(salesForceLoginPage.emailLoginPageIsDisplayed());

        String actualLoginHeaderTitle = salesForceLoginPage.getLoginHeaderTitle();
        Assert.assertEquals("Silakan masuk ke akun Anda", actualLoginHeaderTitle);

        String actualRegisterQuestionText = salesForceLoginPage.getQuestionRegisterText();
        Assert.assertEquals("Belum punya akun Bhinneka? Daftar", actualRegisterQuestionText);
    }

    @When("Input {string} as email, {string} as password, {string} as account type")
    public void inputAsEmailAsPasswordAsAccountType(String email, String password, String account) {
        System.out.println("---" + email);
        System.out.println("---" + password);
        System.out.println("---" + account);
    }

    @When("Input credentials to login without headers")
    public void inputCredentialsToLoginWithoutHeaders(DataTable dataTable) {
        List<String> dataRow = dataTable.row(0);
        String email = dataRow.get(0);

        System.out.println("row index 0 --- " + email);
        salesForceLoginPage.fillEmailData(email);
        salesForceLoginPage.fillPasswordData(email);
        System.out.println("row index 1 --- " + dataRow.get(1));
        System.out.println("row index 2 --- " + dataRow.get(2));
    }

    @When("Input credentials to login with headers table")
    public void inputCredentialsToLoginWithHeadersTable(DataTable dataTable) {
        List<Map<String,String>> dataRow = dataTable.asMaps(String.class,String.class);

        //Use for...loop if you have multiple data table
        for (Map<String, String> dataMap : dataRow) {
            String email = dataMap.get("Email");
            String password = dataMap.get("Password");
            salesForceLoginPage.fillEmailData(email);
            salesForceLoginPage.fillPasswordData(password);
        }
        salesForceLoginPage.clickLoginButton();

    }

    @When("Click selanjutnya button")
    public void clickSelanjutnyaButton() {
        salesForceLoginPage.clickLoginButton();
    }

    @When("Input {string} and {string} to login into app")
    public void inputAndToLoginIntoApp(String email, String pwd) {
        salesForceLoginPage.fillEmailData(email);
        salesForceLoginPage.fillPasswordData(pwd);
        salesForceLoginPage.clickLoginButton();
    }

    @Then("verify error message as {string}")
    public void verifyErrorMessageAs(String errorMsg) {
        Assert.assertTrue(salesForceLoginPage.verifyError(errorMsg));
    }
}
