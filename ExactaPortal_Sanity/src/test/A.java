package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class A {
	
	private static WebDriver driver; 

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gudayashankar\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		  ChromeOptions options = new ChromeOptions();
		  driver = new ChromeDriver(options); 
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  driver.navigate().to("http://10.200.1.152/Portal/Login");
	        driver.findElement(By.id("login-username")).sendKeys("ProgramDefault");
	        driver.findElement(By.id("login-password")).sendKeys("BSS1234");
	        driver.findElement(By.id("button-container")).click();

	        if (driver.findElement(By.id("portalLogo")).isDisplayed()) {
	            //captureScreenshot("Login");
	        }
	        
	        //driver.findElement(By.xpath("//*[@id=\"navigation-search-bar\"]/div/input")).wait(20);
	        driver.findElement(By.xpath("//*[@id=\"mainMenuItem-36\"]/div/div[1]")).click();
	        driver.findElement(By.xpath("//*[@id=\"menu-item-container-37\"]/li[46]/a")).click();


	}//*[@id="mainMenuItem-36"]/div/div[1]

}
