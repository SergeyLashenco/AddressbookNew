package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreatTests extends TestBase {

   @Test
   public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      List<GroupData> before = app.getGroupHelper().getGroupList();
      GroupData group = new GroupData("test7", null, null);
      app.getGroupHelper().createGruop(group);
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size() + 1);

      group.setId(after.stream().max((groupData, t1)
              -> Integer.compare(groupData.getId(), t1.getId())).get().getId());
      before.add(group);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
   }
}
