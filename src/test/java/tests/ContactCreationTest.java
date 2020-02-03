package tests;

import model.ContactData;
import org.testng.annotations.Test;

import java.io.File;

public class ContactCreationTest extends  TestBase {

   @Test ()
   public  void testContactCreation(){
      app.goTo().gotoHomePage();
      app.contact().initContactCreation();
      File photo = new File("src/test/resources/testWarPhoto.png");
      app.contact().fillContactForm(
              new ContactData()
              .withFirstname("SergeyWar")
              .withLastname("SergeyWarNew")
              .withPhoto(photo)
              .withGroup("test1"), true);
      app.contact().submitContactCreation();
      app.contact().returnToHomepage();


   }
}
