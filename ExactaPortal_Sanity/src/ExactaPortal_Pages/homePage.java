package ExactaPortal_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
	
	 @FindBy(xpath = "//*[@id=\"mainMenuItem-36\"]")
	    WebElement UtilitiesIcon;
	 
	 public void clickUtilitiesIcon() {
	        UtilitiesIcon.click();
	    }

}
