package com.spring.connectdb.connectdb.controller;

import com.spring.connectdb.connectdb.model.User;
import com.spring.connectdb.connectdb.route.TheRoute;
import com.spring.connectdb.connectdb.services.Sservice;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ttable")
public class Controller {

    @Autowired
    private Sservice ser;

    @Autowired
    TheRoute theRoute;

    @Autowired
    ProducerTemplate pt;

    @RequestMapping("/all")
    public List<User> getAllData() throws Exception {
        log.info("Requested all users.");
        try {
            pt.sendBody("direct:start", ser.getValAll());
        } catch (Exception e) {
            System.out.println("ERROR SENDING TO DIRECT:START");
        }
        return ser.getValAll();
    }

    @RequestMapping("/get/{val}")
    public User getUser(@PathVariable int val) {
        //pt.sendBody("direct:start", ser.getUser(val));
        return ser.getUser(val);
    }

    @RequestMapping(value = "/delete/{val}")
    public void deleteUser(@PathVariable int val) {
        try {
            ser.deleteUser(val);
        }catch (Exception e){
            log.warn("Tried deleting non existing user.");
        }
    }

    @PostMapping(value = "/add")
    public void addUser(@RequestBody User val) {
        //pt.sendBody("direct:add",val);
        ser.addUser(val);
    }

    @PutMapping(value = "/update/{id}")
    public void updateUser(@RequestBody User u, @PathVariable int id) {
        ser.updateUser(u, id);
    }


}
