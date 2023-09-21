package com.twentyfive.linktreeapilayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.twentyfive.authorizationcontroller", "com.twentyfive.linktreeapilayer"})
@SpringBootApplication
@EnableFeignClients
public class LinktreeApiLayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinktreeApiLayerApplication.class, args);
    }

}
