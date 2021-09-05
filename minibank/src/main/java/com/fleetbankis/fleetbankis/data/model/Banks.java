package com.fleetbankis.fleetbankis.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "banks")
public class Banks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal profit;
    @JsonIgnore
    @OneToMany(mappedBy = "bank")
    private List<Clients> client;
    @JsonIgnore
    @OneToMany(mappedBy = "bank")
    private List<Transactions> transaction;

    public Banks() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public List<Clients> getClient() {
        return client;
    }

    public void setClient(List<Clients> client) {
        this.client = client;
    }

    public List<Transactions> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transactions> transaction) {
        this.transaction = transaction;
    }
}
