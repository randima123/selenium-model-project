package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailTextBox = By.id("email");
    private By passwordTextBox = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailTextBox).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignIn();
    }
}
