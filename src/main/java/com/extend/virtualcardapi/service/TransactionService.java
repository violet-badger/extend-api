package com.extend.virtualcardapi.service;

import com.extend.virtualcardapi.client.ExtendClient;
import com.extend.virtualcardapi.models.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransactionService {
    private ExtendClient extendClient;

    public Transaction[] getVirtualCardTransactions(String virtualCardId) {
        return extendClient.getTransactions(virtualCardId).getTransactions();
    }

    public Transaction getTransaction(String transactionId) {
        return extendClient.getTransactionDetails(transactionId);
    }
}
