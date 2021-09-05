package com.fleetbankis.fleetbankis.client;

import com.fleetbankis.fleetbankis.Timers;
import com.fleetbankis.fleetbankis.data.model.Banks;
import com.fleetbankis.fleetbankis.data.model.Clients;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private final Timers timers;

    public ClientController(ClientService clientService, Timers timers) {
        this.clientService = clientService;
        this.timers = timers;
    }

    @GetMapping
    public List<Clients> getClients() {
        return clientService.clients();
    }

    @GetMapping("/{id}")
    public Clients singleClient(@PathVariable Long id) {
        return clientService.singleClient(id);
    }

    @GetMapping("/start")
    public void startApp() {
        timers.transactionTimer();
        timers.wagesTimer();
    }

    @GetMapping("/bank/{id}")
    public List<Clients> getBankClients(@PathVariable Long id) {
        return clientService.bankClients(id);
    }

    @PutMapping("/{id}")
    public void updateClient(@PathVariable Long id, @RequestBody Clients client) {
        clientService.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.delete(id);
    }

    @PostMapping
    public void insertClient(@RequestBody Clients client) {
        clientService.create(client);
    }
}
