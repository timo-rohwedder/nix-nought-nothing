package org.example.nixnoughtnothing;

import org.springframework.boot.SpringApplication;

public class TestNixNoughtNothingApplication {

    public static void main(String[] args) {
        SpringApplication.from(NixNoughtNothingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
