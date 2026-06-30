package org.java.connectors;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.annotations.Component;

public class ProductRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("file:input")
                .to("csvjson://convert")
                .to("file:output");
    }
}