package com.example.orderservices.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class CustomFeignErrorDecoder {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder() {
            @Override
            public Exception decode(String methodKey, Response response) {
                HttpStatus statusCode = HttpStatus.valueOf(response.status());
                String responseBody = response.body() != null ? response.body().toString() : "";

                // Create a custom exception with the status code and response body
                return new FeignCustomException(statusCode, responseBody);
            }
        };
    }
}
