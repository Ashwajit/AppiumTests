package base;

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.JavaUtilities;
import utilities.JsonReader;

public class BaseClass {

  private AppiumDriver driver;
  private static  Logger logger = Logger.getLogger(BaseClass.class);
  private String platformOs ="android";
 // private String platformOs ="iOS";
  public DesiredCapabilities getAndroidCapabilities(){
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Random");
    logger.info("Device name is set as Random");
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
    //caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, JsonReader.getAutomationNameFromJson());
    //cap.setCapability(AndroidMobileCapabilityType.AVD,"Nexus_6_API_29");
    caps.setCapability(AndroidMobileCapabilityType.AVD, JsonReader.getAvdFromJson());
    caps.setCapability(MobileCapabilityType.APP, Constants.slash+"Users"+ Constants.slash+"ashwajitthukral"+ Constants.slash+"AshwajitThukral"+ Constants.slash+"Tools"+ Constants.slash+"AshAppiumProjects"+ Constants.slash+"AndroidProjects"+ Constants.slash+"AppiumServer"+ Constants.slash+"data"+ Constants.slash+"ebay.apk");
    //caps.setCapability(MobileCapabilityType.APP, "/Users/ashwajitthukral/AshwajitThukral/Tools/Ash AppiumProjects/AndroidProjects/PassingAppiumDriver/data/ebay.apk");
    caps.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_6_API_29");
    caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ebay.mobile");
    caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activities.MainActivity");

    // Below capabilities are for invoking mobile website
    // caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    // caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"/Users/ashwajitthukral/AshwajitThukral/Tools/Ash AppiumProjects/AndroidProjects/AppiumServer/Mobile browser drivers/chromedriver");

    //Below capabilities already  set thru AppiumServiceBuilder
    // caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
    // caps.setCapability(MobileCapabilityType.FULL_RESET,false);
    //caps.setCapability(MobileCapabilityType.NO_RESET,true);

    return caps;
  }

  public DesiredCapabilities getIOSCapabilities(){
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Ash iPhone");
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.4.1");
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
    //caps.setCapability(MobileCapabilityType.APP, "/Users/ashwajitthukral/AshwajitThukral/Tools/AshAppiumProjects/AndroidProjects/PassingAppiumDriver/data/ebay.apk");
    caps.setCapability(MobileCapabilityType.UDID,"0603b00b9e3260be7ff337c054ed519c30922993");
    caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"com.cambly.Cambly");
    caps.setCapability(AndroidMobileCapabilityType.IS_HEADLESS,true);
    //caps.setCapability("derivedDataPath","/Users/ashwajitthukral/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
    caps.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG,true);
    return caps;
  }

  // type == XCUIElementTypeStaticText
  // udid = idevice_id -l
  //bundleId = ideviceinstaller -u <udid> -l
  //ideviceinstaller -u <udid> -i <app path> (Installation of App)

//@Test
//public void iosPredicateStringTest(){
//  //  JavaUtilities.sleep(5);
//  //  driver.findElement(MobileBy.iOSNsPredicateString("value =='Continue with email'")).click();
// // JavaUtilities.sleep(10);
//
//  driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`name BEGINSWITH \"Continue with Apple\"`]")).click();
//  JavaUtilities.sleep(10);}


  @BeforeMethod
  public void setUp(ITestResult iTestResult ) {

    DesiredCapabilities caps = null;
    if(platformOs.equalsIgnoreCase("android")){
      caps = getAndroidCapabilities();
      try {
        driver = new AndroidDriver(new URL(Server.getServerUrl()),caps);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }

    }
    else if(platformOs.equalsIgnoreCase("ios")){
      caps = getIOSCapabilities();
      try {
        driver = new IOSDriver(new URL(Server.getServerUrl()),caps);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
    iTestResult.setAttribute("appiumDriver",driver);
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

  }


  public AppiumDriver getDriver()

  {
    return driver;
  }

  public String takeScreenshot(String screenShotName){
    File src = driver.getScreenshotAs(OutputType.FILE);
    File dest = null;
    try {
      dest = new File(System.getProperty("user.dir")+"/screenshots/"+screenShotName+ JavaUtilities.getRandomNumber()+".jpeg");
      FileUtils.copyFile(src,dest);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dest.getAbsolutePath();
  }

  @AfterMethod
  public void stopServer()
  {
    Server.stopServer();
    logger.info("Appium Server Stopped Successfully");

  }

}
