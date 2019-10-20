package addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {


   public WebDriver driver;
   //  private String baseUrl;
   private boolean acceptNextAlert = true;
   private StringBuffer verificationErrors = new StringBuffer();

   @BeforeMethod
   public void setUp() throws Exception {
      File file = new File("./src/drivers/geckodriver");
      System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
      driver = new FirefoxDriver();
      // baseUrl = "https://www.katalon.com/";
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      login("admin", "secret");
   }

   private void login(String userName, String password) {
      driver.get("http://localhost/addressbook/index.php");
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys(userName);
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
   }

   protected void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
   }

   protected void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
   }

   protected void fillGroupForm(GroupData groupData) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).clear();
      driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).clear();
      driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).clear();
      driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
   }

   protected void initGroupCreation() {
      driver.findElement(By.name("new")).click();
   }

   protected void gotoGroupPage() {
      driver.findElement(By.linkText("groups")).click();
   }

   @AfterMethod
   public void tearDown() throws Exception {
      driver.quit();

   }

   private boolean isElementPresent(By by) {
      try {
         driver.findElement(by);
         return true;
      } catch (NoSuchElementException e) {
         return false;
      }
   }

   private boolean isAlertPresent() {
      try {
         driver.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }



   protected void deleteSelectedGroups() {
      driver.findElement(By.name("delete")).click();
   }

   protected void selectGroup() {
      driver.findElement(By.name("selected[]")).click();
   }
}
