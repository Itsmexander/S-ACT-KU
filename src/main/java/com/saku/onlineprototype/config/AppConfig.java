package com.saku.onlineprototype.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories
@EnableJpaAuditing
@ComponentScan
@Configuration
public class AppConfig {
    @Bean
    EntityManagerFactory entityManagerFactory(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("example-unit");
        return emf;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
}
