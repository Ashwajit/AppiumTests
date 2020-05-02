package testClasses;

import base.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import org.openqa.selenium.By.ByClassName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.JavaUtilities;

public class LoginTest extends BaseClass {
  AndroidDriver driver;

  @BeforeMethod
  public void init(){
    driver=getDriver();
  }


  @Test
public void Tests()  {
    JavaUtilities.sleep(2);
    driver.findElement(MobileBy.AccessibilityId("Main navigation, open")).click();
}





}
