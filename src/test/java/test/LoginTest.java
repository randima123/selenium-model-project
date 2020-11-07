package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void loginBeforeMethod() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.login("randima@mailinator.com","abc123");
        Assert.assertEquals(new HomePage(driver).getLoggedInUsername(), "Randima Senanayake",
                "Logged in username invalid \n");
    }

    @Test
    public void testInvalidLogin() {
        loginPage.login("randima@mailinator.com","abc12");
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
    }
}
