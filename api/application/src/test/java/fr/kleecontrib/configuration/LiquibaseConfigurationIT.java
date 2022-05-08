package fr.kleecontrib.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.TestPropertySource;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@TestPropertySource(locations = "classpath:application-test.properties")
public class LiquibaseConfigurationIT {

	@Autowired
	private Environment env;

	@Bean
	public SpringLiquibase liquibase() {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setDataSource(dataSource());
		liquibase.setChangeLog("classpath:/db/changelog/db.changelog-master.yaml");
		// drop BDD à chaque lancement du context spring
		liquibase.setDropFirst(true);
		return liquibase;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}
}
