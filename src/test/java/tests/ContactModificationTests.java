package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends  TestBase {

   @Test (enabled = false)
   public  void  testContactModification () {
      app.goTo().gotoHomePage();
      if (!app.contact().isThereAContact()){
         app.contact().creationContact(new ContactData()
                 .withFirstname("TestContact1")
                 .withLastname("TestContact2")
                 .withGroup("test1"), true);
      }
      app.contact().initContactModification();
      app.contact().fillContactForm(
              new ContactData()
              .withFirstname("test_name")
              .withLastname("test_surname")
              .withGroup(null), false);
      app.contact().submitContactModification();
      app.contact().returnToHomepage();
   }
}
