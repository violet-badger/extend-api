package com.extend.virtualcardapi.controller;

import com.extend.virtualcardapi.models.Transaction;
import com.extend.virtualcardapi.models.VirtualCard;
import com.extend.virtualcardapi.service.TransactionService;
import com.extend.virtualcardapi.service.VirtualCardService;
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
public class VirtualCardControllerTest {

    @InjectMocks
    private VirtualCardController virtualCardController = new VirtualCardController();

    @Mock
    private VirtualCardService virtualCardService;

    @Mock
    private TransactionService transactionService;

    @Test
    public void testGetVirtualCard() {
        VirtualCard virtualCard = VirtualCard.builder()
                .balanceCents("5000")
                .displayName("Thinh's Card")
                .id("123")
                .build();

        VirtualCard[] virtualCards = new VirtualCard[1];
        virtualCards[0]= virtualCard;

        when(virtualCardService.getVirtualCard()).thenReturn(virtualCards);
        ResponseEntity<VirtualCard[]> responseEntity = virtualCardController.getVirtualCard();
        VirtualCard[] virtualCardsFromResponse = responseEntity.getBody();

        assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
        assertThat(virtualCardsFromResponse[0].getDisplayName().equals(virtualCards[0].getDisplayName()));
    }

    @Test
    public void testGetTransactions() {
        Transaction firstTransaction = Transaction.builder()
                .id("123")
                .cardholderName("Thinh")
                .merchantName("Panda Express")
                .build();

        Transaction secondTransaction = Transaction.builder()
                .id("123")
                .cardholderName("Thinh")
                .merchantName("Five Guys")
                .build();


        Transaction[] transactions = new Transaction[2];
        transactions[0] = firstTransaction;
        transactions[1] = secondTransaction;

        when(transactionService.getVirtualCardTransactions(any())).thenReturn(transactions);
        ResponseEntity<Transaction[]> responseEntity = virtualCardController.getTransactions("tin's vc id");
        Transaction[] transactionsFromResponse = responseEntity.getBody();

        assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));

        assertThat(transactionsFromResponse[0].getMerchantName().equals("Panda Express"));
        assertThat(transactionsFromResponse[1].getMerchantName().equals("Five Guys"));
    }
}
