package com.javatpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * Questa annotazione permette x abilitare le seguenti annotazioni ----> @SpringBootApplication
 * sts
 * @EnableAutoConfiguration: abilita il meccanismo di configurazione automatica Spring Boot.
 * @ComponentScan: esegue la scansione del pacchetto in cui si trova l'applicazione.
 * @Configuration: ci consente di registrare bean extra nel contesto o importare classi di configurazione aggiuntive.
 */
public class SpringBootExampleSts {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleSts.class, args);    
		
		///
	}
	
	

}
