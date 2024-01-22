package com.example.boot_camel.processor;

import com.example.boot_camel.model.HapId;
import com.example.boot_camel.model.InquireMemberRequest;
import com.example.boot_camel.model.InquirePayloadDto;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class HAPInquireServiceProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        InquirePayloadDto inquirePayloadDto = exchange.getIn().getBody(InquirePayloadDto.class);

        try {
            InquireMemberRequest xmlPayload = convertJsonToSoap(inquirePayloadDto);
            exchange.getIn().setBody(xmlPayload);
        }catch (RuntimeException ignored) {
            throw new RuntimeException("Parsing Exception");
        }
    }

    private InquireMemberRequest convertJsonToSoap(InquirePayloadDto inquirePayloadDto) {


        // Create SOAP Request object for say

        InquireMemberRequest inquireMemberRequest = new InquireMemberRequest();
        inquireMemberRequest.setHapId(new HapId(inquirePayloadDto.getId()));
        /// do setup other fields

        return inquireMemberRequest;
    }
}
