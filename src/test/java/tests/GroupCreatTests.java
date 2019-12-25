package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupCreatTests extends TestBase {

   @Test (priority = 0)
   public void testGroupCreation() {
      app.goTo().groupPage();
      List<GroupData> before = app.group().list();
      GroupData group = new GroupData("test7", null, null);
      app.group().create(group);
      List<GroupData> after = app.group().list();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(group);
      Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
   }
}
