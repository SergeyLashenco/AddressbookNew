package appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   public FirefoxDriver wb;

   private  SessionHelper sessionHelper;
   private  NavigationHelper navigationHelper ;
   private  GroupHelper groupHelper;


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
