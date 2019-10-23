package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper {
   private  FirefoxDriver wb;


   public SessionHelper(FirefoxDriver wb) {
      this.wb = wb ;
   }


   public void login(String userName, String password) {
      wb.get("http://localhost/addressbook/index.php");
      wb.findElement(By.name("user")).click();
      wb.findElement(By.name("user")).clear();
      wb.findElement(By.name("user")).sendKeys(userName);
      wb.findElement(By.name("pass")).click();
      wb.findElement(By.name("pass")).clear();
      wb.findElement(By.name("pass")).sendKeys(password);
      wb.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
   }
}
