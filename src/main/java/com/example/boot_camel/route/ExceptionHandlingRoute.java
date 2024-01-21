package com.example.boot_camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandlingRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:exceptionHandlerRoute")
                .process(exchange -> {
                   RuntimeException exception = exchange.getException(RuntimeException.class);
                   // store it in DB and Reply
                }).end();
    }
}
