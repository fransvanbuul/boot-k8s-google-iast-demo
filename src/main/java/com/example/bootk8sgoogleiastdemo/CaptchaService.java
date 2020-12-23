package com.example.bootk8sgoogleiastdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class CaptchaService {

    private final CaptchaSettings captchaSettings;
    private final RestTemplate restTemplate;

    private static Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

    public String processResponse(String response, String ip) {
        if(!responseSanityCheck(response)) {
            return "reCaptcha response contains invalid characters";
        }

        URI verifyUri = URI.create(String.format(
                "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s",
                captchaSettings.getSecret(), response, ip));

        GoogleResponse googleResponse = restTemplate.getForObject(verifyUri, GoogleResponse.class);

        if(!googleResponse.isSuccess()) {
           return googleResponse.toString();
        }

        return null;
    }

    private boolean responseSanityCheck(String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

}
