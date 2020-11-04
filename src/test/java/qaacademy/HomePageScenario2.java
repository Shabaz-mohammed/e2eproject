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
public class HomePageScenario2 extends Base {
	   public static Logger log = LogManager.getLogger(Base.class.getName());

	public LandingPage lp;
	public LoginPage lgnp;
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Navigating to HomePage to test Scenario2");
		log.error("if test fails then its error in sc2");

	  /*  //Thread.sleep(15000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		}*/}
	
	@Test
	public void basePageNavigationSc2M1(){
		lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Successfully Validated Navigation bar as part of Scenario 2");
		log.error("if condition fails then test fails then its error");
}
	
	@Test(dataProvider ="getDataSc2")
	public void basePageNavigationSc2M2(String emailId, String passwords, String typeOfUser) throws IOException{
	//	driver.get(prop.getProperty("url"));
		lp = new LandingPage(driver);
		lgnp = new LoginPage(driver);
		lp.getLogin().click();
		log.debug("Clicked on log-in button as part of Scenario 2");
		lgnp.getEmail().sendKeys(emailId);
		lgnp.getPassword().sendKeys(passwords);
		lgnp.logIn().click();
		System.out.println(typeOfUser);
	}
	
	@AfterTest
	public void close(){
		driver.close();
		log.debug("Closing the browser after testing Scenario2");
        driver = null;
	}
    @DataProvider
    public Object[][] getDataSc2(){
    	Object[][] data = new Object[1][3];
    	data[0][0] = "farooqmughal@gmail.com";
    //	data[0][1] = "password";
    	data[0][2] = "restrictedUserFrq";
    	 return data;
    } 	}
	
	

