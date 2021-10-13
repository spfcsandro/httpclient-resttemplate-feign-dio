package br.com.dio.httpclientresttemplatefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HttpclientResttemplateFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpclientResttemplateFeignApplication.class, args);
	}

}
