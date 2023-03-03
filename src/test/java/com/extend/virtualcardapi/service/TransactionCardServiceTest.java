package com.extend.virtualcardapi.service;

import com.extend.virtualcardapi.client.ExtendClient;
import com.extend.virtualcardapi.models.Transaction;
import com.extend.virtualcardapi.models.VirtualCard;
import com.extend.virtualcardapi.models.response.VirtualCardResponse;
import com.extend.virtualcardapi.models.response.VirtualCardTransactionResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionCardServiceTest {
    private ExtendClient extendClient = mock(ExtendClient.class);
    private TransactionService transactionService = new TransactionService(extendClient);

    @Test
    public void testGetVirtualCardTransactions() {
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

        VirtualCardTransactionResponse virtualCardTransactionResponse = VirtualCardTransactionResponse.builder()
                .transactions(transactions)
                .build();
        when(extendClient.getTransactions(any())).thenReturn(virtualCardTransactionResponse);

        Transaction[] transactionsFromResponse = transactionService.getVirtualCardTransactions("card_id");

        assertThat(transactionsFromResponse[0].getMerchantName().equals("Panda Express"));
        assertThat(transactionsFromResponse[1].getMerchantName().equals("Five Guys"));

    }
}
