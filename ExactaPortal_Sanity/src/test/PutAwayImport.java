package test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class PutAwayImport {
	
	
	private static WebDriver driver; 
	
	
	@BeforeMethod
	
	public void setup () {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\gudayashankar\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\gudayashankar\\eclipse-workspace\\chrome-win64\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gudayashankar\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		  ChromeOptions options = new ChromeOptions();
		  driver = new ChromeDriver(options); 
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		
		
	}
	
	@Test (priority=1)
	public void testLogin() throws InterruptedException, IOException {
		
		driver.navigate().to("http://10.200.1.152/Portal/Login");
        driver.findElement(By.id("login-username")).sendKeys("ProgramDefault");
        driver.findElement(By.id("login-password")).sendKeys("BSS1234");
        driver.findElement(By.id("button-container")).click();

        if (driver.findElement(By.id("portalLogo")).isDisplayed()) {
            captureScreenshot("Login");
        }
        
     
     testPutawayImport();
     
     driver.quit();
	}
	
	

   
	@Test (priority=2)
public void testPutawayImport () throws InterruptedException, IOException {
		
		// Get the current window handle (assuming you're starting from the main window)
		
	 //WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(60));
	// WebElement searchInput = webdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("navigation-search-bar")));
	
		   //     Navigate to Utilities and select File Copy Utility
	/*
	 * driver.findElement(By.xpath("//*[@id=\"navigation-search-bar\"]/div/input")).
	 * wait(20);
	 * driver.findElement(By.xpath("//*[@id=\"navigation-search-bar\"]/div/input)"))
	 * .click();
	 */
		
		Thread.sleep(5000);
		//driver.findElement(By.id("navigation-search-bar")).click();
        driver.findElement(By.xpath("//*[@id=\"mainMenuItem-36\"]/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-container-37\"]/li[46]/a")).click();
        
        Thread.sleep(5000);
        
        //Enter the File Copy Utility name in navigation search bar
        
        driver.findElement(By.className("navigation-search-input")).sendKeys("File Copy Utility");
        
        Thread.sleep(5000);
        
        driver.findElement(By.className("navigation-search-input")).sendKeys(Keys.ENTER);
        
        Thread.sleep(5000);
        
        driver.findElement(By.linkText("Putaway Import")).click();
        
        WebElement chooseFile = driver.findElement(By.xpath("//input[@type=\"file\"]"));
        
        File file = new File("C:\\Users\\gudayashankar\\Desktop\\Selenium\\PutawayProdRyder196.csv");
        System.out.println(file.getAbsolutePath());
        
        
        chooseFile.sendKeys(file.getAbsolutePath());
       
        driver.findElement(By.xpath("//input[@value= 'Import Putaway']\r\n"
        		+ "")).click();
        //Explicit Wait
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//input[@value = 'OK']")).click();
        
        Thread.sleep(10000);
        
        driver.findElement(By.className("navigation-search-input")).sendKeys("Interface Import Transactions");
        
        driver.findElement(By.className("navigation-search-input")).sendKeys(Keys.ENTER);
        
       
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        Thread.sleep(5000);
        driver.findElement(By.className("v-btn__content")).click();
        //driver.findElement(By.linkText("Search")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(360));
        
        driver.findElement(By.xpath("//input[@id= 'input-25']")).sendKeys("PutawayProdRyder196");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(360));
        
        driver.findElement(By.className("v-btn__content")).click();
        
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div.icon-close[title='Close']"));
        
        driver.findElement(By.className("navigation-search-input")).sendKeys("View All Putaway Orders");
        
        driver.findElement(By.className("navigation-search-input")).sendKeys(Keys.ENTER);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(240));
        
        driver.findElement(By.xpath("//input[@name= 'OrderName']")).sendKeys("PutawayProdRyder196");
        
        Thread.sleep(5000);
        
        driver.findElement(By.name("OrderName")).sendKeys(Keys.ENTER);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        
        if (driver.findElement(By.xpath("//td[@title='Entered']")) != null ) {
        	
      	captureScreenshot("PutawayImport");
        	
        	System.out.println("Putaway Order is displayed");	
        }
        
        else  {
        	
        	System.out.println("Putaway Order is not in Entered state");
        }
        
	}
	
	
 
     /*  @AfterMethod
        public void tearDown(ITestResult result) {
            if (result.getStatus() == ITestResult.FAILURE) {
                try {
					captureScreenshot(result.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            driver.quit();
        } */
       
     @AfterMethod
       
    public void afterClassCleanup() {

           
           driver.quit();
       }
     
     @AfterSuite
     
    public void tearDownSuite () {
    	 
    	if (driver != null) {
             driver.quit();
        }
    }
     

    
 


        // Close the browser
       // driver.quit();
    
	}



	
