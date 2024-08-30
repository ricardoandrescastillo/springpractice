package com.example.demo.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResourceNotFoundExceptionTest {


    @Test
    void givenExceptionwhenNewResourceNotFoundExceptionThenNewException(){

        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException("message");
        Assertions.assertEquals("message", resourceNotFoundException.getMessage());
    }
}
