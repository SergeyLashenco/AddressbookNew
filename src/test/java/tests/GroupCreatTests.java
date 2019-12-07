package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreatTests extends  TestBase {

   @Test
   public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().createGruop(new GroupData("testlast", null, null));
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size() , before.size() +1);
   }
}
