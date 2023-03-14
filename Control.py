import serial
import time
from playsound import playsound
from mutagen.mp3 import MP3
import os
import random

sleep_time = 10
wait_time = 5
base_weight = 1000
replay = True
Arduino = serial.Serial('COM_', 57600) # Substitute _ with the USB port being used in the PC (see in ArduinoIDE)

def play_alarm():
    random_alarm=random.choice(os.listdir("Alarms"))
    audio = MP3('Alarms/' + random_alarm)
    playsound('Alarms/' + random_alarm)
    return audio.info.length

while True:
    if (Arduino.inWaiting() > 0):
        if (replay):
            start = time.time()
            replay = False
        myData = Arduino.readline() 
        print(myData)
        print(myData[7:-1])
        if (myData[0:6] == "value: "): # See if message is about weight values
            value = eval(myData[7:-1]) # Get value in message
            if (value > base_weight):
                replay = True
                duration = play_alarm()
                time.sleep(duration + wait_time)
            else:
                now = time.time()
                if (now - start >= wait_time):
                    break
            




