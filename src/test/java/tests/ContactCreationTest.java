package tests;

import model.ContactData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends  TestBase {

   @Test ()
   public  void testContactCreation(){
      app.goTo().gotoHomePage();
      app.contact().initContactCreation();
      app.contact().fillContactForm(
              new ContactData()
              .withFirstname("aaa")
              .withLastname("adawd")
              .withGroup("test1"), true);
      app.contact().submitContactCreation();
      app.contact().returnToHomepage();


   }

}
