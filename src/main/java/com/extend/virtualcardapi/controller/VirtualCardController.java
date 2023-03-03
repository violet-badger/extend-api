package com.extend.virtualcardapi.controller;

import com.extend.virtualcardapi.models.Transaction;
import com.extend.virtualcardapi.models.VirtualCard;
import com.extend.virtualcardapi.service.TransactionService;
import com.extend.virtualcardapi.service.VirtualCardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping("virtualcard")
public class VirtualCardController {

    @Autowired
    private VirtualCardService virtualCardService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<VirtualCard[]> getVirtualCard() {
        return new ResponseEntity<>(virtualCardService.getVirtualCard(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/transactions", produces = "application/json")
    public ResponseEntity<Transaction[]> getTransactions(@PathVariable String id) {
        return new ResponseEntity<>(transactionService.getVirtualCardTransactions(id), HttpStatus.OK);
    }

}
