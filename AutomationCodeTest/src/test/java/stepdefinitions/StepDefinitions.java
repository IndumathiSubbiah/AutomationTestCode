package stepdefinitions;

import java.io.IOException;
import java.util.List;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddNewTodoAndFilterActions;

public class StepDefinitions {

    AddNewTodoAndFilterActions addTodo = new AddNewTodoAndFilterActions();

    @Given("the Application URL")
    public void the_application_url() throws IOException {
        addTodo.launchApplication();
    }


    //AddTodo ListStep Def
    @Then("the Application should suggest how to add them for first time")
    public void theApplicationShouldSuggestHowToAddThem() {
        Assert.assertEquals("What needs to be done?",addTodo.prompt());
    }

    @And("User has not entered any list item")
    public void userHasNotEnteredAnyListItem() {
        System.out.println("Application suggests with the text '"+addTodo.prompt()+"'");
    }

    @When("User adds {string}")
    public void user_adds(String todoItem) {
        addTodo.itemAdded(todoItem);
    }

    @Then("todo list should show the list as:")
    public void todo_list_should_contain(List<String> expectedItems) {
        Assert.assertTrue(addTodo.verifyList(expectedItems));
    }

    @And("the remaining item count should show {string}")
    public void theRemainingItemCountShouldShow(String remainingItemCountText) {
        Assert.assertEquals(addTodo.numberOfItemsLeftMessage(),remainingItemCountText);
    }

    //App Creds
    @Then("User should see the credits in the footer")
    public void user_should_see_in_the_footer() {
        Assert.assertTrue(addTodo.verifyFooter().contains("Evan You"));
    }
    @Then("the page title should include {string}")
    public void thePageTitleShouldInclude(String appName) {
        Assert.assertTrue(addTodo.footer().contains(appName));
    }


    // Filter
    @When("User filters the list to show {word} tasks")
    public void filtersBy(String filter) {
        addTodo.by(filter);
    }
    @When("User completes {string}")
    public void sheCompletes(String completedTodo) {
        addTodo.itemCalled(completedTodo);
    }

    @Given("User adds a todo list")
    public void userAddsATodoList(List<String> Items) {
        for(int i=0;i<Items.size();i++) {
            addTodo.itemAdded(Items.get(i));
        }
    }

    @Then("User sees a suggestion to edit the item added")
    public void userSeesASuggestionToEditTheItemAdded() {
        addTodo.verifyEditText();
    }

    @And("Double click on {string} and edit the text as {string}")
    public void doubleClickAndEditTheTextAs(String item1, String item2) {
        addTodo.editItem(item1,item2);
    }

    @When("User selects all items")
    public void userSelectsAllItems() {
       addTodo.selectAll();
    }

    @And("User clicks on Clear completed")
    public void userClicksOnClearCompleted() {
        addTodo.clear();
    }

    @Then("todo list items are removed")
    public void todoListItemsAreRemoved() {
        addTodo.listCleared();
    }

    @Then("Close the Application")
    public void closeTheApplication() {
        addTodo.quit();
    }

}
