package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreatTests extends  TestBase {

   @Test
   public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      int before = app.getGroupHelper().getGroupCount();
      app.getGroupHelper().createGruop(new GroupData("testlast", null, null));
      int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after , before +1);
   }
}
