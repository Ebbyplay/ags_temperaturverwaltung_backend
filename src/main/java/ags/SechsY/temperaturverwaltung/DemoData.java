package ags.SechsY.temperaturverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.model.Log;
import ags.SechsY.temperaturverwaltung.model.Manufacturer;
import ags.SechsY.temperaturverwaltung.model.Sensor;
import ags.SechsY.temperaturverwaltung.model.ServerRack;
import ags.SechsY.temperaturverwaltung.model.Temperature;
import ags.SechsY.temperaturverwaltung.model.User;
import ags.SechsY.temperaturverwaltung.service.LogService;
import ags.SechsY.temperaturverwaltung.service.ManufacturerService;
import ags.SechsY.temperaturverwaltung.service.UserService;

@Component
public class DemoData {

    @Autowired
    UserService userService;
    @Autowired
    LogService logService;
    @Autowired
    ManufacturerService manufacturerService;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        addDemoData();
    }

    private void addDemoData() {
        System.out.println("\nINSERTING TEST DATA");

        Manufacturer manufacturer1 = new Manufacturer("Cisco");
        Manufacturer manufacturer2 = new Manufacturer("Samsung");
        manufacturerService.createManufacturer(manufacturer1);
        manufacturerService.createManufacturer(manufacturer2);

        ServerRack rack1 = new ServerRack();
        ServerRack rack2 = new ServerRack();
        ServerRack rack3 = new ServerRack();
        // TODO: save

        User user1 = new User("Tim", "Ebby", "015772", true);
        User user2 = new User("Nick", "Niggi", "99085", false);
        userService.createUser(user1);
        userService.createUser(user2);

        Sensor sensor1 = new Sensor(60.f, rack1, manufacturer1);
        Sensor sensor2 = new Sensor(80.f, rack2, manufacturer1);
        Sensor sensor3 = new Sensor(70.f, rack3, manufacturer2);
        // TODO: save

        Temperature temp1 = new Temperature(50.f, sensor1);
        Temperature temp2 = new Temperature(55.f, sensor1);
        Temperature temp3 = new Temperature(56.f, sensor1);
        // TODO: save

        Log log1 = new Log(20.f, user1, sensor1);
        logService.createLog(log1);
    }

}
