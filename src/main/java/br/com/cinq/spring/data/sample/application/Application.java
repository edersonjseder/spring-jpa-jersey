package br.com.cinq.spring.data.sample.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Greeting Service.
 */
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "br.com.cinq.spring.data.sample" })
@EnableJpaRepositories("br.com.cinq.spring.data.sample.repository")
@EntityScan(basePackages = {"br.com.cinq.spring.data.sample.model"})
@EnableTransactionManagement // This enables annotation based transaction management (JPA transaction is managed by default)
public class Application implements CommandLineRunner {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    
    private final String FILENAME = "sql/db_init.mysql.sql";
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		LOG.info("Starting CommandLine method script running");
		
		String filePath = getClass().getClassLoader().getResource(FILENAME).getPath();

		LOG.info("Complete SQL script path {} ", filePath);
		
		/*
		 * This snippet is for executing SQL script on your current database 
		 * configured according to your database credentials and replace them
		 * in applications.properties file
		 * 
		Utils upload = new Utils();

		upload.executeScriptUsingScriptRunner(filePath); 
		
		*/
			
	}

}
