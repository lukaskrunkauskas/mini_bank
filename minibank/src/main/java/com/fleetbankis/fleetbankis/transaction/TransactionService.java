package com.fleetbankis.fleetbankis.transaction;

import com.fleetbankis.fleetbankis.bank.BankService;
import com.fleetbankis.fleetbankis.client.ClientService;
import com.fleetbankis.fleetbankis.data.TransactionRepository;
import com.fleetbankis.fleetbankis.data.model.Banks;
import com.fleetbankis.fleetbankis.data.model.Clients;
import com.fleetbankis.fleetbankis.data.model.Transactions;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ClientService clientService;
    private final BankService bankService;

    public TransactionService(TransactionRepository transactionRepository, ClientService clientService, BankService bankService) {
        this.transactionRepository = transactionRepository;
        this.clientService = clientService;
        this.bankService = bankService;
    }

    public void create(Transactions transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transactions> singleClient(Long id) {
        Clients client = clientService.singleClient(id);
        return client.getTransaction();
    }

    public List<Transactions> singleBank(Long id) {
        Banks bank = bankService.singleBank(id).get();
        return bank.getTransaction();
    }

    public void deleteAll() {
        transactionRepository.deleteAll();
    }
}
