package com.spring.connectdb.connectdb.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AddProcess implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setHeader("Added From: ","User Class");
    }
}
