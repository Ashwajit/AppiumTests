package base;

import constants.Constants;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

  private AndroidDriver driver;
  static Logger logger = Logger.getLogger(BaseClass.class);


  @BeforeMethod
  public void baseSetUp() throws MalformedURLException {
    Constants cont = new Constants();
    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "random");
    logger.info("Device name is set as Random");
    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "R");
    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
    //cap.setCapability(MobileCapabilityType.APP, Constants.slash+"Users"+ Constants.slash+"ashwajitthukral"+ Constants.slash+"AshwajitThukral"+ Constants.slash+"Tools"+ Constants.slash+"Ash AppiumProjects"+ Constants.slash+"AndroidProjects"+ Constants.slash+"AppiumServer"+ Constants.slash+"data"+ Constants.slash+"ebay.apk");
    cap.setCapability(MobileCapabilityType.APP, cont.slash+"Users"+ cont.slash+"ashwajitthukral"+ cont.slash+"AshwajitThukral"+ cont.slash+"Tools"+ cont.slash+"Ash AppiumProjects"+ cont.slash+"AndroidProjects"+ cont.slash+"AppiumServer"+ cont.slash+"data"+ cont.slash+"ebay.apk");
    cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ebay.mobile");
    cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activities.MainActivity");


    // Below capabilities are for invoking mobile website
    // cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    // cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"/Users/ashwajitthukral/AshwajitThukral/Tools/Ash AppiumProjects/AndroidProjects/AppiumServer/Mobile browser drivers/chromedriver");

    //Below capabilities already  set thru AppiumServiceBuilder
    // cap.setCapability(MobileCapabilityType.UDID,"emulator-5554");
    // cap.setCapability(MobileCapabilityType.FULL_RESET,false);
    // cap.setCapability(MobileCapabilityType.NO_RESET,true);

    driver = new AndroidDriver(new URL(Server.getServerUrl()), cap);
    System.out.println(driver.getSessionId());

    // driver.get("https://www.ebay.com");
    // System.out.println(driver.getTitle());

  }

  public AndroidDriver getDriver()
  {
    return driver;
  }

  @AfterMethod
  public void stopServer()
  {
    Server.stopServer();
    logger.info("Appium Server Stopped Successfully");

  }


}
