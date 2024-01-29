package Utilities;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Base.BaseTest.driver;

public class ScreenshotFile {

	 public static void captureScreenshot(String screenshotName) throws IOException {
         TakesScreenshot ts = (TakesScreenshot) driver;
         File source = ts.getScreenshotAs(OutputType.FILE);

         // Define the destination directory for screenshots
         String screenshotsDir = "C:\\Users\\gudayashankar\\Desktop\\Selenium\\Screens";
         File destinationDir = new File(screenshotsDir);
         if (!destinationDir.exists()) {
             destinationDir.mkdirs();
         }

         //DateTimeFormatter formatter = null;
         
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String timestamp = LocalDateTime.now().format(formatter);

         // Create the screenshot file with a dynamic name
         String screenshotFileName = screenshotName + "_" + timestamp + ".png";
         File screenshotFile = Paths.get(screenshotsDir, screenshotFileName).toFile();

         // Copy the screenshot file to the destination directory
         Files.copy(source, screenshotFile);

         System.out.println("Screenshot captured. Saved at: " + screenshotFile.getAbsolutePath());
     }

    public static void deleteScreenshots() {

        File path = new File("C:\\Users\\gudayashankar\\Desktop\\Selenium\\Screens");
        File[] files = path.listFiles();
        for (File file : files) {
            file.delete();
        }
    }
}
