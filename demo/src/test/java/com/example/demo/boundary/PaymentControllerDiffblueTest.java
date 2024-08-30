package com.example.demo.boundary;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.demo.control.impl.PaymentService;
import com.example.demo.entity.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PaymentController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PaymentControllerDiffblueTest {
  @Autowired
  private PaymentController paymentController;

  @MockBean
  private PaymentService paymentService;

  /**
   * Method under test: {@link PaymentController#getAllPayments()}
   */
  @Test
  void testGetAllPayments() throws Exception {
    // Arrange
    when(paymentService.getAllPayments()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/payments");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(paymentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link PaymentController#getPaymentById(Long)}
   */
  @Test
  void testGetPaymentById() throws Exception {
    // Arrange
    Optional<Payment> ofResult = Optional.of(new Payment());
    when(paymentService.getPaymentById(Mockito.<Long>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/payments/{id}", 1L);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(paymentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string("{\"id\":null,\"payer\":null,\"payee\":null,\"amount\":null,\"currency\":null}"));
  }

  /**
   * Method under test: {@link PaymentController#getPaymentById(Long)}
   */
  @Test
  void testGetPaymentById2() throws Exception {
    // Arrange
    when(paymentService.getAllPayments()).thenReturn(new ArrayList<>());
    Optional<Payment> ofResult = Optional.of(new Payment());
    when(paymentService.getPaymentById(Mockito.<Long>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/api/payments/{id}", "",
        "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(paymentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link PaymentController#createPayment(Payment)}
   */
  @Test
  void testCreatePayment() throws Exception {
    // Arrange
    when(paymentService.createPayment(Mockito.<Payment>any())).thenReturn(new Payment());
    MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/api/payments")
        .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder = contentTypeResult
        .content(objectMapper.writeValueAsString(new Payment()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(paymentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string("{\"id\":null,\"payer\":null,\"payee\":null,\"amount\":null,\"currency\":null}"));
  }

  /**
   * Method under test: {@link PaymentController#updatePayment(Long, Payment)}
   */
  @Test
  void testUpdatePayment() throws Exception {
    // Arrange
    when(paymentService.updatePayment(Mockito.<Long>any(), Mockito.<Payment>any())).thenReturn(new Payment());
    MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/v1/api/payments/{id}", 1L)
        .contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder = contentTypeResult
        .content(objectMapper.writeValueAsString(new Payment()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(paymentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string("{\"id\":null,\"payer\":null,\"payee\":null,\"amount\":null,\"currency\":null}"));
  }

  /**
   * Method under test: {@link PaymentController#deletePayment(Long)}
   */
  @Test
  void testDeletePayment() throws Exception {
    // Arrange
    doNothing().when(paymentService).deletePayment(Mockito.<Long>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/api/payments/{id}", 1L);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(paymentController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  /**
   * Method under test: {@link PaymentController#deletePayment(Long)}
   */
  @Test
  void testDeletePayment2() throws Exception {
    // Arrange
    doNothing().when(paymentService).deletePayment(Mockito.<Long>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/api/payments/{id}", 1L);
    requestBuilder.contentType("https://example.org/example");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(paymentController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
  }
}
