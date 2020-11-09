package page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BasePage {

    public static WebDriver driver;
    private static final String fileSeparator = File.separator;
    private static final String rootDirectory = System.getProperty("user.dir");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void click(By by) {
        waitUntilElementClickable(by);
        driver.findElement(by).click();
    }

    public WebElement getElement(By by) {
        waitUntilElementVisible(by);
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by) {
        waitUntilElementVisible(by);
        return driver.findElements(by);
    }

    public void sendKeys(By by, String text) {
        waitUntilElementVisible(by);
        driver.findElement(by).sendKeys(text);
    }

    public static String takeScreenshot(String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = rootDirectory + fileSeparator + "reports" + fileSeparator +
                "html-report" + fileSeparator + "screenshots" + fileSeparator +
                screenshotName + " - " + timestamp + ".png";
        String relativePath = "screenshots" + fileSeparator + screenshotName + " - " + timestamp + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativePath;
    }
}
