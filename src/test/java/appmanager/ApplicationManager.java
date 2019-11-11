package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   private WebDriver wb;

   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;
   private ContactHelper contactHelper;
   private String browser;

   public ApplicationManager(String browser) {

      this.browser = browser;
   }


   public void init() {
      File file = new File("./src/drivers/geckodriver");
      System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
      switch (browser) {
         case BrowserType.FIREFOX:
            wb = new FirefoxDriver();
            break;
         case BrowserType.CHROME:
            wb = new ChromeDriver();
            break;
         case BrowserType.IE:
            wb = new InternetExplorerDriver();
            break;
      }


      // baseUrl = "https://www.katalon.com/";
      wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      groupHelper = new GroupHelper(wb);
      navigationHelper = new NavigationHelper(wb);
      sessionHelper = new SessionHelper(wb);
      contactHelper = new ContactHelper(wb);
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

   public ContactHelper getContactHelper() {
      return contactHelper;
   }
}
