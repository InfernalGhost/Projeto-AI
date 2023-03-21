package com.example.data;


import com.mongodb.MongoClient;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.ObjectId;


@Document("Music")
public class Music implements Serializable{

    @Field
    private String name;
    @Field
    private boolean isActive;

    public Music(String name, boolean isActive){
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return this.name;
    }

    public boolean isActive(){
        return this.isActive;
    }

    public void setActive(boolean x){
        this.isActive = x;
    }
}