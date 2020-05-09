package library.appiumlibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileLibrary {

  AppiumDriver driver;
  public MobileLibrary(AppiumDriver driver)
  {
   this.driver= driver;
  }

  public void setElementWait(MobileElement element){
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(element));
  }

  public void setByWait(By element){
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
  }


}
