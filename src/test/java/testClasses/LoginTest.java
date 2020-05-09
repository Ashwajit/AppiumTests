package testClasses;

import Screens.Screen;
import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import library.ElementLocator;
import library.appiumlibrary.MobileLibrary;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.junit.Assert;
import org.omg.CORBA._IDLTypeStub;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ReporterConfig.Property;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.JavaUtilities;
import utilities.PropertyReader;
import utilities.ScreenshotUtility;

public class LoginTest extends BaseClass {

  private AppiumDriver driver;
  private Logger logger = Logger.getLogger(LoginTest.class);
  private ScreenshotUtility screenshotUtility;
  private Screen screen;
  private MobileLibrary mobileLibrary;
  Properties property = PropertyReader.readProperty(
      System.getProperty("user.dir") + "/src/main/java/locators/android/locators.properties");
  ElementLocator elementLocator;

  @BeforeMethod
  public void init() throws MalformedURLException {
    logger.info("Taken driver");
    this.driver = getDriver();
    mobileLibrary = new MobileLibrary(getDriver());
    //screen = new Screen(getDriver());
    screenshotUtility = new ScreenshotUtility();
    elementLocator = new ElementLocator();
  }


  @Test(priority = 0)
  public void LoginTest01() {

    //String menuBtn =  property.getProperty("menuBtn");
    //String signInBtn = property.getProperty("signInBtn");
    //String googleSignInBtn = property.getProperty("googleSignInBtn");
    //String emailTxtField = property.getProperty("emailTxtField");

    By menuBtn = elementLocator.locateElement(property.getProperty("menuBtn"));
    By signInBtn = elementLocator.locateElement(property.getProperty("signInBtn"));
    By googleSignInBtn = elementLocator.locateElement(property.getProperty("googleSignInBtn"));
    By emailTxtField = elementLocator.locateElement(property.getProperty("emailTxtField"));
    By adv= elementLocator.locateElement(property.getProperty("adv"));


    // for mobile webbrowser - we can use tagname, CSSSelector, linktext, partiallinktext

    // used UiScrollable
    JavaUtilities.sleep(10);
   // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.ebay.mobile:id/ad_advertiser\"))"));

    mobileLibrary.setByWait(adv);
    driver.findElement(adv);


    mobileLibrary.setByWait(menuBtn);
    driver.findElement(menuBtn).click();

    mobileLibrary.setByWait(signInBtn);
    driver.findElement(signInBtn).click();

    //driver.findElement(MobileBy.id("button_google")).click();
   // mobileLibrary.setByWait(googleSignInBtn);


     //driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.ebay.mobile:id/button_google\")")).click();

    //driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.ebay.mobile:id/button_google\")")).click();

      mobileLibrary.setByWait(googleSignInBtn);
      driver.findElement(googleSignInBtn).click();

    logger.info("Clicked in Selling button");

    //driver.findElement(MobileBy.className("android.widget.EditText"));
    mobileLibrary.setByWait(emailTxtField);

    //driver.findElement(MobileBy.AndroidUIAutomator(
      //  "new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.ebay.mobile:id/ad_call_to_action\"))"));
    //new UiScrollable(new UiSelector()).scrollIntoView(text(“Enter your element”))”);

    driver.findElement(MobileBy.AndroidUIAutomator("className(\"android.widget.EditText\")"))
        .sendKeys("Love");
    //driver.findElement(emailTxtField).sendKeys("Love");

    System.out.println();


//  @Test(priority = 1)
//  public void LoginTest02()  {
//    driver.findElement(MobileBy.AccessibilityId("Sign in,double tap to activate")).click();
//    JavaUtilities.sleep(3);
//  }
//
//
//  @Test(priority = 2)
//  public void LoginTest03()  {
//
//    driver.findElement(By.id("button_google")).click();
//    JavaUtilities.sleep(3);
//    logger.info("Clicked in Selling button");
//    JavaUtilities.sleep(8);
//    driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("Love");
//    Assert.assertTrue(false);
//}

  }

}

