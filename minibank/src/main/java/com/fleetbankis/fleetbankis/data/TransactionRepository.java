package com.fleetbankis.fleetbankis.data;

import com.fleetbankis.fleetbankis.data.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
}
