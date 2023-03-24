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


public class Schedule {
  private String[] monday;
  private String[] tuesday;
  private String[] wednesday;
  private String[] thursday;
  private String[] friday;
  private String[] saturday;
  private String[] sunday;


  public String[] getMonday1() {
    return this.monday;
  }
  public String[] getTuesday1() {
    return this.tuesday;
  }
  public String[] getWednesday1() {
    return this.wednesday;
  }
  public String[] getThursday1() {
    return this.thursday;
  }
  public String[] getFriday1() {
    return this.friday;
  }
  public String[] getSaturday1() {
    return this.saturday;
  }
  public String[] getSunday1() {
    return this.sunday;
  }

  public String[] getSunday(){
    if(this.sunday != null){
      String[] newArray = new String[this.sunday.length + 1];

      newArray[0] = "Sunday";

      for (int i = 0; i < this.sunday.length; i++) {
          newArray[i+1] = this.sunday[i];
      }
        return newArray;
    }
    else{
      return null;
    }
  }
  public String[] getSaturday(){
    if(this.saturday != null){

    String[] newArray = new String[this.saturday.length + 1];

    newArray[0] = "Saturday";

    for (int i = 0; i < this.saturday.length; i++) {
        newArray[i+1] = this.saturday[i];
    }
      return newArray;
    }
    else{
      return null;
    }
  }
  public String[] getFriday(){
    if(this.friday != null){

    String[] newArray = new String[this.friday.length + 1];

    newArray[0] = "Friday";

    for (int i = 0; i < this.friday.length; i++) {
        newArray[i+1] =  this.friday[i];
    }
    return newArray;
    }
    else{
      return null;
    }

  }
  public String[] getThursday(){
    if(this.thursday != null){

    String[] newArray = new String[this.thursday.length + 1];

    newArray[0] = "Thursday";

    for (int i = 0; i < this.thursday.length; i++) {
        newArray[i+1] =  this.thursday[i];
    }
      return newArray;
    }
    else{
      return null;
    }

  }
  public String[] getWednesday(){
    if(this.wednesday != null){

    String[] newArray = new String[this.wednesday.length + 1];

    newArray[0] = "Wednesday";

    for (int i = 0; i < this.wednesday.length; i++) {
        newArray[i+1] =  this.wednesday[i];
    }
      return newArray;
    }
    else{
      return null;
    }

  }
  public String[] getTuesday(){
    if(this.tuesday != null){

    String[] newArray = new String[this.tuesday.length + 1];

    newArray[0] = "Tuesday";

    for (int i = 0; i < this.tuesday.length; i++) {
        newArray[i+1] =  this.tuesday[i];
    }
      return newArray;
    }
    else{
      return null;
    }

  }
  public String[] getMonday(){
    if(this.monday != null){

        String[] newArray = new String[this.monday.length + 1];

        newArray[0] = "Monday";

        for (int i = 0; i < this.monday.length; i++) {
            newArray[i+1] =  this.monday[i];
        }
          return newArray;
    }
    else{
      return null;
    }
  }


  public void setMonday(String[] monday) {
    this.monday = monday;
  }
  public void setTuesday(String[] tuesday) {
    this.tuesday = tuesday;
  }
  public void setWednesday(String[] wednesday) {
    this.wednesday = wednesday;
  }
  public void setThursday(String[] thursday) {
    this.thursday = thursday;
  }
  public void setFriday(String[] friday) {
    this.friday = friday;
  }
  public void setSaturday(String[] saturday) {
    this.saturday = saturday;
  }
  public void setSunday(String[] sunday) {
    this.sunday = sunday;
  }

}