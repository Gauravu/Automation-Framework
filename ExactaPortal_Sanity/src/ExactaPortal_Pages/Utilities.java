package ExactaPortal_Pages;

import Utilities.ScreenshotFile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class Utilities {
    ScreenshotFile Screen = new ScreenshotFile();
    WebDriver driver;

    public Utilities(WebDriver driver) {
        this.driver = driver;
    }

    
    @FindBy(xpath = "//a[@data-exacta-tab-text='Import Transactions']")
    WebElement IntefaceImportTransactions;
    //    @FindBy(how = How.XPATH, using = "//a[@title='Import Transactions']")
//    WebElement ImportTransactionsText;
    @FindBy(xpath = "//div[1]/button[@type='button']/span[@class='v-btn__content']")
    WebElement SearchImportTransactions;
    //    @FindBy(how = How.XPATH, using = "//tr[1]//td[text()='Success']")
//    WebElement SuccessImportTransactionsText;
    @FindBy(xpath = "//div[@class='main-menu-nav-icon icon-inventory']")
    WebElement NavigateToInventoryMaintenance;
    @FindBy(xpath = "//a[@data-exacta-menu-title='View All Putaway Orders']")
    WebElement NavigateViewAllPutAwayOrders;
    
    @FindBy(xpath = "//a[@data-exacta-menu-title='View All Pick Orders']")
    WebElement NavigateViewAllPickOrders;
    
    @FindBy(xpath = "//a[@data-exacta-menu-title='View All Cycle Counts']")
    WebElement NavigateViewAllCycleCount;

    @FindBy(xpath = "//i[@role='button']")
    WebElement clickRollbutton;
    @FindBy(xpath = "//td//pre//span[@class='atv']")
    WebElement xmlText;
    @FindBy(xpath = " //*[@id=\"mainMenuItem-3\"]/div/div[1]")
    WebElement clickInBound; 
    @FindBy(xpath = "//*[@id=\"mainMenuItem-2\"]/div/div[1]")
    WebElement clickOutBound;
    

    public void clickIntefaceImportTransactions() {
        IntefaceImportTransactions.click();
    }

    
    public void enterputawayorderinImportTransactions() {
        driver.findElement(By.xpath("//input[@id= 'input-25']")).sendKeys("PutawayProdRyder198");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(360));
    	
    }
    
    public void enterpickorderinImportTransactions() {
    	driver.findElement(By.xpath("//input[@id= 'input-25']")).sendKeys("Pick176");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3600));
    	
    }
    
    public void entercyclecountorderinImportTransactions() {
    	
    	driver.findElement(By.xpath("//input[@id= 'input-25']")).sendKeys("CC-40");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3600));
    }
    public void clickSearchimporttrans() {
    	
        SearchImportTransactions.click();
        driver.findElement(By.cssSelector("div.icon-close[title='Close']"));
    }

     public void VerifyIntefaceImportTransactionsText() {
         String actualStr = ImportTransactionsText.getText();
         Assert.assertEquals(actualStr, "Import Transactions");
     }
    public void clickRollbuttonSymbol() {
        clickRollbutton.click();
    }
    
    public void clickInbound () {
    	clickInBound.click();
    }
    
    public void clickOutBound() {
    	
    	clickOutBound.click();
    }

    public void getXmlText() throws IOException {
        System.out.println(xmlText.getText());
        String actualValue = xmlText.getText().replaceAll("^\"|\"$", "");
      //  Assert.assertEquals(actualVale, prod_name);
        System.out.println(" PutAway Order imported successfully in import transactions utility");
        ScreenshotFile.captureScreenshot("Verified PutAwayOrder is imported successfully in Import transactions utility");
    }
