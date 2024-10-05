package com.vendas.vendas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class EnvConfig {

    @Value("${JWT_SECRET_KEY}")
    private String jwtSecretKey;

    @Value("${MYSQL_USER}")
    private String dbUsername;

    @Value("${MYSQL_PASSWORD:defaultPassword}")
    private String dbPassword;

    // Getters
    public String getJwtSecretKey() {
        return jwtSecretKey;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}