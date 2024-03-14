package com.example.watchstore;

import com.example.watchstore.model.Contact;
import com.example.watchstore.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WatchStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WatchStoreApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api").allowedOrigins("http://localhost:8080");
			}
		};
	}

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void run(String... args)throws Exception{
		Contact c1= new Contact();
		c1.setName("Kukesan");
		c1.setMessage("Hello");
		c1.setEmail("test@gmail.com");
		contactRepository.save(c1);

		Contact c2= new Contact();
		c2.setName("Kamal");
		c2.setMessage("hai");
		c2.setEmail("test123@gmail.com");
		contactRepository.save(c2);
	}
}
