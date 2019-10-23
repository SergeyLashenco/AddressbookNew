package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
   private FirefoxDriver wb;

   public NavigationHelper(FirefoxDriver wb) {
      this.wb = wb;
   }

   public void gotoGroupPage() {
     wb.findElement(By.linkText("groups")).click();
   }
}
