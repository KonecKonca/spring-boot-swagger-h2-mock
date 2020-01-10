package com.alc.vccs.ui.rest;

import com.alc.vccs.ui.dto.ClientDto;
import com.alc.vccs.ui.model.Client;
import com.alc.vccs.ui.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping(value = "save", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Client> saveClients(@Valid @RequestBody List<ClientDto> clientDto) {
        return clientService.saveClients(clientDto);
    }

    @PostMapping(value = "delete", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Long> deleteClientsById(@RequestBody List<Long> clientIds) {
        return clientService.deleteClients(clientIds);
    }

    @GetMapping(value = "/{clientId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Client findClientById(@PathVariable("clientId") Long clientId) {
        return clientService.findClientById(clientId);
    }

    @GetMapping(value = "/all/{clientIds}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Client> findAllClientsById(@PathVariable("clientIds") Long[] clientIds,
                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize
    ) {
        return clientService.findAllById(Arrays.asList(clientIds), page, pageSize);
    }

}
