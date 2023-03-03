package com.extend.virtualcardapi.controller;

import com.extend.virtualcardapi.models.Transaction;
import com.extend.virtualcardapi.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController = new TransactionController();

    @Mock
    private TransactionService transactionService;

    @Test
    public void testGetTransaction() {

        Transaction transaction = Transaction.builder()
                .id("123")
                .cardholderName("Thinh")
                .merchantName("Panda Express")
                .build();
        when(transactionService.getTransaction(any())).thenReturn(transaction);
        ResponseEntity<Transaction> responseEntity = transactionController.getTransaction("uuid1");
        Transaction transactionFromResponse = responseEntity.getBody();

        assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
        assertThat(transactionFromResponse.getMerchantName().equals(transaction.getMerchantName()));
    }
}
