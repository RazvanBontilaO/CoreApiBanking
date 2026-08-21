package com.example.banking;

import org.springframework.boot.SpringApplication;

public class TestBankingCoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(BankingCoreApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
