package ags.SechsY.temperaturverwaltung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TemperaturverwaltungApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperaturverwaltungApplication.class, args);
	}

}
