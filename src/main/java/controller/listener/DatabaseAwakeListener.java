package controller.listener;

import model.database.DatabaseHandler;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DatabaseAwakeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        DatabaseHandler databaseHandler = DatabaseHandler.getInstance();
        new Thread(()->{
            invokeDB(databaseHandler);
            try {
                Thread.sleep(600_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void invokeDB(DatabaseHandler databaseHandler)
    {
        System.out.println("Refresh database");
        databaseHandler.select("select count(*) from User;");
    }

}
