package stepdefinitions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testrun.BDDTestScreenshot;


public class Hooks {
	String destination;
	SimpleDateFormat simpleformat = new SimpleDateFormat("d-MMM-YY HH-mm");
	String imagetime="";
	String dir ="";
	Calendar cal = Calendar.getInstance();
	static public String testflag="pass";
	BDDTestScreenshot bts=new BDDTestScreenshot();
	
	@Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
    }	
	
	 
	 
	@After
    public void afterScenario(Scenario scenario){
		 imagetime=simpleformat.format(cal.getTime());
        System.out.println("This will run after the Scenario");
        if(scenario.isFailed())
        {
        	testflag="fail";
        	
        	
        	 scenario.log("failed to add PROD S6 <a href='C:\\java project\\DemoBlazeBDD\\Test case screenshots\\"+imagetime+"'>click here</a>");
        	//bts.takePageScreenshot_onPass(driver, "failed");
            //take screenshot
//            String screenshotName =scenario.getName().replaceAll("", "_");
//            byte[] sourcepath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(sourcepath, "image/png", screenshotName);
        	
        }
        scenario.log("Check screenshots <a href='C:\\java project\\DemoBlazeBDD\\Test case screenshots\\"+imagetime+"'>click here</a>");
    }
}
