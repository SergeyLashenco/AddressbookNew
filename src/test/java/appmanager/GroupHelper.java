package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GroupHelper extends  HelperBase{

   public GroupHelper(WebDriver wb) {
      super(wb);
   }

   public void returnToGroupPage() {
      click(By.linkText("group page"));
   }

   public void submitGroupCreation() {
      click(By.name("submit"));
   }

   public void fillGroupForm(GroupData groupData) {
      type(By.name("group_name"), groupData.getName());
      type(By.name("group_header"), groupData.getHeader());
      type(By.name("group_footer"), groupData.getFooter());
   }

   public void initGroupCreation() {
      click(By.name("new"));
   }

   public void deleteSelectedGroups() {
      click(By.name("delete"));
   }

   public void selectGroup( int index) {
      wb.findElements(By.name("selected[]")).get(index).click();
   }

   public void initGroupModification() {
      click(By.name("edit"));
   }

   public void submitGroupModification() {
      click(By.name("update"));
   }

   public boolean isThereAGroup() {

      return isElementpresent(By.name("selected[]"));
   }

   public void createGruop(GroupData group) {
      initGroupCreation();
      fillGroupForm(group);
      submitGroupCreation();
      returnToGroupPage();
   }

   public int getGroupCount() {
     return wb.findElements(By.name("selected[]")).size();
   }
}
