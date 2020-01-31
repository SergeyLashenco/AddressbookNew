package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wb) {
        super(wb);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());

        if (creation) {
            new Select(wb.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementpresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void returnToHomepage() {
        click(By.linkText("home page"));
    }

    public void initContactModification() {
        click(By.cssSelector("img[alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {
        return isElementpresent(By.cssSelector("img[alt='Edit']"));
    }

    public void creationContact(ContactData contactData, boolean creation) {
        initContactCreation();
        fillContactForm(contactData, creation);
        submitContactCreation();
        returnToHomepage();
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<>();
        List<WebElement> rows = wb.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String allphones = cells.get(5).getText();

            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
            .withAllPhones(allphones));
        }
        return contacts;
    }

    public ContactData infoFromEditFrom (ContactData contact){
        initContactModificationById (contact.getId());
        String firstname = wb.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wb.findElement(By.name("lastname")).getAttribute("value");
        String home = wb.findElement(By.name("home")).getAttribute("value");
        String mobile = wb.findElement(By.name("mobile")).getAttribute("value");
        String work = wb.findElement(By.name("work")).getAttribute("value");
        wb.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);


    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wb.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();


        //  wb.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
    }
}
