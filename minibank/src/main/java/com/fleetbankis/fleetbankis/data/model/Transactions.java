package com.fleetbankis.fleetbankis.data.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    private Clients sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = false)
    private Clients receiver;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id", nullable = false)
    private Banks bank;
    private BigDecimal bankProfit;
    private String txTime;

    public Transactions() {
        super();
    }

    public Transactions(Clients sender, Clients receiver, BigDecimal amount, Banks bank, BigDecimal bankProfit, String txTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.bank = bank;
        this.bankProfit = bankProfit;
        this.txTime = txTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clients getSender() {
        return sender;
    }

    public void setSender(Clients sender) {
        this.sender = sender;
    }

    public Clients getReceiver() {
        return receiver;
    }

    public void setReceiver(Clients receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBankProfit() {
        return bankProfit;
    }

    public void setBankProfit(BigDecimal bankProfit) {
        this.bankProfit = bankProfit;
    }

    public String getTxTime() {
        return txTime;
    }

    public void setTxTime(String txTime) {
        this.txTime = txTime;
    }

    public Banks getBank() {
        return bank;
    }

    public void setBank(Banks bank) {
        this.bank = bank;
    }
}
