package com.dulsystems.mta.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	
	/**
	 * Propiedad con el valor de la propiedad env
	 */
	@Autowired
    private Environment env;

	@Primary
    @Bean(name = "dbtranjdbctemplatenamedver")
    public NamedParameterJdbcTemplate jdbcTemplateNamed() {
        return new NamedParameterJdbcTemplate(userDataSource());
    }

	@Bean(name = "userDataSource", destroyMethod = "close")
	@Primary
	public DataSource userDataSource() {
		HikariDataSource dataSource = null;
		try {
			dataSource = new HikariDataSource();
			dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
			dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
			dataSource.setUsername(env.getProperty("spring.datasource.username"));
			dataSource.setPassword(env.getProperty("spring.datasource.password"));
			dataSource.addDataSourceProperty("implicitCachingEnabled",
					env.getProperty("spring.datasource.hikari.implicitCachingEnabled"));
			dataSource.addDataSourceProperty("maxStatements",
					Integer.valueOf(env.getProperty("spring.datasource.hikari.maxStatements")));
			dataSource.setMaximumPoolSize(Integer.valueOf(env.getProperty("spring.datasource.hikari.maximum-pool-size")));
			dataSource.setConnectionTimeout(Integer.valueOf(env.getProperty("spring.datasource.hikari.connection-timeout")));
			dataSource.setIdleTimeout(Integer.valueOf(env.getProperty("spring.datasource.hikari.idle-timeout")));
			dataSource.setMinimumIdle(Integer.valueOf(env.getProperty("spring.datasource.hikari.minimum-idle")));
			dataSource.setAutoCommit(true);

		}catch (NullPointerException e) {
			//LOGGER.error("errMergeFile",e);
			return null;
		}finally {
			if (dataSource != null) {
        		return dataSource;
        	}
		}
		return dataSource;
	}

}
