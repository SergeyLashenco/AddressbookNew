package tests;

import model.ContactData;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactPhoneTests extends  TestBase {


    @Test
    public void testContactPhones (){
        app.goTo().gotoHomePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditFrom = app.contact().infoFromEditFrom(contact);
    }
}
