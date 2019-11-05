package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{

   SessionHelper(WebDriver wb) {
      super( wb);
   }


   public void login(String userName, String password) {
      wb.get("http://localhost/addressbook/index.php");
      type(By.name("user") , userName);
      type( By.name("pass") , password );
      click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]"));
   }
}
