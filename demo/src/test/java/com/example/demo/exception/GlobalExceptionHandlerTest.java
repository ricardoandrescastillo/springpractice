package com.example.demo.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandlerTest {


    @Test
    void givenBadIdWhenResourceNotFoundExceptionThenThroughtError(){

        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException("error");
        WebRequest webRequest = new ServletWebRequest(new MockHttpServletRequest());
        ResponseEntity<Object> responseEntity =
                globalExceptionHandler.handleResourceNotFoundException(resourceNotFoundException, webRequest);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

    }
}
