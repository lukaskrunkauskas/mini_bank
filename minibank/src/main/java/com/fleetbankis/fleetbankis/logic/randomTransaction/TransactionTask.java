package com.fleetbankis.fleetbankis.logic.randomTransaction;

import java.util.TimerTask;

public class TransactionTask extends TimerTask {
    private final TransactionLogic transactionLogic;

    public TransactionTask(TransactionLogic transactionLogic) {
        this.transactionLogic = transactionLogic;
    }

    public void run() {
        transactionLogic.randomTransaction();
    }
}
