package com.example.demo;

import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.nio.file.Files;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.List;
import java.util.ArrayList;



import static javax.xml.bind.DatatypeConverter.printHexBinary;

import com.example.data.Users;
import com.example.data.Music;


import org.bson.types.Binary;
import org.bson.BsonBinarySubType;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.nio.file.Paths;



@Service
public class UserAppService   
{    

    @Autowired    
    private UserAppRepository userRepository;
    
    @Autowired    
    private MusicRepository musicRepository;

    public Users register(Users user) throws GeneralSecurityException, IOException
    {   
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty())
                return null;
        else {
            user.setPassword(encode(user.getPassword()));

            System.out.println(user.toString());

            userRepository.save(user);
        }
        return user;    
    }
    
    public String encode(String pass){
        StringBuilder sb = new StringBuilder();
        try 
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pass.getBytes());
            byte[] bytes = md.digest();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}    