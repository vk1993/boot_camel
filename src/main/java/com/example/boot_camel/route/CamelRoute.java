package com.example.boot_camel.route;

import com.example.boot_camel.model.InquirePayloadDto;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("jetty")
                .bindingMode(RestBindingMode.auto);


        from("direct:convertAndStore")
                .routeId("convertAndStore_Id")
            .process(exchange -> {
                // Convert JSON to SOAP
                String jsonPayload = exchange.getIn().getBody(String.class);
                InquirePayloadDto data = new InquirePayloadDto("123214","01/12/1993");
                exchange.getIn().setBody(data);

//                String soapMessage = convertJsonToSoap(jsonPayload);
//
//                // Store in database
//                Long requestId = storeInDatabase(soapMessage, jsonPayload);
//
//                // Make SOAP request
//                String response = makeSoapRequest(soapMessage);

                // Set the response to the Camel exchange
                exchange.getMessage().setBody(jsonPayload);
            })
            .to("log:output") // Log the response
            .end();
    }

    // Implement the methods convertJsonToSoap, storeInDatabase, and makeSoapRequest
    // ...

}