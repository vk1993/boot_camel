package com.example.boot_camel.route;

import com.example.boot_camel.model.InquirePayloadDto;
import com.example.boot_camel.processor.HAPInquireServiceProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(RuntimeException.class)
                .log(LoggingLevel.ERROR, "Failed to Store item")
                .to("direct:exceptionHandlerRoute").end();


        from("direct:convertAndStore")
                .routeId("convertAndStore_Id")
            .process(exchange -> {
                // Convert JSON to SOAP
                InquirePayloadDto inquirePayload = exchange.getIn().getBody(InquirePayloadDto.class);
//                InquirePayloadDto inquirePayload = new InquirePayloadDto("123214","01/12/1993");
                exchange.setProperty("jsonPayload", inquirePayload);
                String xmlBody = String.format("<params hapIdValue=\"%s\" dateOfBirthValue=\"%s\" initiatedByValue=\"%s\" npiValue=\"%s\"/>",
                        inquirePayload.getId(), inquirePayload.getPersonBirthDate(), "calheers", "NPI");
                exchange.getIn().setBody(xmlBody);
            }).to("xslt:classpath:soapRequest.xslt")
                .log(LoggingLevel.INFO,"Generated SOAP Request: ${body}")// Log the response
                .process(exchange -> {
                    exchange.getIn().setBody(exchange.getProperty("jsonPayload", InquirePayloadDto.class));
                })
            .end();
    }

    // Implement the methods convertJsonToSoap, storeInDatabase, and makeSoapRequest
    // ...

}