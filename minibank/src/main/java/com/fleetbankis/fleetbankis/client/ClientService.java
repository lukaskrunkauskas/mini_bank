package com.fleetbankis.fleetbankis.client;

import com.fleetbankis.fleetbankis.bank.BankService;
import com.fleetbankis.fleetbankis.data.ClientRepository;
import com.fleetbankis.fleetbankis.data.model.Banks;
import com.fleetbankis.fleetbankis.data.model.Clients;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final BankService bankService;

    public ClientService(ClientRepository clientRepository, BankService bankService) {
        this.clientRepository = clientRepository;
        this.bankService = bankService;
    }

    public List<Clients> clients() {
        return clientRepository.findAll();
    }

    public Clients singleClient(Long id) {
        return clientRepository.findById(id).get();
    }

    public List<Clients> bankClients(Long id) {
        Banks bank = bankService.singleBank(id).get();
        return bank.getClient();
    }

    public void update(Long id, Clients client) {
        Optional<Clients> oldClient = clientRepository.findById(id);

        Clients newClient = oldClient.get();
        newClient.setName(client.getName());
        newClient.setSurname(client.getSurname());
        newClient.setBank((client.getBank()));
        newClient.setCash((client.getCash()));
        clientRepository.save(newClient);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public void create(Clients client) {
        clientRepository.save(client);
    }

    public List<Long> getAllId() {
        List<Long> clientIds;
        clientIds = clients().stream().map(Clients::getId).collect(Collectors.toList());
        return clientIds;
    }

    public void updateCash(Clients client, BigDecimal newCash) {
        client.setCash(newCash);
        clientRepository.save(client);
    }
}

