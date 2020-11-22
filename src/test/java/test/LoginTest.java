package test;

import fragment.LoginFragment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    private LoginFragment loginFragment;

    @BeforeMethod
    public void loginBeforeMethod() {
        loginFragment = new LoginFragment(driver);
    }

    @Test
    public void testValidLogin() {
        loginFragment.login("randima@mailinator.com","abc1234");
        assertEquals(new HomePage(driver).getLoggedInUsername(), "Randima Senanayake",
                "Logged in username invalid \n");
    }

    @Test
    public void testInvalidLogin() {
        loginFragment.login("randima@mailinator.com","abc12");
        assertEquals(driver.getTitle(), "Login - My Store");
    }
}
