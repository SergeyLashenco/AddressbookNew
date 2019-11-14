package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupModificationTest extends  TestBase {

   @Test
   public  void testGroupModification(){

      app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()){
         app.getGroupHelper().createGruop(new GroupData("Ser", "one", "null"));
      }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();

   }
}
