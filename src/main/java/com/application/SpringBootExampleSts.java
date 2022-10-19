package com.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// http://localhost:8080/welcome

/**
 * Assicurati che la tua classe principale sia nel pacchetto radice. 
 * Le altre classi dovrebbero essere nel sottopacchetto root. 
 * L'applicazione Spring Boot esegue la scansione del pacchetto dal pacchetto radice in cui esiste la 
 * classe principale con l'annotazione @SpringBootApplication e sottopacchetti.
 * 
 * +-- src/main/java
 * 		+-- com.application
 * 			| +-- Application.java(Main class)
 * 			| 
 * 			+ -- controller
 * 			  +-- TestController.java 
 * 
 * 
 * Nell'applicazione Spring Boot, se il pacchetto della classe principale non è un pacchetto root, 
 * gli altri bean del pacchetto non verranno caricati nel contesto Spring Boot. 
 * L'annotazione @ComponentScan nella classe principale informa i pacchetti di bean da caricare all'avvio.
 */




/*
 * Questa annotazione permette x abilitare le seguenti annotazioni ----> @SpringBootApplication
 * sts
 * @EnableAutoConfiguration: abilita il meccanismo di configurazione automatica Spring Boot.
 * @ComponentScan: esegue la scansione del pacchetto in cui si trova l'applicazione.
 * @Configuration: ci consente di registrare bean extra nel contesto o importare classi di configurazione aggiuntive.
 */

@SpringBootApplication
@ComponentScan({"com..controller"}) // DICE DI CARICARE QUELLO CHE C'è NEL PACKAGE TRA PARENTESI
public class SpringBootExampleSts {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleSts.class, args);    
	}
	
}