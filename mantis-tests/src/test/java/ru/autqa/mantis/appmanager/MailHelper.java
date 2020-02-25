package ru.autqa.mantis.appmanager;


import org.subethamail.wiser.Wiser;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class MailHelper {

   private  ApplicationManager app;
   private  final Wiser wiser;

   public  MailHelper (ApplicationManager app){
      this.app = app;
      wiser = new Wiser();
   }


}


/*
public List<MailMessage> waitForMail (int count , long timeout) throws MessagingException , IOException {
      long start = System.currentTimeMillis();

   }
 */