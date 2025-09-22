import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

package stepImplementations;


public class login_step {

    private WebDriver driver;
    private Utils utils;
    private loginPage loginPage;

    public login_step() {
        this.driver = new WebDriver();
        this.utils = new Utils(driver);
        this.loginPage = new loginPage(driver);
    }

@Given("the user is on the login page")
public void the_user_is_on_the_login_page() {
    utils.getCurrentUrl().equals("https://demoqa.com/login");
    System.out.println("User is on the login page");
}

@When("the user leaves the username and password fields empty")
public void the_user_leaves_fields_empty() {
    loginpage.getUsernameField().clear();
    loginpage.getPasswordField().clear();   
}

@When("clicks the login button")
public void clicks_the_login_button() {
    loginpage.getLoginButton_click();
}

@Then("a validation message should be displayed")
public void a_validation_message_should_be_displayed() {
    // Code to verify validation message is displayed
}
        

@When("the user enters an invalid username {string} and password {string}")
public void the_user_enters_invalid_credentials(String username, String password) {
    loginpage.getUsernameField().sendKeys(username);
    loginpage.getPasswordField().sendKeys(password);
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