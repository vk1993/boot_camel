package com.example.boot_camel.controller;

import com.example.boot_camel.model.InquirePayloadDto;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ApiController {

    @Autowired
    private ProducerTemplate producerTemplate;

//    @PostMapping("/api/convertAndStore")
    public String convertAndStore(@RequestBody InquirePayloadDto jsonPayload) {

        // Trigger Camel route
        return producerTemplate.requestBody("direct:convertAndStore", jsonPayload.toString(),String.class);
    }
}