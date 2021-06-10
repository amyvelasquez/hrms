package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on log in button")
    public void user_clicks_on_log_in_button() {
        LoginPage loginPage = new LoginPage();
        click(loginPage.loginBtn);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashboardPage dash = new DashboardPage();
//        Assert.assertTrue(dash.welcomeMessage.isDisplayed());
        String expected = "Welcome Admin";
        String actual = dash.welcomeMessage.getText();
        Assert.assertEquals("Values do not match", expected, actual);
    }

    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, "johnny1234560000");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        DashboardPage dash = new DashboardPage();
        Assert.assertTrue(dash.welcomeMessage.isDisplayed());
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, "johnny1234560000");
        sendText(loginPage.passwordBox, "Syntax1253!!");
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
      LoginPage loginPage = new LoginPage();
      sendText(loginPage.usernameBox, username);
      sendText(loginPage.passwordBox, password);
    }

    @When("{string} is successfully logged in")
    public void is_successfully_logged_in(String firstName) {
        System.out.println("working fine");
    }

    @Then("user sees invalid credentials text on login page")
    public void user_sees_invalid_credentials_text_on_login_page() {
        System.out.println("Invalid credentials message displayed");
    }

    @When("user enters valid username and invalid password and verifies error message")
    public void user_enters_valid_username_and_invalid_password_and_verifies_error_message(DataTable errorData) {
        List<Map<String, String>> employeeNames = errorData.asMaps();
        for (Map<String, String> employeeName : employeeNames) {
            String usernameValue = employeeName.get("username");
            String passwordValue = employeeName.get("password");
            String errorValue = employeeName.get("errorMessage");
            System.out.println(usernameValue + " " + passwordValue + " " + errorValue);

            LoginPage loginPage = new LoginPage();
            sendText(loginPage.usernameBox, usernameValue);
            sendText(loginPage.passwordBox, passwordValue);
            click(loginPage.loginBtn);

            String actual= loginPage.errorMsg.getText();
            Assert.assertEquals("Values do not match", errorValue, actual);
            System.out.println("My test case passed");

        }
    }

    @When("user enter different {string} and {string} and verifies the {string} for all the combinations")
    public void user_enter_different_and_and_verifies_the_for_all_the(String usernameValue, String passwordValue, String error) {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, usernameValue);
        sendText(loginPage.passwordBox, passwordValue);
        click(loginPage.loginBtn);

        String actual = loginPage.errorMsg.getText();

        Assert.assertEquals("Values do not match", error, actual);
    }
}
