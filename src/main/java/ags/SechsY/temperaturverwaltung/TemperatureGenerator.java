package ags.SechsY.temperaturverwaltung;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.model.Sensor;
import ags.SechsY.temperaturverwaltung.model.Temperature;
import ags.SechsY.temperaturverwaltung.service.SensorService;
import ags.SechsY.temperaturverwaltung.service.TemperatureService;

@Component
public class TemperatureGenerator {

    @Autowired
    SensorService sensorService;
    @Autowired
    TemperatureService temperatureService;

    @Scheduled(fixedRate = 3000)
    public void createTemperatures() {
        List<Sensor> sensors = sensorService.findAll();
        for (Sensor sensor : sensors) {
            List<Temperature> temps = temperatureService.findBySensorId(sensor.getId());
            Float newTempValue = sensor.getMaxTemperature() / 1.5f;
            if (temps.size() > 0) {
                Float currentTemp = temps.get(0).getTemperature_value();
                Random rand = new Random();
                float modificator = (currentTemp / (sensor.getMaxTemperature())) * -10;
                newTempValue = currentTemp + modificator + (rand.nextFloat() * 5);
            }
            Temperature temp = new Temperature(newTempValue, sensor);
            System.out.println(temperatureService.create(temp));
        }
    }
}