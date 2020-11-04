package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public static WebDriver driver;
	public LandingPage(WebDriver driver) {
		//here this.driver which is defined above as public doesn't have life. thats why we r assigning it to baseclass driver
				this.driver = driver;
				PageFactory.initElements(driver,this);
			}
   
	@FindBy (css = "a[href*='sign_in']")
	WebElement signIn;
	@FindBy (xpath = "//ul[@class='nav navbar-nav navbar-right']")
	WebElement navigationBar;
	@FindBy (xpath = "//h2[contains(text(),'Featured Courses')]")
	WebElement featuredCourses;
	
 public WebElement getLogin()
    {
    	return signIn;
    }
  public WebElement getNavigationBar()
  {
  	return navigationBar;
  }
  public WebElement getFeaturedCourses()
  {
  	return featuredCourses;
  }
	
}
