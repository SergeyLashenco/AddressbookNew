package tests;

import appmanager.ApplicationManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.GroupData;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestBase {


   protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

   @BeforeSuite
   public void setUp() {
      app.init();
   }

   @AfterSuite
   public void tearDown() {
      app.stop();

   }
}
