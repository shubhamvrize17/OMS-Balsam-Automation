package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotUtils {

    public static void captureAndSaveScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Check if the driver supports taking screenshots
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

                // Capture screenshot as bytes
                byte[] screenshotBytes = screenshotDriver.getScreenshotAs(OutputType.BYTES);

                // Embed screenshot into Allure report
                Allure.addAttachment(screenshotName, new ByteArrayInputStream(screenshotBytes));
            } else {
                throw new ScreenshotCaptureException("Screenshot capture is not supported for this driver.");
            }
        } catch (Exception e) {
            throw new ScreenshotCaptureException("Failed to capture screenshot: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("serial")
    public static class ScreenshotCaptureException extends RuntimeException {
        public ScreenshotCaptureException(String message) {
            super(message);
        }
    }
}
