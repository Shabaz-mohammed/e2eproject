package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	public LoginPage(WebDriver driver) {
		//here this.driver which is defined above as public doesn't have life. thats why we r assigning it to baseclass driver
				this.driver = driver;
				PageFactory.initElements(driver,this);
			}
	
	@FindBy (id = "user_email")
	WebElement email;
	@FindBy (id = "user_password")
	WebElement password;
	@FindBy (css = "input[value='Log In']")
	WebElement logIn;
	
   public WebElement getEmail()
    {
    	return email;
    }
   public WebElement getPassword()
   {
   	return password;
   }
   public WebElement logIn()
   {
   	return logIn;
   }
	
}
