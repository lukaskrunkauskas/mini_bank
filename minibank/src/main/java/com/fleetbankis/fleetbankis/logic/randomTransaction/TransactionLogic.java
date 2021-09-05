package com.fleetbankis.fleetbankis.logic.randomTransaction;

import com.fleetbankis.fleetbankis.bank.BankService;
import com.fleetbankis.fleetbankis.client.ClientService;
import com.fleetbankis.fleetbankis.data.model.Banks;
import com.fleetbankis.fleetbankis.data.model.Clients;
import com.fleetbankis.fleetbankis.data.model.Transactions;
import com.fleetbankis.fleetbankis.logic.Calculator;
import com.fleetbankis.fleetbankis.transaction.TransactionService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Component
public class TransactionLogic {

    private final ClientService clientService;
    private final TransactionService transactionService;
    private final BankService bankService;

    public TransactionLogic(ClientService clientService, TransactionService transactionService, BankService bankService) {
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.bankService = bankService;
    }

    public void randomTransaction() {

        Clients sender = getRandomClient();
        Clients receiver = getRandomClient();

        while (sender.getId().equals(receiver.getId())) {
            receiver = getRandomClient();
        }
        BigDecimal amount = Calculator.divide(Calculator.multiply
                (BigDecimal.valueOf(getRandomNumber(10, 30)), sender.getCash()), BigDecimal.valueOf(100));
        BigDecimal bankProfit = Calculator.divide(Calculator.multiply
                (BigDecimal.valueOf(10), amount), BigDecimal.valueOf(100));

        if (!sender.getBank().getId().equals(receiver.getBank().getId())) {
            addBankProfit(sender, bankProfit, 2);
            addBankProfit(receiver, bankProfit, 2);
            createTransaction(sender, receiver, Calculator.subtract
                    (amount, bankProfit), sender.getBank(), Calculator.divide
                    (bankProfit, BigDecimal.valueOf(2)), java.time.Instant.now().toString());
            createTransaction(sender, receiver, Calculator.subtract
                    (amount, bankProfit), receiver.getBank(), Calculator.divide
                    (bankProfit, BigDecimal.valueOf(2)), java.time.Instant.now().toString());
        } else {
            addBankProfit(sender, bankProfit, 1);
            createTransaction(sender, receiver, Calculator.subtract
                    (amount, bankProfit), receiver.getBank(), bankProfit, java.time.Instant.now().toString());
        }
        clientService.updateCash(sender, Calculator.subtract(sender.getCash(), amount));
        clientService.updateCash(receiver, Calculator.add(receiver.getCash(), amount));
    }

    public Clients getRandomClient() {
        Random rand = new Random();
        List<Long> idList = clientService.getAllId();
        int randomIndex = rand.nextInt(idList.size());
        Long randomElement = idList.get(randomIndex);
        return clientService.singleClient(randomElement);
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void createTransaction(Clients sender, Clients receiver, BigDecimal amount,
                                  Banks bank, BigDecimal bankProfit, String txTime) {
        Transactions transaction = new Transactions(sender, receiver, amount, bank, bankProfit, txTime);
        transactionService.create(transaction);
    }

    public void addBankProfit(Clients client, BigDecimal bankProfit, int bankNumber) {
        bankService.updateProfit(client.getBank(), Calculator.add(client.getBank().getProfit(), Calculator.divide
                (bankProfit, BigDecimal.valueOf(bankNumber))));
    }

}
