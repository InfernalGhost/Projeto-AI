package com.example.data;


import java.io.Serializable;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import javax.xml.bind.annotation.XmlRootElement;


@Document("Clients")
public class Users implements Serializable{
    @Field
    private String nome;
    @Field
    private String email;
    @Field
    private String password;
    

    public Users() {
    }
    
    public Users(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;

        this.password = password;

    }
    
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }






    
    public String toString(){
        return "{"+"\n"+"Cedula: "+"\n"+"name: "+getNome()+"\n"+"email: "+getEmail()+"\n"+"password: "+"}\n";
    }

}
