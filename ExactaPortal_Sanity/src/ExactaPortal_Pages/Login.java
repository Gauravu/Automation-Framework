package ExactaPortal_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	    WebDriver driver;

	    public Login(WebDriver driver) {
	        this.driver = driver;
	    }

	    @FindBy(xpath = "//*[@id=\"login-username\"]")
	    WebElement UsernameTextbox;
	    @FindBy(xpath = "//*[@id=\"login-password\"]")
	    WebElement PasswordTextbox;
	    @FindBy(xpath = "//*[@id=\"button-container\"]")
	    WebElement Loginbutton;
//	    @FindBy(xpath = "//a[@id=\"mainMenuItem-36\"]")
//	    WebElement ClickUtilities;

	    // @FindBy(how = How.XPATH, using = "//*[@id=\"login-form-container\"]/div[2]/div[2]")
	    //  WebElement UsernameErr
	    public void setUsername(String Username) {
	        UsernameTextbox.sendKeys(Username);
	    }
	    public void setPassword(String Password) {
	        PasswordTextbox.sendKeys(Password);
	    }
	    public void clickLoginButton() {
	        Loginbutton.click();
	    }

	}

