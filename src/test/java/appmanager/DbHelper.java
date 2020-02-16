package appmanager;

import model.GroupData;
import model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.TestBase;

import java.util.List;

public class DbHelper {
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    private final SessionFactory sessionFactory;

    public DbHelper () {
         // A SessionFactory is set up once for an application!
         final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                 .configure() // configures settings from hibernate.cfg.xml
                 .build();

             sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        logger.info("Start session Db");
     }

     public Groups groups () {
         Session session = sessionFactory.openSession();
         session.beginTransaction();
         List<GroupData> result = session.createQuery("from GroupData").list();
         for (GroupData group :  result) {
             System.out.println(group);
         }
         session.getTransaction().commit();
         session.close();
         logger.info("Stop session Db");
         return  new Groups(result);
     }

}
