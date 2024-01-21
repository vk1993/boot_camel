package com.example.boot_camel.route;

import com.example.boot_camel.model.HAPServiceRequest;
import com.example.boot_camel.service.HAPServiceRequestRepository;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class HAPDBRequestRoute extends RouteBuilder {

    //save body to HAPServiceRequest.getResponse

    @Autowired
    HAPServiceRequestRepository serviceRequestRepository;

    @Override
    public void configure() throws Exception {

        onException(RuntimeException.class)
                .log(LoggingLevel.ERROR, "Failed to Store item")
                        .to("direct:exceptionHandlerRoute").end();

        from("direct:dbrequest_route")
                .routeId("dbrequest_route")
                .process(exchange -> {
                   String requestBody = exchange.getIn().getBody(String.class);
                   // store requestBody to HAPServiceRequest table
                    Long id = exchange.getProperty("requestId", Long.class);

                    serviceRequestRepository.save(new HAPServiceRequest(id,requestBody));
                }).end();
    }

}
