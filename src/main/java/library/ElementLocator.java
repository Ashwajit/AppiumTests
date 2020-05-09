package library;

import io.appium.java_client.MobileBy;
import javax.swing.CellEditor;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ElementLocator {

  private Logger logger = Logger.getLogger(ElementLocator.class);

  public By locateElement(String fullLocator) {

    String fullElement[] = fullLocator.split("_",2);
    String locatorType = fullElement[0];
    String element = fullElement[1];
    By finalElement = null;

    if (locatorType.equalsIgnoreCase("AS")) {
      finalElement = MobileBy.AccessibilityId(element);
    } else if (locatorType.equalsIgnoreCase("ID")) {
      finalElement = MobileBy.id(element);
    } else if (locatorType.equalsIgnoreCase("XP")) {
      finalElement = MobileBy.xpath(element);
    } else if (locatorType.equalsIgnoreCase("NM")) {
      finalElement = MobileBy.name(element);
    } else if (locatorType.equalsIgnoreCase("CN")) {
      finalElement = MobileBy.className(element);
    } else if (locatorType.equalsIgnoreCase("IM")) {
      finalElement = MobileBy.image(element);
    } else if (locatorType.equalsIgnoreCase("PS")) {
      finalElement = MobileBy.iOSNsPredicateString(element);
    } else if (locatorType.equalsIgnoreCase("CC")) {
      finalElement = MobileBy.iOSClassChain(element);

    } else if (locatorType.equalsIgnoreCase("UIA")) {
      finalElement = MobileBy.AndroidUIAutomator(element);
    } else {
      logger.info("Pls recheck the mobile element value");
    }
      return finalElement;
  }

}
