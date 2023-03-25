# Oriens (Smart Alarm Clock)

## Required platforms

The software here presented must be run in Ubuntu since some of the python libraries are only available in this OS

## Software and Python Specifications

To run the website that allows to control the project, it is necessary to have Maven, Java and Mongodb installed

All python scripts (3) are in the main directory. It is necessary to have python3 installed, as well as multiple modules such as pyserial, playsound, subprocess and psutil.
All of these modules can be installed with the command pip3 install "module"

## Setup Instructions

To setup the project, run the "mvn clean spring-boot:run" command in the Website directory. This will have the website running in "localhost:8443" where all operations can be made. Since the database will be empty, the musics have to be inserted manually by performing the query "db.Music.insert({name:"name of the music",isActive : false})" in the database.
To properly use/test the alarm clock it is imperative to have an Arduino Uno connected to the computer reading input values. The parameter "port" in "Control.py" must be adjusted according to the computer's port where the Arduino is connected.