package com.example.demo;

import com.example.data.Users;
import com.example.data.Music;
import com.example.data.Schedule;
import com.example.data.DailyPython;

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
import java.lang.reflect.Method;

import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDate;
import java.time.Month;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ScheduleService {

    public void create(Schedule s) throws Exception {
        String total ="";
        File myObj = new File("horario.txt");
        myObj.createNewFile();
        FileWriter myWriter = new FileWriter("horario.txt");
        Method[] methods = Schedule.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")){
                
                String[] horas = (String[]) method.invoke(s);
                if(horas != null){
                    for(String x : horas){
                        total = total + " " + x;
                    }
                    myWriter.write(total);
                    myWriter.write("\n");

                    total = "";

                }
            }
        }
        myWriter.close();

        DailyPython executor = new DailyPython();

        // set the Python script schedule for each day of the week
        if(s.getThursday1() != null)
            executor.setPythonScriptSchedule(Calendar.MONDAY, Integer.parseInt(s.getMonday1()[0]), Integer.parseInt(s.getMonday1()[1]));
        if(s.getThursday1() != null)
            executor.setPythonScriptSchedule(Calendar.TUESDAY,Integer.parseInt(s.getTuesday1()[0]), Integer.parseInt(s.getTuesday1()[1]));
        if(s.getThursday1() != null)
            executor.setPythonScriptSchedule(Calendar.WEDNESDAY, Integer.parseInt(s.getWednesday1()[0]), Integer.parseInt(s.getWednesday1()[1]));
        if(s.getThursday1() != null)
            executor.setPythonScriptSchedule(Calendar.THURSDAY, Integer.parseInt(s.getThursday1()[0]), Integer.parseInt(s.getThursday1()[1]));
        if(s.getThursday1() != null)
            executor.setPythonScriptSchedule(Calendar.FRIDAY, Integer.parseInt(s.getFriday1()[0]), Integer.parseInt(s.getFriday1()[1]));
        if(s.getThursday1() != null)
            executor.setPythonScriptSchedule(Calendar.SATURDAY, Integer.parseInt(s.getSaturday1()[0]), Integer.parseInt(s.getSaturday1()[1]));
        if(s.getThursday1() != null)
            executor.setPythonScriptSchedule(Calendar.SUNDAY, Integer.parseInt(s.getSunday1()[0]), Integer.parseInt(s.getSunday1()[1]));
    

    }
}