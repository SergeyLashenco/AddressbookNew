package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends  TestBase {

   @Test
   public  void testContactCreation(){
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().initContactCreation();
      app.getContactHelper().fillContactForm(
              new ContactData("test_name", "test_surname","test1") , true);
      app.getContactHelper().submitContactCreation();
      app.getContactHelper().returnToHomepage();


   }

}
