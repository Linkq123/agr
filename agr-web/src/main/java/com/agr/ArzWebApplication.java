package com.agr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class ArzWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArzWebApplication.class, args);
    }

}
