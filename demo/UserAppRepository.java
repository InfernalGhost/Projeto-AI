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
    @Query("{nome: ?0},{password: ?1}")
    Users findByNomeAndPassword(String nome,String password);

    @Query("{email: ?0}")
    Users findByEmail(String email);

    @Query("{nome: ?0}")
    Users findByName(String nome);
} 