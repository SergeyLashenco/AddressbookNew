package tests;

import appmanager.ApplicationManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.GroupData;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestBase {
   Logger logger = LoggerFactory.getLogger(TestBase.class);

   protected static final ApplicationManager app
           = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
   @BeforeSuite
   public void setUp() throws IOException {
      app.init();
   }

   @AfterSuite(alwaysRun = true)
   public void tearDown() {
      app.stop();
   }

   @BeforeMethod
   public  void  logTestStart(Method m, Object[] p  ){
      logger.info("Start " + m.getName() + " with parameters " + Arrays.asList(p));

   }
   @AfterMethod(alwaysRun = true)
   public  void  logTestStop(Method m){
      logger.info("Stop " + m.getName());

   }
}
