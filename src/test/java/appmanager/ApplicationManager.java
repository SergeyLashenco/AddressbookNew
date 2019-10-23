package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   public FirefoxDriver wb;

   private  SessionHelper sessionHelper;
   private  NavigationHelper navigationHelper ;
   private  GroupHelper groupHelper;

   public boolean isAlertPresent(FirefoxDriver driver) {
      try {
         driver.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

   //private boolean acceptNextAlert = true;
  // private StringBuffer verificationErrors = new StringBuffer();

   public void init() {
      File file = new File("./src/drivers/geckodriver");
      System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
      wb = new FirefoxDriver();
      // baseUrl = "https://www.katalon.com/";
      wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      groupHelper = new GroupHelper(wb);
      navigationHelper = new NavigationHelper(wb);
      sessionHelper = new SessionHelper(wb);
      sessionHelper.login("admin", "secret");
   }



   public void stop() {
      wb.quit();
   }


   public GroupHelper getGroupHelper() {
      return groupHelper;
   }

   public NavigationHelper getNavigationHelper() {
      return navigationHelper;
   }
}


/*


    private boolean isElementPresent(By by) {
      try {
         driver.findElement(by);
         return true;
      } catch (NoSuchElementException e) {
         return false;
      }
   }

   private boolean isElementPresent(By by) {
      try {
         driver.findElement(by);
         return true;
      } catch (NoSuchElementException e) {
         return false;
      }
   }
 */