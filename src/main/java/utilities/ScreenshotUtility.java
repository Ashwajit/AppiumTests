package utilities;

import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class ScreenshotUtility extends BaseClass {

  private AppiumDriver driver;

  public ScreenshotUtility()
  {
    driver = getDriver();

  }

}
