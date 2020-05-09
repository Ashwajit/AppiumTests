package utilities;

import java.util.Random;

public class JavaUtilities {

  public static void sleep(int i)  {
    try {
      Thread.sleep(i*1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public static int getRandomNumber(){
    Random random = new Random();
    int num = random.nextInt(1000)+1;
    return num;
  }
}


