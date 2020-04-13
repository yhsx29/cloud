package com.slf.cloud.parent.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
        "com.slf.**.controller",
        "com.slf.**.service",
        "com.slf.**.mapper",
        "com.slf.**.dao",
        "com.slf.**.comps",
        "com.slf.**.servlet",
})
public class ParentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParentApplication.class, args);
    }

}
