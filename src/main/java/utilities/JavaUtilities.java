package utilities;

public class JavaUtilities {

  public static void sleep(int i)  {
    try {
      Thread.sleep(i*1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  }


