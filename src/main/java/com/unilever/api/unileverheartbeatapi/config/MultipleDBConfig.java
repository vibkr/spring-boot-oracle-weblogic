package com.unilever.api.unileverheartbeatapi.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static com.unilever.api.unileverheartbeatapi.util.Constants.*;

@Configuration
public class MultipleDBConfig {


    @Bean(name = "uunl86")
    @ConfigurationProperties(prefix = "spring.datasource.uunl86")
    public DataSource uunl86DataSource() {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "uunl86JdbcTemplate")
    public JdbcTemplate uunl86JdbcTemplate(@Qualifier("uunl86")DataSource uunl86DataSource) {
        return new JdbcTemplate(uunl86DataSource);
    }


    @Bean(name = "tunl76")
    @ConfigurationProperties(prefix = "spring.datasource.tunl76")
    public DataSource tunl76DataSource() {

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tunl76JdbcTemplate")
    public JdbcTemplate tunl76JdbcTemplate(@Qualifier("tunl76") DataSource tunl76DataSource) {
        return new JdbcTemplate(tunl76DataSource);
    }

    @Bean(name = "dunl46")
    @ConfigurationProperties(prefix = "spring.datasource.dunl46")
    public DataSource dunl46DataSource() {

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dunl46JdbcTemplate")
    public JdbcTemplate dunl46JdbcTemplate(@Qualifier("dunl46") DataSource dunl46DataSource) {
        return new JdbcTemplate(dunl46DataSource);
    }

    @Bean(name = "uunlv6")
    @ConfigurationProperties(prefix = "spring.datasource.uunlv6")
    public DataSource uunlv6DataSource() {

        return DataSourceBuilder.create().build();
    }
    @Bean(name = "tunl86")
    @ConfigurationProperties(prefix = "spring.datasource.tunl86")
    public DataSource tunl86DataSource() {

        return DataSourceBuilder.create().build();
    }
    @Bean(name = "uunlv6JdbcTemplate")
    public JdbcTemplate uunlv6JdbcTemplate(@Qualifier("uunlv6") DataSource uunlv6DataSource) {
        return new JdbcTemplate(uunlv6DataSource);
    }

    @Bean(name = "uunl36")
    @ConfigurationProperties(prefix = "spring.datasource.uunl36")
    public DataSource uunl36DataSource() {

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "uunl36JdbcTemplate")
    public JdbcTemplate uunl36JdbcTemplate(@Qualifier("uunl36") DataSource uunl36DataSource) {
        return new JdbcTemplate(uunl36DataSource);
    }

    @Bean(name = "tunl86JdbcTemplate")
    public JdbcTemplate tunl86JdbcTemplate(@Qualifier("tunl86") DataSource tunl86DataSource) {
        return new JdbcTemplate(tunl86DataSource);
    }

    @Bean(name = "tunl86NamedParamJdbcTemplate")
    public NamedParameterJdbcTemplate tunl86NamedParamJdbcTemplate(@Qualifier("tunl86") DataSource tunl86DataSource) {
        return new NamedParameterJdbcTemplate(tunl86DataSource);
    }
}