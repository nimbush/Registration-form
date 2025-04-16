package com.codehimalaya.registrationform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.codehimalaya.registrationform.form.mybatis;")
public class RegistrationFormApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistrationFormApplication.class, args);
    }

}
