package com.spring.connectdb.connectdb.repository;

import com.spring.connectdb.connectdb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Rrepository extends JpaRepository<User,Integer> {
}
