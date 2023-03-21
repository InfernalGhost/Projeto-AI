package com.example.demo;


import com.example.data.Users;
import com.example.data.Music;
import java.util.List;


import  org.springframework.data.mongodb.repository.MongoRepository;
import  org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicRepository extends MongoRepository<Music,String> {
    @Query("{}")
    List<Music> findByMusics();

    @Query("{name: ?0}")
    Music findByName(String name);

    @Query(value="{name: ?0}", delete = true)
    Music deleteByName(String name);

}