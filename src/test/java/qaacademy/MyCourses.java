package qaacademy;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.MyCoursesPObj;
import resources.Base;
public class MyCourses extends Base {
	 public MyCoursesPObj mc;
	/*@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.manage().window().maximize();
	//	driver.get(prop.getProperty("url"));
		driver.get("https://courses.rahulshettyacademy.com/courses/enrolled");
		}*/
	
	@Test(dependsOnMethods ={"basePageNavigation3"})
	public void myCourses(){
		mc = new MyCoursesPObj(driver);
		mc.myCourseTitlePO().click();
	}
	@Test(dependsOnMethods ={"basePageNavigation3"})
	public void myCourseTitle(){
		mc = new MyCoursesPObj(driver);
		System.out.println(mc.myCourseTitlePO().getText());
		System.out.println(mc.myCourseCompletionPO().getText());
		Assert.assertEquals(mc.myCourseTitlePO().getText(), "Core java for Automation Testers + Interview Programs");		
	}
	@Test(dependsOnMethods ={"basePageNavigation3"})
	public void myCourseCompletion(){
		mc = new MyCoursesPObj(driver);
		System.out.println(mc.myCourseCompletionPO().getText());
	}
	@Test(dependsOnMethods ={"basePageNavigation3"})
	public void myCourseContinue(){
		mc = new MyCoursesPObj(driver);
		System.out.println("Clicking on my Course to continue");
		mc.myCourseTitlePO().click();
	}
	
	@AfterTest
	public void close(){
		driver.close();
		driver=null;
	}
}