package io.karlokamenar.CoronaViruspratitelj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaVirusPratiteljApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaVirusPratiteljApplication.class, args);
	}

}
