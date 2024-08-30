package com.example.demo.exception;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class GlobalExceptionHandlerDiffblueTest {
    /**
     * Method under test:
     * {@link GlobalExceptionHandler#handleResourceNotFoundException(ResourceNotFoundException, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleResourceNotFoundException() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.demo.exception.ResourceNotFoundException.getMessage()" because "ex" is null
        //       at com.example.demo.exception.GlobalExceptionHandler.handleResourceNotFoundException(GlobalExceptionHandler.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

        // Act
        globalExceptionHandler.handleResourceNotFoundException(null, new ServletWebRequest(new MockHttpServletRequest()));
    }
}
