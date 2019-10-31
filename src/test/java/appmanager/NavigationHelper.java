package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

   public NavigationHelper(FirefoxDriver wb) {
      super(wb);
   }

   public void gotoGroupPage() {
      click(By.linkText("groups"));
   }
}
