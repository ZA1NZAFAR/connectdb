package com.spring.connectdb.connectdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages="com.spring.connectdb")
@SpringBootApplication
public class ConnectdbApplication {


    public static void main(String[] args) throws Exception {
//        CamelContext cc = new DefaultCamelContext();
//        cc.addRoutes(new TheRoute());
//        cc.start();
        SpringApplication.run(ConnectdbApplication.class, args);

    }

}
