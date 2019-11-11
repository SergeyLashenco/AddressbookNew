package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends  TestBase {

   @Test
   public  void  testContactModification () {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(
              new ContactData("test_name", "test_surname",null), false);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomepage();
   }
}
