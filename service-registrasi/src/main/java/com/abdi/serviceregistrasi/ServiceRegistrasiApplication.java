package com.abdi.serviceregistrasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrasiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistrasiApplication.class, args);
	}

}
