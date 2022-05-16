package com.colecta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Clase principal de la aplicación en Spring de Colecta
 * @author shahr
 *
 */
@Import({AppConfig.class})
@SpringBootApplication
public class App implements CommandLineRunner{
	public static void main( String[] args ){
    	SpringApplication.run(App.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hiii");
	}
}
