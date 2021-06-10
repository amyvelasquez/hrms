package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_click_on_pim_option() {
        DashboardPage dash = new DashboardPage();
        click(dash.pimOption);
    }

    @When("clicks on Add Employee button")
    public void i_click_on_add_employee_button() {
        DashboardPage dash = new DashboardPage();
        click(dash.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, "je");
        sendText(add.middleName, "sc");
        sendText(add.lastName, "sccsa");
    }

    @When("user enters first name {string}, middle name {string}, and last name {string}")
    public void user_enters_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, firstName);
        sendText(add.middleName, middleName);
        sendText(add.lastName, lastName);
    }

    @When("user enters {string}, {string}, and {string} in the application")
    public void user_enters_and_in_the_application(String FirstName, String MiddleName, String LastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, FirstName);
        sendText(add.middleName, MiddleName);
        sendText(add.lastName, LastName);
    }

    @And("user clicks on save button option")
    public void userClicksOnSaveButtonOption() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user adds multiple employees and verifies they're added successfully")
    public void user_adds_multiple_employees_and_verifies_they_re_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();
        for (Map<String, String> employeeName : employeeNames) {
            String firstNameValue = employeeName.get("FirstName");
            String middleNameValue = employeeName.get("MiddleName");
            String lastNameValue = employeeName.get("LastName");
            System.out.println(firstNameValue + " " + middleNameValue + " " + lastNameValue);

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firstName, firstNameValue);
            sendText(addEmployeePage.middleName, middleNameValue);
            sendText(addEmployeePage.lastName, lastNameValue);
            click(addEmployeePage.saveBtn);

            Thread.sleep(5000);
            DashboardPage dash = new DashboardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);
        }
    }

    @When("user adds multiple employees from excel file for {string} sheet and verifies they're added")
    public void user_adds_multiple_employees_from_excel_file_for_sheet_and_verifies_they_re_added(String sheetName) {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        DashboardPage dash = new DashboardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();

        Iterator<Map<String, String>> it = newEmployees.iterator();
        while(it.hasNext()){
            Map<String, String> mapNewEmp = it.next();
            sendText(addEmployeePage.firstName, mapNewEmp.get("FirstName"));
            sendText(addEmployeePage.middleName, mapNewEmp.get("MiddleName"));
            sendText(addEmployeePage.lastName, mapNewEmp.get("LastName"));
            click(addEmployeePage.saveBtn);

            //create assertion
        }
    }

}
