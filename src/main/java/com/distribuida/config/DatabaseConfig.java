package com.distribuida.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.sql.DataSource;

@ApplicationScoped
public class DatabaseConfig {

    @Inject
    @ConfigProperty(name = "db.user")
    String dbUser;
    @Inject
    @ConfigProperty(name = "db.password")
    String dbPassword;
    @Inject
    @ConfigProperty(name = "db.url")
    String dbUrl;


    @Produces
    @ApplicationScoped
    public DataSource dataSource(){
        HikariDataSource ds= new HikariDataSource();
        ds.setUsername(dbUser);
        ds.setPassword(dbPassword);
        ds.setJdbcUrl(dbUrl);

        return ds;
    }

}
