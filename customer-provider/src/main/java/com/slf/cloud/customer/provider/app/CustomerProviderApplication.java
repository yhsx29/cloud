package com.slf.cloud.customer.provider.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CustomerProviderApplication  {
    public static void main(String[] args) {
        SpringApplication.run(CustomerProviderApplication.class, args);
    }
}
