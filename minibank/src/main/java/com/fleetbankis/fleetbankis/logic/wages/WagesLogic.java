package com.fleetbankis.fleetbankis.logic.wages;

import com.fleetbankis.fleetbankis.ToExcel;
import com.fleetbankis.fleetbankis.bank.BankService;
import com.fleetbankis.fleetbankis.client.ClientService;
import com.fleetbankis.fleetbankis.logic.Calculator;
import com.fleetbankis.fleetbankis.transaction.TransactionService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WagesLogic {

    private final ClientService clientService;
    private final BankService bankService;
    private final TransactionService transactionService;

    public WagesLogic(ClientService clientService, BankService bankService, TransactionService transactionService) {
        this.clientService = clientService;
        this.bankService = bankService;
        this.transactionService = transactionService;
    }

    public void payWages() {
        clientService.clients().forEach(client ->
                clientService.updateCash(client, Calculator.add(client.getCash(), client.getBank().getProfit())));
    }

    public void resetProfit() {
        bankService.banks().forEach(bank ->
                bankService.updateProfit(bank, BigDecimal.ZERO));
    }

    public void allExcels() {
        bankService.banks().forEach(bank -> ToExcel.excelGenerator(bank.getId()));
    }

    public void clearTransactions() {
        transactionService.deleteAll();
    }
}
