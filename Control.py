import serial
import time
from playsound import playsound
import os
import random

sleep_time = 120
wait_time = 180
base_weight = 5000 # Half of the object's weight
replay = True
last_alarm = ""
Arduino = serial.Serial('/dev/ttyACM0', 57600) # Substitute _ with the USB port being used in the PC (see in ArduinoIDE)

def play_alarm():
    random_alarm=random.choice(os.listdir("Alarms/Chosen/"))
    iterations = 0
    while (last_alarm == random_alarm and iterations < 4):
        random_alarm=random.choice(os.listdir("Alarms/Chosen/"))
        iterations+=1

    playsound('Alarms/Chosen/' + random_alarm)
    last_alarm = random_alarm

while True:
    if (Arduino.inWaiting() > 0):
        if (replay):
            start = time.time()
            replay = False
        myData = Arduino.readline() 
        myData = myData.decode("utf-8")
        if (myData[0:6] == "value:"): # See if message is about weight values
            value = eval(myData[7:-2]) # Get value in message
            print(value)
            if (value > - base_weight):
                print("Playing alarm")
                replay = True
                play_alarm()
                time.sleep(sleep_time)
                Arduino.reset_input_buffer()
                print("Checking")
            else:
                now = time.time()
                if (now - start >= wait_time):
                    print("Finishing")
                    break

