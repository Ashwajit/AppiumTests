package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

  public static JSONObject jsonFile() {

    String filePath = "/Users/ashwajitthukral/AshwajitThukral/Tools/AshAppiumProjects/AndroidProjects/AppiumServer/src/main/java/utilities/JasonFile.json";
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(filePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = null;
    try {
      jsonObject = (JSONObject) jsonParser.parse(fileReader);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return jsonObject;
  }

  public static String getAvdFromJson() {
    JSONObject json = jsonFile();
    String avdName = json.get("avdName").toString();
    return avdName;
  }
  public static String getAutomationNameFromJson() {
    JSONObject json = jsonFile();
    String automationName = json.get("automationName").toString();
    return automationName;
  }
}