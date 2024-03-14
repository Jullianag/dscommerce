package com.devsuperior.dscommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DscommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DscommerceApplication.class, args);

	}
/*
	@Override
	public void run(String... args) throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("crip 123456 "+encoder.encode("123456"));
	}

 */
}
