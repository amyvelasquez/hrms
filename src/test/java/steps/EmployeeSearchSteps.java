package steps;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
//import sun.security.krb5.Config;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {


    @Given("user logs in with valid admin credentials")
    public void user_logs_in_with_valid_admin_credentials() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
        click(loginPage.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashboardPage dash = new DashboardPage();
        click(dash.pimOption);
        click(dash.employeeListOption);
    }

    @When("user enters valid employee ID")
    public void user_enters_valid_employee_id() {
        EmployeeListPage empList = new EmployeeListPage();
        sendText(empList.idEmployee, "15518");
    }

    @When("user enters valid employee name")
    public void userEntersValidEmployeeFirstLastName() {
        EmployeeListPage empList = new EmployeeListPage();
        sendText(empList.employeeNameField, "sofiia");
    }

    @When("clicks on search button")
    public void clicks_on_search_button() {
        EmployeeListPage empList = new EmployeeListPage();
        click(empList.searchButton);
    }


    @Then("employee information is displayed")
    public void employee_information_is_displayed() {
        System.out.println("Employee name is displayed");
        tearDown();
    }

}
