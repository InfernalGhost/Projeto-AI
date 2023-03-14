import serial
from playsound import playsound
import os
import random

Arduino = serial.Serial('COM_', 57600) # Substitute _ with the USB port being used in the PC (see in ArduinoIDE)

def play_alarm():
    random_alarm=random.choice(os.listdir("Alarms"))
    playsound('Alarms/' + random_alarm)

while True:
    if (Arduino.inWaiting() > 0):
        myData = Arduino.readline() 
        print(myData)
        print(myData[7:-1])
        #if (myData[0:6] == "value: "): # See if message is about weight values
        #    value = eval(myData[7:-1]) # Get value in message
        #    if (value < 20000):
        #        play_alarm()





