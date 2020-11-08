package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import page.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotGenerator extends BasePage {

    private static final String fileSeparator = File.separator;
    private static final String rootDirectory = System.getProperty("user.dir");

    public ScreenshotGenerator(WebDriver driver) {
        super(driver);
    }

    public static String takeScreenshot(String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = rootDirectory + fileSeparator + "screenshots" + fileSeparator +
                screenshotName + " - " + timestamp + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
