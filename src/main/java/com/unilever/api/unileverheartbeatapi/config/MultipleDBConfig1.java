package com.unilever.api.unileverheartbeatapi.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import static com.unilever.api.unileverheartbeatapi.util.Constants.*;

@Configuration
public class MultipleDBConfig1 {
//    //Dev DBs
//    @Value("${spring.datasource.UUNL86.jndi-name}")
//    private String uunl86JndiName;
//    @Value("${spring.datasource.TUNL76.jndi-name}")
//    private String tunl76JndiName;
//    @Value("${spring.datasource.DUNL46.jndi-name}")
//    private String dunl46JndiName;
//    @Value("${spring.datasource.UUNLV6.jndi-name}")
//    private String uunlv6JndiName;
//    @Value("${spring.datasource.UUNL36.jndi-name}")
//    private String uunl36JndiName;
//    // QA DBs
//    @Value("${spring.datasource.UUNL56.jndi-name}")
//    private String uunl56JndiName;
//    @Value("${spring.datasource.TUNL86.jndi-name}")
//    private String tunl86JndiName;
//    @Value("${spring.datasource.DUNL56.jndi-name}")
//    private String dunl56JndiName;
//    @Value("${spring.datasource.UUNL16.jndi-name}")
//    private String uunl16JndiName;
//    @Value("${spring.datasource.UUNL46.jndi-name}")
//    private String uunl46JndiName;
//    @Value("${spring.datasource.SUNLV6.jndi-name}")
//    private String sunlv6JndiName;
//    //RT DBs
//    @Value("${spring.datasource.UUNL76.jndi-name}")
//    private String uunl76JndiName;
//    @Value("${spring.datasource.SUNL36.jndi-name}")
//    private String sunl36JndiName;
//    @Value("${spring.datasource.SUNL26.jndi-name}")
//    private String sunl26JndiName;
//    @Value("${spring.datasource.SUNL56.jndi-name}")
//    private String sunl56JndiName;
//    @Value("${spring.datasource.UUNL26.jndi-name}")
//    private String uunl26JndiName;
//
//    private JndiDataSourceLookup lookup = new JndiDataSourceLookup();
//
//
//    // For Dev DB instances
//    @Primary
//    @Bean(name = "UUNL86", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource uunl86DataSource() {
//        return lookup.getDataSource(uunl86JndiName);
//    }
//
//    @Bean(name = "TUNL76", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource tunl76DataSource() {
//        return lookup.getDataSource(tunl76JndiName);
//    }
//
//    @Bean(name = "DUNL46", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource dunl46DataSource() {
//        return lookup.getDataSource(dunl46JndiName);
//    }
//
//    @Bean(name = "UUNLV6", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource uunlv6DataSource() {
//        return lookup.getDataSource(uunlv6JndiName);
//    }
//
//    @Bean(name = "UUNL36", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource uunl36DataSource() {
//        return lookup.getDataSource(uunl36JndiName);
//    }
//
//
//
//    // For QA Db Instances
//    @Bean(name = "UUNL56", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource uunl56DataSource() {
//        return lookup.getDataSource(uunl56JndiName);
//    }
//
//    @Bean(name = "TUNL86", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource tunl86DataSource() {
//        return lookup.getDataSource(tunl86JndiName);
//    }
//
//    @Bean(name = "DUNL56", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource dunl56DataSource() {
//        return lookup.getDataSource(dunl56JndiName);
//    }
//
//    @Bean(name = "UUNL16", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource uunl16DataSource() {
//        return lookup.getDataSource(uunl16JndiName);
//    }
//
//    @Bean(name = "UUNL46", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource uunl46DataSource() {
//        return lookup.getDataSource(uunl46JndiName);
//    }
//
//    @Bean(name = "SUNLV6", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource sunlv6DataSource() {
//        return lookup.getDataSource(sunlv6JndiName);
//    }
//
//
//
//    // For RT DB Instances
//    @Bean(name = "UUNL76", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource uunl76DataSource() {
//        return lookup.getDataSource(uunl76JndiName);
//    }
//
//    @Bean(name = "SUNL36", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource sunl36DataSource() {
//        return lookup.getDataSource(sunl36JndiName);
//    }
//
//    @Bean(name = "SUNL26", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource sunl26DataSource() {
//        return lookup.getDataSource(sunl26JndiName);
//    }
//
//    @Bean(name = "SUNL56", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource sunl56DataSource() {
//        return lookup.getDataSource(sunl56JndiName);
//    }
//
//    @Bean(name = "UUNL26", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
//    public DataSource uunl26DataSource() {
//        return lookup.getDataSource(uunl26JndiName);
//    }
//
//
//    // JDBC Template for Dev Instances
//
//    @Primary
//    @Bean(name = "uunl86JdbcTemplate")
//    public JdbcTemplate uunl86JdbcTemplate(@Qualifier("UUNL86")DataSource uunl86DataSource) {
//        return new JdbcTemplate(uunl86DataSource);
//    }
//
//    @Bean(name = "tunl76JdbcTemplate")
//    public JdbcTemplate tunl76JdbcTemplate(@Qualifier("TUNL76") DataSource tunl76DataSource) {
//        return new JdbcTemplate(tunl76DataSource);
//    }
//
//    @Bean(name = "dunl46JdbcTemplate")
//    public JdbcTemplate dunl46JdbcTemplate(@Qualifier("DUNL46") DataSource dunl46DataSource) {
//        return new JdbcTemplate(dunl46DataSource);
//    }
//
//    @Bean(name = "uunlv6JdbcTemplate")
//    public JdbcTemplate uunlv6JdbcTemplate(@Qualifier("UUNLV6") DataSource uunlv6DataSource) {
//        return new JdbcTemplate(uunlv6DataSource);
//    }
//
//
//    @Bean(name = "uunl36JdbcTemplate")
//    public JdbcTemplate uunl36JdbcTemplate(@Qualifier("UUNL36") DataSource uunl36DataSource) {
//        return new JdbcTemplate(uunl36DataSource);
//    }
//    // JDBC Template for QA Instances
//
//    @Bean(name = "uunl56JdbcTemplate")
//    public JdbcTemplate uunl56JdbcTemplate(@Qualifier("UUNL56")DataSource uunl56DataSource) {
//        return new JdbcTemplate(uunl56DataSource);
//    }
//
//    @Bean(name = "tunl86JdbcTemplate")
//    public JdbcTemplate tunl86JdbcTemplate(@Qualifier("TUNL86") DataSource tunl86DataSource) {
//        return new JdbcTemplate(tunl86DataSource);
//    }
//
//    @Bean(name = "tunl86NamedParamJdbcTemplate")
//    public NamedParameterJdbcTemplate tunl86NamedParamJdbcTemplate(@Qualifier("TUNL86") DataSource tunl86DataSource) {
//        return new NamedParameterJdbcTemplate(tunl86DataSource);
//    }
//
//    @Bean(name = "dunl56JdbcTemplate")
//    public JdbcTemplate dunl56JdbcTemplate(@Qualifier("DUNL56") DataSource dunl56DataSource) {
//        return new JdbcTemplate(dunl56DataSource);
//    }
//
//    @Bean(name = "uunl16JdbcTemplate")
//    public JdbcTemplate uunl16JdbcTemplate(@Qualifier("UUNL16") DataSource uunl16DataSource) {
//        return new JdbcTemplate(uunl16DataSource);
//    }
//
//
//    @Bean(name = "uunl46JdbcTemplate")
//    public JdbcTemplate uunl46JdbcTemplate(@Qualifier("UUNL46") DataSource uunl46DataSource) {
//        return new JdbcTemplate(uunl46DataSource);
//    }
//
//    @Bean(name = "sunlv6JdbcTemplate")
//    public JdbcTemplate sunlv6JdbcTemplate(@Qualifier("SUNLV6") DataSource sunlv6DataSource) {
//        return new JdbcTemplate(sunlv6DataSource);
//    }
//    // JDBC Template for RT Instances
//
//    @Bean(name = "uunl76JdbcTemplate")
//    @Primary
//    public JdbcTemplate uunl76JdbcTemplate(@Qualifier("UUNL76")DataSource uunl76DataSource) {
//        return new JdbcTemplate(uunl76DataSource);
//    }
//
//    @Bean(name = "sunl36JdbcTemplate")
//    public JdbcTemplate sunl36JdbcTemplate(@Qualifier("SUNL36") DataSource sunl36DataSource) {
//        return new JdbcTemplate(sunl36DataSource);
//    }
//
//    @Bean(name = "sunl26JdbcTemplate")
//    public JdbcTemplate sunl26JdbcTemplate(@Qualifier("SUNL26") DataSource sunl26DataSource) {
//        return new JdbcTemplate(sunl26DataSource);
//    }
//
//    @Bean(name = "sunl56JdbcTemplate")
//    public JdbcTemplate sunl56JdbcTemplate(@Qualifier("SUNL56") DataSource sunl56DataSource) {
//        return new JdbcTemplate(sunl56DataSource);
//    }
//
//
//    @Bean(name = "uunl26JdbcTemplate")
//    public JdbcTemplate uunl26JdbcTemplate(@Qualifier("UUNL26") DataSource uunl26DataSource) {
//        return new JdbcTemplate(uunl26DataSource);
//    }

}