package com.spring.connectdb.connectdb.route;

import com.spring.connectdb.connectdb.processor.AddProcess;
import com.spring.connectdb.connectdb.processor.MessageProcessor;
import com.spring.connectdb.connectdb.processor.ReceiverProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class TheRoute extends RouteBuilder {

    static final String mqOut = "rabbitmq://localhost:5672/mytest?routingKey=camel&queue=myqueue&autoDelete=false";
    static final String mqIn = "rabbitmq://localhost:5672/mytest?routingKey=camel&queue=myqueue&autoDelete=false";
    LocalTime date = LocalTime.now();
    String outL =( "file:outPutFolder");

    @Override
    public void configure() throws Exception {
        //from("file:inputFolder").process(new FileProcessor()).to(mqOut);
        from("direct:start").process(new MessageProcessor()).to(mqOut);

        from("direct:add").process(new AddProcess()).to(mqOut);

        from(mqIn).process(new ReceiverProcessor()).to(outL);
    }
}
