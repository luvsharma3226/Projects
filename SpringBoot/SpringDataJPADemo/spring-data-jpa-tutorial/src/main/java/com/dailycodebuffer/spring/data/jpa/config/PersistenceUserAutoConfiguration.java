package com.dailycodebuffer.spring.data.jpa.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource({ "file:src/main/resources/multiple-db.properties" })
@EnableJpaRepositories(
  basePackages = "com.baeldung.multipledb.dao.user",
  entityManagerFactoryRef = "userEntityManager",
  transactionManagerRef = "userTransactionManager")
public class PersistenceUserAutoConfiguration {
    
    @Primary
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }
    // userEntityManager bean 

    // userTransactionManager bean
}