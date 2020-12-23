package com.example.bootk8sgoogleiastdemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(prefix = "google.recaptcha.key")
@Data
public class CaptchaSettings {

    private String site;
    private String secret;

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3 * 1000);
        factory.setReadTimeout(7 * 1000);
        return factory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        return restTemplate;
    }

}
