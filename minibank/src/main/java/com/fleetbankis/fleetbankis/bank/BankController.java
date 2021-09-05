package com.fleetbankis.fleetbankis.bank;

import com.fleetbankis.fleetbankis.data.model.Banks;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ControllerAdvice
@RestController
@RequestMapping("/api/banks")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public List<Banks> getBanks() {
        return bankService.banks();
    }

    @GetMapping("/{id}")
    public Optional<Banks> getSingle(@PathVariable Long id) {
        return bankService.singleBank(id);
    }

    @PostMapping
    public void insertBank(@RequestBody Banks bank) {
        bankService.create(bank);
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable Long id) {
        bankService.delete(id);
    }
}
