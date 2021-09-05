package com.fleetbankis.fleetbankis.data;

import com.fleetbankis.fleetbankis.data.model.Banks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Banks, Long> {
}