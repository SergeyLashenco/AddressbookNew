package tests;



import org.testng.annotations.Test;

   public class DroupDeletionTests extends TestBase {

      @Test
      public void testGroupDeletion() throws Exception {

         app.gotoGroupPage();
         app.selectGroup();
         app.deleteSelectedGroups();
         app.returnToGroupPage();
      }


   }


