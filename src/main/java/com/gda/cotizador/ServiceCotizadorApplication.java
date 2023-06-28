package com.gda.cotizador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

public class ServiceCotizadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCotizadorApplication.class, args);
	}

}
