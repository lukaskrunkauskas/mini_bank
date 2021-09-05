package com.fleetbankis.fleetbankis.data;

import com.fleetbankis.fleetbankis.data.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {
}