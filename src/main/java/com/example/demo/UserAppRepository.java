package com.example.demo;

import java.util.Optional;

import com.example.data.Users;

import org.apache.catalina.User;
import  org.springframework.data.mongodb.repository.MongoRepository;
import  org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepository extends MongoRepository<Users, Integer>   
{   
    @Query("{cedula: ?0},{password: ?1}")
    Users findByCedulaAndPassword(int cedula,String password);

    @Query("{email: ?0}")
    Users findByEmail(String email);

    @Query("{cedula: ?0}")
    Users findByCedula(int cedula);
} 