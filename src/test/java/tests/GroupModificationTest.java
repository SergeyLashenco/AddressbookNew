package tests;

import model.GroupData;
import model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends  TestBase {

   @BeforeMethod
   public void ensurePreconditions(){
      app.goTo().groupPage();
      if (app.group().all().size() == 0){
         app.group().create(new GroupData().withName("test1"));
      }
   }

   @Test (priority = 2)
   public  void testGroupModification(){

      Groups before = app.group().all();
      GroupData modificationGroup = before.iterator().next();
      GroupData group = new GroupData()
              .withId(modificationGroup.getId())
              .withName("test1")
              .withHeader("test2")
              .withFooter("test3");
      app.group().modify(group);
      assertThat(app.group().count(), equalTo( before.size()));
      Groups after = app.group().all();
      assertThat(after, equalTo(before.without(modificationGroup).withAdded(group)));
   }

}
