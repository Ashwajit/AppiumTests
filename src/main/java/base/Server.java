package base;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.io.File;
import javax.sound.sampled.Line.Info;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Server {
static Logger logger= Logger.getLogger(Server.class);


private static AppiumDriverLocalService appiumDriverLocalService;

public static DesiredCapabilities desiredCap()
{
  DesiredCapabilities caps = new DesiredCapabilities();
  //caps.setCapability(MobileCapabilityType.NO_RESET,false);
  //caps.setCapability(MobileCapabilityType.FULL_RESET,true);
  //caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
  logger.info("UDID is set now");
  return caps;
}
public static void startServer(){
  AppiumServiceBuilder appiumServiceBuilder= new AppiumServiceBuilder();
  appiumServiceBuilder.withArgument(GeneralServerFlag.RELAXED_SECURITY,"");
  appiumServiceBuilder.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
  appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,"info");
  appiumServiceBuilder.withLogFile(new File("/Users/ashwajitthukral/AshwajitThukral/Tools/Ash AppiumProjects/AndroidProjects/AppiumServer/loggerLogs/appiumserverlogs.txt"));
  appiumServiceBuilder.usingAnyFreePort();
  appiumServiceBuilder.withIPAddress("0.0.0.0");
  appiumServiceBuilder.withCapabilities(desiredCap());

  appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
  appiumDriverLocalService.start();
}

  public static String getServerUrl(){
  startServer();
  return appiumDriverLocalService.getUrl().toString();
  }


  public static void stopServer()
  {
    appiumDriverLocalService.stop();
  }
}
