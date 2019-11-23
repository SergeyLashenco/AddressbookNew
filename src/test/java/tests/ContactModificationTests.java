package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends  TestBase {

   @Test
   public  void  testContactModification () {
      app.getNavigationHelper().gotoHomePage();
      if (!app.getContactHelper().isThereAContact()){
         app.getContactHelper().creationContact(new ContactData("TestContact1", "TestContact1", "test1"), true);
      }
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(
              new ContactData("test_name", "test_surname",null), false);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomepage();
   }
}
