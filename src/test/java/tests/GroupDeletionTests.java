package tests;


import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
         app.group().create(new GroupData().withName("test1"));
      }
   }


   @Test (priority = 1)
   public void testGroupDeletion() {
      Groups before = app.group().all();
      GroupData deletedGroup = before.iterator().next();
      app.group().delete(deletedGroup);
      assertThat(app.group().count(), equalTo( before.size() - 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(before.without(deletedGroup)));

   }
}


