package com.evan.sj;

import org.jasypt.spring.security.PasswordEncoder;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SjApplication.class, args);
    }

}
