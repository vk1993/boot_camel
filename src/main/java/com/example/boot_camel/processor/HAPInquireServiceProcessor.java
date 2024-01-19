package com.example.boot_camel.processor;

import com.example.boot_camel.model.InquirePayloadDto;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class HAPInquireServiceProcessor implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {
        InquirePayloadDto inquirePayloadDto = exchange.getIn().getBody(InquirePayloadDto.class);

    }
}
