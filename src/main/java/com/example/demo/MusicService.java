package com.example.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.print.Doc;

import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static javax.xml.bind.DatatypeConverter.printHexBinary;

import com.example.data.Users;
import com.example.data.Music;


import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.bson.types.Binary;
import org.bson.BsonBinarySubType;

import  org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection ;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;


@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public void setActive(String name, boolean x) throws IOException{
        Music music = this.musicRepository.findByName(name);
        this.musicRepository.deleteByName(name);
        music.setActive(x);
        this.musicRepository.save(music);
        if(x){
            Path temp = Files.move
            (Paths.get("Alarms/" + name + ".mp3"),
            Paths.get("Alarms/Chosen/" + name + ".mp3"));
        }        
    }

    public List<String> getMusic() {

        List<String> result = new ArrayList<String>();

        for (Music m : this.musicRepository.findByMusics()) {
            result.add(m.getName());
        }

        return result;
    }

    public void reset() throws IOException{
        File dir = new File("Alarms/Chosen/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                Path temp = Files.move
                (Paths.get("Alarms/Chosen/" + child.getName()),
                Paths.get("Alarms/" + child.getName()));
            }
        } else {
            return;
        }
    }
}