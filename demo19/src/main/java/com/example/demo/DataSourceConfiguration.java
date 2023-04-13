package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    //連線到test1資料庫的DataSource和NameParamterJdbcTemplate
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource test1DataSource(){
        return DataSourceBuilder.create().build();

    }

    @Bean
    public NamedParameterJdbcTemplate test1JdbcTemplate(
            @Qualifier("test1DataSource")DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    //連線到test2資料庫的DataSource和NameParamterJdbcTemplate
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2DataSource(){
        return DataSourceBuilder.create().build();

    }

    @Bean
    public NamedParameterJdbcTemplate test2JdbcTemplate(
            @Qualifier("test2DataSource")DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
