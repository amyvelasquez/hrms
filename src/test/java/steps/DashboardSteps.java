package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("user sees the following tabs on dashboard")
    public void user_sees_the_following_tabs_on_dashboard(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();
        DashboardPage dash = new DashboardPage();
        List<String> actualTabs = new ArrayList<>();
        for (WebElement ele : dash.dashboardTabs){
            actualTabs.add(ele.getText());
        }
        System.out.println(expectedTabs);
        System.out.println(actualTabs);
        Assert.assertTrue(expectedTabs.equals(actualTabs));
    }
}
