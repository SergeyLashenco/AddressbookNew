package ru.autqa.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper {
   private WebDriver wd;
   private  final  ApplicationManager app ;

    public RegistrationHelper(ApplicationManager app) {
      this.app= app;
       wd = app.getDriver();

    }


    public  void start(String username , String email){
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    }
}

//manage_user_create_page.php
//  extends HelperBase

/*
 type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.cssSelector("input[value='Signup']"));
 */