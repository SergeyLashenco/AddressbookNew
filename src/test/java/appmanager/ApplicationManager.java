package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private WebDriver wb;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String browser;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        dbHelper = new DbHelper();

        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        switch (browser) {
            case BrowserType.FIREFOX:
                wb = new FirefoxDriver();
                break;
            case BrowserType.CHROME:
                wb = new ChromeDriver();
                break;
            case BrowserType.IE:
                wb = new InternetExplorerDriver();
                break;
        }
        // baseUrl = "https://www.katalon.com/";
        wb.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wb.get(properties.getProperty("web.baseUrl"));
        groupHelper = new GroupHelper(wb);
        navigationHelper = new NavigationHelper(wb);
        sessionHelper = new SessionHelper(wb);
        contactHelper = new ContactHelper(wb);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    }

    public void stop() {
        wb.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public  DbHelper db () {
        return dbHelper;
    }
}
