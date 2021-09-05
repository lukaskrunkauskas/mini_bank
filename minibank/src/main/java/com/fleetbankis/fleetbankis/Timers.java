package com.fleetbankis.fleetbankis;

import com.fleetbankis.fleetbankis.logic.wages.WagesTask;
import com.fleetbankis.fleetbankis.logic.randomTransaction.TransactionLogic;
import com.fleetbankis.fleetbankis.logic.randomTransaction.TransactionTask;
import com.fleetbankis.fleetbankis.logic.wages.WagesLogic;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class Timers {

    private final TransactionLogic transactionLogic;
    private final WagesLogic wagesLogic;

    public Timers(TransactionLogic transactionLogic, WagesLogic wagesLogic) {
        this.transactionLogic = transactionLogic;
        this.wagesLogic = wagesLogic;
    }

    public void transactionTimer() {
        TimerTask transactionTask = new TransactionTask(transactionLogic);
        Timer timer = new Timer();
        timer.schedule(transactionTask, 10000, 10000);
    }

    public void wagesTimer() {
        TimerTask wagesTask = new WagesTask(wagesLogic);
        Timer timer = new Timer();
        timer.schedule(wagesTask, 120000, 120000);
    }
}