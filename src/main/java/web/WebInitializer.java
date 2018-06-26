package web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebInitializer extends SpringBootServletInitializer {
	private static final Logger logger = LogManager.getLogger(WebInitializer.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.error("test");
		return application.sources(WebInitializer.class);
	}

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(WebInitializer.class, args);
	}

}