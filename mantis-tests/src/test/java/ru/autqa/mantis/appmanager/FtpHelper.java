package ru.autqa.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper {

    private  final  ApplicationManager app ;
    private FTPClient ftp;

    public FtpHelper(ApplicationManager app) {
        this.app = app;
        ftp = new FTPClient();
    }
    public  void  upload (File file , String target , String backup) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.login") , app.getProperty("ftp.password"));
        ftp.deleteFile(backup);
        ftp.rename(target,backup);
        ftp.enterLocalPassiveMode();
        /*
        Локальный file из него делается FileInputStream (предназначен для чтения бинарных данных , а именно побайтовое чтение )
         и эти данные читаются из локального файла , передаются на удлаенную машину и там сохраняются в удаленном файле который называется target
         */
        ftp.storeFile(target, new FileInputStream(file));
        ftp.disconnect();
    }

    public void restore (String backup , String target ) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.login") , app.getProperty("ftp.password"));
        ftp.deleteFile(target);
        ftp.rename(backup,target);
        ftp.disconnect();
    }

}
