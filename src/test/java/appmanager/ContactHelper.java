package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends  HelperBase {

   public  ContactHelper (WebDriver wb) {
      super(wb);
   }
   public  void initContactCreation () {
      click(By.linkText("add new"));
   }

   public  void fillContactForm (ContactData contactData){
      type(By.name("firstname") ,contactData.getFirstname() );
      type(By.name("lastname") ,contactData.getSecondname() );
   }

   public  void submitContactCreation(){
      click(By.name("submit"));
   }

   public void returnToHomepage (){
      click(By.linkText("home page"));
   }

   public void initContactModification (){
      click(By.cssSelector("img[alt='Edit']"));
   }

   public void submitContactModification () {
      click(By.name("update"));
   }



}
