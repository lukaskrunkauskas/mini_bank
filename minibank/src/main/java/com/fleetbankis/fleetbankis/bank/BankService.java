package com.fleetbankis.fleetbankis.bank;

import com.fleetbankis.fleetbankis.data.BankRepository;
import com.fleetbankis.fleetbankis.data.model.Banks;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Banks> banks() {
        return bankRepository.findAll();
    }

    public Optional<Banks> singleBank(Long id) {
        return bankRepository.findById(id);
    }

    public void create(Banks bank) {
        bankRepository.save(bank);
    }

    public void delete(Long id) {
        bankRepository.deleteById(id);
    }

    public void updateProfit(Banks bank, BigDecimal newProfit) {
        bank.setProfit(newProfit);
        bankRepository.save(bank);
    }
}