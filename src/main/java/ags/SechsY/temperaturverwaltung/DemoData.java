package ags.SechsY.temperaturverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.model.Log;
import ags.SechsY.temperaturverwaltung.model.User;
import ags.SechsY.temperaturverwaltung.service.LogService;
import ags.SechsY.temperaturverwaltung.service.UserService;

@Component
public class DemoData {

    @Autowired
    UserService userService;
    @Autowired
    LogService logService;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        addDemoData();
    }

    private void addDemoData() {
        System.out.println("\nINSERTING TEST DATA");

        User user1 = new User("Tim", "Ebby", "015772", true);
        userService.createUser(user1);

        Log log1 = new Log(255.f, user1);
        logService.createLog(log1);
    }

}
