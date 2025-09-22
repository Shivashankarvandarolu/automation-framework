import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

package stepImplementations;


public class login_step {

@Given("the user is on the login page")
public void the_user_is_on_the_login_page() {
    // Code to navigate to the login page
}

@When("the user leaves the username and password fields empty")
public void the_user_leaves_fields_empty() {
    // Code to leave username and password fields empty
}

@When("clicks the login button")
public void clicks_the_login_button() {
    // Code to click the login button
}

@Then("a validation message should be displayed")
public void a_validation_message_should_be_displayed() {
    // Code to verify validation message is displayed
}
        

@When("the user enters an invalid username {string} and password {string}")
public void the_user_enters_invalid_credentials(String username, String password) {
// Code to enter invalid username and password
}

@Then("an error message should be displayed")
public void an_error_message_should_be_displayed() {
// Code to verify error message is displayed
}

@Then("the user should be redirected to the dashboard")
public void the_user_should_be_redirected_to_the_dashboard() {
// Code to verify user is redirected to the dashboard
}

}