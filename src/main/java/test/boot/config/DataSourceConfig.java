package test.boot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.middev")
	public DataSourceProperties middevDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.middev")
	public DataSource middevDataSource() {
		return middevDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource.dc")
	public DataSourceProperties dcDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource.dc")
	public DataSource dcDataSource() {
		return dcDataSourceProperties().initializeDataSourceBuilder().build();
	}
}
