package com.fleetbankis.fleetbankis.logic.wages;

import java.util.TimerTask;

public class WagesTask extends TimerTask {
    private final WagesLogic wagesLogic;

    public WagesTask(WagesLogic wagesLogic) {
        this.wagesLogic = wagesLogic;
    }

    public void run() {
        wagesLogic.allExcels();
        wagesLogic.payWages();
        wagesLogic.resetProfit();
        wagesLogic.clearTransactions();

    }
}
