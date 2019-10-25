package com.spring.connectdb.connectdb.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class ReceiverProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");

        Calendar now = Calendar.getInstance();

        String date = simpleDateFormat.format(now.getTime());
        int randomInt = ThreadLocalRandom.current().nextInt(1, 501);

        exchange.getIn().setHeader(Exchange.FILE_NAME, "Ordack_" + randomInt + "_" + date + ".json");
        System.out.println("Processed!");
    }
}
