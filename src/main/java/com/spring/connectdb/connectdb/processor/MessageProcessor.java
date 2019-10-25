package com.spring.connectdb.connectdb.processor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.connectdb.connectdb.model.User;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

public class MessageProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<User> l = exchange.getIn().getBody(List.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsn = gson.toJson(l);
        exchange.getOut().setBody(jsn);
        exchange.getOut().setHeader("JSON MESSAGE","JSON MESSAGE");
    }
}
