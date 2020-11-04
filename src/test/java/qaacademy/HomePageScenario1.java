package qaacademy;
/*import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;*/
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class HomePageScenario1 extends Base {
   public static Logger log = LogManager.getLogger(Base.class.getName());
	public LandingPage lp;
	public LoginPage lgnp;
	
	
	@BeforeTest
	public void initialize() throws IOException{
		log.info("Driver is initialized1 in sc1");
driver = initializeDriver();
		driver.manage().window().maximize();
  	driver.get(prop.getProperty("url"));
	log.info("Driver is initialized2 in sc1");
	log.info("Navigating to HomePage");

		/*Thread.sleep(11000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);*/
		}
	
	@Test(priority=0)
	public void basePageNavigationSc1M1(){
		lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Successfully Validated Navigation bar");
		}
	@Test(priority=1)
	public void basePageNavigationSc1M2(){
//		lp = new LandingPage(driver); //if it is initialize in one method no need to initilize in other methods
Assert.assertEquals(lp.getFeaturedCourses().getText(), "FEATURED COURSES");	
log.info("Successfully Validated Featured Courses");
log.error("if test fails then its error");


	}
	
	@Test(priority=2, dataProvider ="getDataSc1")
	public void basePageNavigationSc1M3(String emailId, String passwords, String typeOfUser) throws IOException{
		driver.get(prop.getProperty("url")); // in which testcase we are using data we have to again define driver get url
	//	lp = new LandingPage(driver);
		lgnp = new LoginPage(driver);
		lp.getLogin().click();
		log.debug("Clicked on log-in button");
		lgnp.getEmail().sendKeys(emailId);
		lgnp.getPassword().sendKeys(passwords);
		log.debug("Successfully Entered both email and password");
        lgnp.logIn().click();
        log.debug("Clicked on sign-in button");
		System.out.println(typeOfUser);
	}
/*	@AfterClass
	public void close(){
		driver.close();
		driver = null;
	}*/
@AfterTest
	public void close(){
		driver.close();
		log.debug("Closing the browser after testing Scenario1");
		driver = null;
	}
    @DataProvider
    public Object[][] getDataSc1(){
    	Object[][] data = new Object[4][3];
    	data[0][0] = "masiullah@gmail.com";
    	data[0][1] = "password";
    	data[0][2] = "restrictedUser1";
    	
        data[1][0] = "maseiullah.n@gmail.com";
    	data[1][1] = "Career@b1";
    	data[1][2] = "restrictedUser2";
    	
    	 data[2][0] = "maseeullahh.n@gmail.com";
     	data[2][1] = "Career@b1";
     	data[2][2] = "restrictedUser3";
     	
     	data[3][0] = "maseeullah.n@gmail.com";
     	data[3][1] = "Career@b1";
     	data[3][2] = "unRestrictedUser";
     	
     	return data;
    } 	}
	
	

