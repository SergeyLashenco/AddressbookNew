package ru.autqa.mantis.appmanager;

import com.sun.xml.bind.v2.TODO;
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
    private WebDriver wd;
    private String browser;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;
    private MailHelper mailHelper;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {
       String target = System.getProperty("target", "local");
       properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    }

    public void stop() {
        if (wd != null){
            wd.quit();
        }
    }

    public HttpSession newSession (){
        return new  HttpSession (this);
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
      return registrationHelper;
    }

    public FtpHelper ftp (){
        if (ftp == null) {
            ftp =   new FtpHelper(this);
        }
        return ftp;
    }

    //Линивая инициализация Веб Дривера , драйвер будет инициализирован только тогда когда кто то вызовет этот метод. Из за этого делаем  private   WebDriver wd;
    // В методе public void init() будет загружатся только конфигурационный файл и все.
    public WebDriver getDriver() {
        if (wd == null){
            switch (browser) {
                case BrowserType.FIREFOX:
                    wd = new FirefoxDriver();
                    break;
                case BrowserType.CHROME:
                    wd = new ChromeDriver();
                    break;
                case BrowserType.IE:
                    wd = new InternetExplorerDriver();
                    break;
            }
            wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            //TODO здесь требуется оптимизировать код
            wd.get(properties.getProperty("web.baseUrl"));
        }
        return wd;
    }

    public  MailHelper mail () {
        if (mailHelper == null){
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }
}
