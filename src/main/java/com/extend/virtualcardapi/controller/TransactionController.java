package com.extend.virtualcardapi.controller;

import com.extend.virtualcardapi.models.Transaction;
import com.extend.virtualcardapi.service.TransactionService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transaction/{id}", produces = "application/json")
    public ResponseEntity<Transaction> getTransaction(@PathVariable("id") String id) {
        return new ResponseEntity<>(transactionService.getTransaction(id), HttpStatus.OK);
    }
}
