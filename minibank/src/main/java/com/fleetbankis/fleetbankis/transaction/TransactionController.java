package com.fleetbankis.fleetbankis.transaction;

import com.fleetbankis.fleetbankis.data.model.Transactions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{senderId}")
    public List<Transactions> getClientTransactions(@PathVariable Long senderId) {
        return transactionService.singleClient(senderId);
    }


    @GetMapping("/bank/{bankId}")
    public List<Transactions> getBankTransactions(@PathVariable Long bankId) {
        return transactionService.singleBank(bankId);
    }
}
