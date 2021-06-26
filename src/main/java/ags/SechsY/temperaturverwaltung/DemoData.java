package ags.SechsY.temperaturverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dao.LogDAO;
import ags.SechsY.temperaturverwaltung.dao.UserDAO;
import ags.SechsY.temperaturverwaltung.model.Log;
import ags.SechsY.temperaturverwaltung.model.User;

@Component
public class DemoData {

    @Autowired
    UserDAO userDao;
    @Autowired
    LogDAO logDao;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        addDemoData();
    }

    private void addDemoData() {
        System.out.println("\nINSERTING TEST DATA");

        User user1 = new User("Tim", "Ebby", "015772", true);
        userDao.save(user1);

        Log log1 = new Log(255.f, user1);
        logDao.save(log1);
    }

}
