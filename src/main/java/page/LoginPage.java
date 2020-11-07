package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailTextBox = By.id("email");
    private By passwordTextBox = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        sendKeys(emailTextBox, email);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextBox, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }
}
