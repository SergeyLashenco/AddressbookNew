package tests;

import model.GroupData;
import org.testng.annotations.Test;

public class GroupCreatTests extends  TestBase {

   @Test
   public void testGroupCreation() throws Exception {

      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().initGroupCreation();
      app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
      app.getGroupHelper().submitGroupCreation();
      app.getGroupHelper().returnToGroupPage();
   }

}
