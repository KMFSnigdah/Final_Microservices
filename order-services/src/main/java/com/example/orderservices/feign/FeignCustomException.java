package com.example.orderservices.feign;

import feign.Body;
import feign.Response;
import org.springframework.http.HttpStatus;

public class FeignCustomException extends RuntimeException {
    private final HttpStatus statusCode;
    private final String responseBody;

    public FeignCustomException(HttpStatus statusCode, String responseBody) {
        super("Feign error: " + statusCode + ", Response: " + responseBody);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
