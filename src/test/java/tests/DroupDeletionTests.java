package tests;



import model.GroupData;
import org.testng.annotations.Test;

   public class DroupDeletionTests extends TestBase {

      @Test
      public void testGroupDeletion() throws Exception {

         app.getNavigationHelper().gotoGroupPage();
         if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGruop(new GroupData("Sergey", "test", "null"));
         }
         app.getGroupHelper().selectGroup();
         app.getGroupHelper().deleteSelectedGroups();
         app.getGroupHelper().returnToGroupPage();
      }


   }


