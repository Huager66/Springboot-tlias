package org.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("org.example.mapper")
@SpringBootApplication
public class TliasWebMangementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebMangementApplication.class, args);
    }

}
