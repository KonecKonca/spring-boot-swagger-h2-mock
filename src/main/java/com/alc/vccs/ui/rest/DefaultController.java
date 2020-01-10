package com.alc.vccs.ui.rest;

import com.alc.vccs.ui.model.Client;
import com.alc.vccs.ui.model.Clients;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class DefaultController {

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Client findClientById() {
        return Clients.getEmptyClient();
    }

}
