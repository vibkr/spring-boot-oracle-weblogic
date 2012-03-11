package com.unilever.api.unileverheartbeatapi.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import static com.unilever.api.unileverheartbeatapi.util.Constants.*;

@Configuration
public class MultipleDBConfig {
    //Dev DBs
    @Value("${spring.datasource.PUNL76.jndi-name}")
    private String punl76JndiName;
    @Value("${spring.datasource.PUNL36.jndi-name}")
    private String punl36JndiName;
    @Value("${spring.datasource.PUNL26.jndi-name}")
    private String punl26JndiName;
    @Value("${spring.datasource.PUNL66.jndi-name}")
    private String punl66JndiName;
    @Value("${spring.datasource.PUNL56.jndi-name}")
    private String punl56JndiName;


    private JndiDataSourceLookup lookup = new JndiDataSourceLookup();


    // For Dev DB instances
    @Primary
    @Bean(name = "PUNL76", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
    public DataSource punl76DataSource() {
        return lookup.getDataSource(punl76JndiName);
    }

    @Bean(name = "PUNL36", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
    public DataSource punl36DataSource() {
        return lookup.getDataSource(punl36JndiName);
    }

    @Bean(name = "PUNL26", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
    public DataSource punl26DataSource() {
        return lookup.getDataSource(punl26JndiName);
    }

    @Bean(name = "PUNL66", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
    public DataSource punl66DataSource() {
        return lookup.getDataSource(punl66JndiName);
    }

    @Bean(name = "PUNL56", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
    public DataSource punl56DataSource() {
        return lookup.getDataSource(punl56JndiName);
    }




    // JDBC Template for Dev Instances

    @Primary
    @Bean(name = "punl76JdbcTemplate")
    public JdbcTemplate punl76JdbcTemplate(@Qualifier("PUNL76")DataSource punl76DataSource) {
        return new JdbcTemplate(punl76DataSource);
    }

    @Bean(name = "punl36JdbcTemplate")
    public JdbcTemplate punl36JdbcTemplate(@Qualifier("PUNL36") DataSource punl36DataSource) {
        return new JdbcTemplate(punl36DataSource);
    }

    @Bean(name = "punl26JdbcTemplate")
    public JdbcTemplate punl26JdbcTemplate(@Qualifier("PUNL26") DataSource punl26DataSource) {
        return new JdbcTemplate(punl26DataSource);
    }

    @Bean(name = "punl66JdbcTemplate")
    public JdbcTemplate punl66JdbcTemplate(@Qualifier("PUNL66") DataSource punl66DataSource) {
        return new JdbcTemplate(punl66DataSource);
    }


    @Bean(name = "punl56JdbcTemplate")
    public JdbcTemplate punl56JdbcTemplate(@Qualifier("PUNL56") DataSource punl56DataSource) {
        return new JdbcTemplate(punl56DataSource);
    }

}