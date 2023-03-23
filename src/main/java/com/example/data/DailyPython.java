package com.example.data;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DailyPython {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Map<Integer, Long> scheduleMap = new HashMap<>();

    public void setPythonScriptSchedule(int dayOfWeek, int hourOfDay, int minute) {
        // create a new calendar instance with the specified time of day
        Calendar timeOfDay = new GregorianCalendar();


        timeOfDay.set(Calendar.HOUR, hourOfDay);
        timeOfDay.set(Calendar.MINUTE, minute);
        timeOfDay.set(Calendar.SECOND, 0);

        // get the time until the next occurrence of the specified time of day
        long initialDelay = timeOfDay.getTimeInMillis() - System.currentTimeMillis() ;
        System.out.println(initialDelay);

        if (initialDelay < 0) {
            initialDelay += 24 * 60 * 60 * 1000; // add 24 hours to delay if the specified time of day has already passed today
        }
        // store the schedule for the specified day of week
        scheduleMap.put(dayOfWeek, initialDelay);

        // schedule the task to execute at the specified time of day on the specified day of week
        scheduler.scheduleAtFixedRate(() -> {
            try {
                System.out.println("GG TA A FUNCIONAR CRLS");
                Process process = Runtime.getRuntime().exec("/usr/bin/python3 " + "/home/seed/Music/Projeto-AI-main/Control.py");
                //process.waitFor(); // wait for the process to complete
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, initialDelay, 7 * 24 * 60 * 60 * 1000, TimeUnit.MILLISECONDS); // repeat every 7 days
    }
}