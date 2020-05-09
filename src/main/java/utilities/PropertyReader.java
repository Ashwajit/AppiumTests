package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
  private static  FileInputStream fileInputStream;
  private static Properties properties;
  public static Properties readProperty(String filePath){
    try {
      fileInputStream = new FileInputStream(filePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    properties = new Properties();
    try {
      properties.load(fileInputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties;
  }

}
