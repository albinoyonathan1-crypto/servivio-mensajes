package com.facultades.mensajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MensajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensajesApplication.class, args);
	}

}