//    public void VerifySearchIntefaceImportTransactionsText() throws IOException {
//        String actualStr = SuccessImportTransactionsText.getText();
//        Assert.assertEquals(actualStr, "Success");
//        System.out.println("Verified Product imported successfully in import transactions");
//
//    }

    public void clickInventoryMaintenance() {
        NavigateToInventoryMaintenance.click();
    }

  //  public void clickViewAllPutAwayOrders() {
     //   NavigateViewAllPutAwayOrders.click();
  //  }
    
    public void clickViewAllPickOrders() {
    	NavigateViewAllPickOrders.click();
    }
    
    public void clickViewAllCycleCountOrders () {
    	
    	NavigateViewAllCycleCount.click();
    }
    
    public void enterPutAwayOrderNameinViewAllPutAwayOrders() throws InterruptedException {
    	driver.findElement(By.xpath("//input[@name= 'OrderName']")).sendKeys("PutawayProdRyder198");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        
        driver.findElement(By.name("OrderName")).sendKeys(Keys.ENTER);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    	
    }
    
    public void enterPickOrderNameinViewAllPickOrders () throws InterruptedException{
    	driver.findElement(By.xpath("//input[@name= 'OrderName']")).sendKeys("Pick176");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        
        driver.findElement(By.name("OrderName")).sendKeys(Keys.ENTER);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    	
    }
    
    public void enterCycleCountOrderNameinViewAllCycleCounts () throws InterruptedException {
    	driver.findElement(By.xpath("//input[@name= 'OrderName']")).sendKeys("CC-39");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        
        driver.findElement(By.name("OrderName")).sendKeys(Keys.ENTER);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    	
    }
    
    public void verifyPutAwayOrderisdisplayedinViewAllPutawayOrders () throws IOException {
    	
    	if (driver.findElement(By.xpath("//td[@title='Entered']")) != null ) {
        	
    	      ScreenshotFile.captureScreenshot("PutawayImport");
    	        	
    	        	System.out.println("Putaway Order is displayed");	
    	        }
    	        
    	        else  {
    	        	
    	        	System.out.println("Putaway Order is not in Entered state");
    	        }
    	        
    }
    
    public void verifyPickOrderisdisplayedinViewAllPickOrders () throws IOException {
    	
    	if (driver.findElement(By.xpath("//td[@title='Cubed']")) != null ) {
        	
  	      ScreenshotFile.captureScreenshot("PickImport");
  	        	
  	        	System.out.println("Pick Order is displayed");	
  	        }
  	        
  	        else  {
  	        	
  	        	System.out.println("Pick Order is not in Cubed state");
  	        }
    }
    
    
    public void verifyCycleCountOrderisdisplayedinViewAllCycleCountOrders () throws IOException {
    	
    	
    	if (driver.findElement(By.xpath("//td[@title='Entered']")) != null ) {
        	
    	      ScreenshotFile.captureScreenshot("CycleCountImport");
    	        	
    	        	System.out.println("Cycle Count Order is displayed");	
    	        }
    	        
    	        else  {
    	        	
    	        	System.out.println("Cycle Count Order is not in Entered state");
    	        }
    	
    }
    
public void testPutawayImport () throws InterruptedException, IOException {
        
        Thread.sleep(5000);
        
        //Enter the File Copy Utility name in navigation search bar
        
        driver.findElement(By.className("navigation-search-input")).sendKeys("File Copy Utility");
        
        Thread.sleep(5000);
        
        driver.findElement(By.className("navigation-search-input")).sendKeys(Keys.ENTER);
        
        Thread.sleep(5000);
        
        driver.findElement(By.linkText("Putaway Import")).click();
        
        WebElement chooseFile = driver.findElement(By.xpath("//input[@type=\"file\"]"));
        
        File file = new File("C:\\Users\\gudayashankar\\Desktop\\Selenium\\PutawayProdRyder201.csv");
        System.out.println(file.getAbsolutePath());
        
        
        chooseFile.sendKeys(file.getAbsolutePath());
       
        driver.findElement(By.xpath("//input[@value= 'Import Putaway']\r\n"
        		+ "")).click();
        //Explicit Wait
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//input[@value = 'OK']")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(360));
        
        
	}


public void testPickImport () throws InterruptedException, IOException {
	
	driver.findElement(By.className("navigation-search-input")).sendKeys("File Copy Utility");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3600));
	driver.findElement(By.className("navigation-search-input")).sendKeys(Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3600));
	driver.findElement(By.linkText("Pick Import")).click();
	WebElement chooseFile1 = driver.findElement(By.xpath("//input[@type=\"file\"]"));
    File file = new File("C:\\Users\\gudayashankar\\Desktop\\Selenium\\Pick177.csv");
    System.out.println(file.getAbsolutePath());
    
    
    chooseFile1.sendKeys(file.getAbsolutePath());
    
    driver.findElement(By.xpath("//input[@value= 'Import Pick']\r\n"
    		+ "")).click();
    //Explicit Wait
    Thread.sleep(5000);
    
    driver.findElement(By.xpath("//input[@value = 'OK']")).click();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(360));
}


public void testCycleCountImport () throws InterruptedException, IOException {
	
	driver.findElement(By.className("navigation-search-input")).sendKeys("File Copy Utility");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3600));
	driver.findElement(By.className("navigation-search-input")).sendKeys(Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3600));
	driver.findElement(By.linkText("Cycle Count Import")).click();
	WebElement chooseFile2 = driver.findElement(By.xpath("//input[@type=\"file\"]"));
    File file = new File("C:\\Selenium\\Excel\\TestData.csv");
    System.out.println(file.getAbsolutePath());
    
    
    chooseFile2.sendKeys(file.getAbsolutePath());
    
    driver.findElement(By.xpath("//input[@value= 'Import Cycle Count']\r\n"
    		+ "")).click();
    //Explicit Wait
    Thread.sleep(5000);
    
    driver.findElement(By.xpath("//input[@value = 'OK']")).click();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(360));
}


}


