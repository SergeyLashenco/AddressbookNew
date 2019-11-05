package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

   public NavigationHelper(WebDriver wb) {
      super(wb);
   }

   public void gotoGroupPage() {
      click(By.linkText("groups"));
   }
}
