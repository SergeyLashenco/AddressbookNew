package addressbook;



import org.testng.annotations.Test;

   public class DroupDeletionTests extends TestBase {

      @Test
      public void testGroupDeletion() throws Exception {

         gotoGroupPage();
         selectGroup();
         deleteSelectedGroups();
         returnToGroupPage();
      }


   }


