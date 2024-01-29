package Base;

import ExactaPortal_Pages.Login;
//import Utilities.ReadPropertiesFile;
//import Utilities.Screenshot;
import Utilities.ScreenshotFile;

import org.openqa.selenium.By;
//import Utilities.TextFileGenerator;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    ScreenshotFile Screen = new ScreenshotFile();
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {

        ScreenshotFile.deleteScreenshots();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gudayashankar\\eclipse-workspace\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
		  ChromeOptions options = new ChromeOptions();
		  driver = new ChromeDriver(options); 
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
		  driver.navigate().to("http://10.200.1.152/Portal/Login");
	        driver.findElement(By.id("login-username")).sendKeys("ProgramDefault");
	        driver.findElement(By.id("login-password")).sendKeys("BSS1234");
	        driver.findElement(By.id("button-container")).click();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws SQLException {
        driver.close();
        System.out.println("Closed Browser successfully");

        System.out.println("Teardown successful");
    }
}
