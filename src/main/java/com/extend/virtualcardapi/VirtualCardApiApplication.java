package com.extend.virtualcardapi;

import com.extend.virtualcardapi.client.ExtendClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VirtualCardApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(VirtualCardApiApplication.class, args);
    }

}
