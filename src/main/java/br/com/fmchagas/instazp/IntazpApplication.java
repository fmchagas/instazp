package br.com.fmchagas.instazp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(enableDefaultTransactions = false)
@SpringBootApplication
public class IntazpApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntazpApplication.class, args);
	}

}
