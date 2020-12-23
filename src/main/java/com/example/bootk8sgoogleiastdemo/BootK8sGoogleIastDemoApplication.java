package com.example.bootk8sgoogleiastdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootK8sGoogleIastDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootK8sGoogleIastDemoApplication.class, args);
    }

}
