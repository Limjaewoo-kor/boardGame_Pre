package com.prepot;

import com.prepot.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Optional;


@Import(MyBatisConfig.class)
@SpringBootApplication(scanBasePackages = "com.prepot")
public class PrepotApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrepotApplication.class, args);


	}

}
