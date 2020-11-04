package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursesPObj {
	public static WebDriver driver;
	public MyCoursesPObj(WebDriver driver) {
		//here this.driver which is defined above as public doesn't have life. thats why we r assigning it to baseclass driver
				this.driver = driver;
				PageFactory.initElements(driver,this);
			}

	@FindBy (linkText = "My Courses")
	WebElement myCourses;
	@FindBy (css = "div[title='Core java for Automation Testers + Interview Programs']")
	WebElement myCourseTitle;
	@FindBy (xpath = "//div[@class='small course-progress']")
	WebElement myCourseCompletion;
	
 public  WebElement myCoursesPO()
    {
    	return myCourses;
    }
  public WebElement myCourseTitlePO()
  {
  	return myCourseTitle;
  }
  public WebElement myCourseCompletionPO()
  {
  	return myCourseCompletion;
  }
	
}
