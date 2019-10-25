package com.spring.connectdb.connectdb.services;

import com.spring.connectdb.connectdb.model.User;
import com.spring.connectdb.connectdb.repository.Rrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sservice {

    @Autowired
    Rrepository rep;

    public List<User> getValAll(){
        return rep.findAll();
    }

    public User getUser(int i){
            List<User> l = getValAll();
        for(User account : l) {
            if(account.getId() == i) {
                return account;
            }
         }
        return null;

    }

    public void addUser(User u){
        if(getUser(u.getId())!=null){
            throw new UnsupportedOperationException("User Exist");
        }
        rep.save(u);
    }

    public void deleteUser(int id){rep.delete(this.getUser(id));}

    public void updateUser(User u, int toBeDeleted){
        rep.deleteById(toBeDeleted);
        this.addUser(u);
    }
}
