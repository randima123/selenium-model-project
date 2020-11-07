package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By username = By.xpath("//div[@class='header_user_info']//span");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoggedInUsername() {
        return driver.findElement(username).getText();
    }
}
