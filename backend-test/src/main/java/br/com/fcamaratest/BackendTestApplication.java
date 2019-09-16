package br.com.fcamaratest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTestApplication.class, args);
		}

}
