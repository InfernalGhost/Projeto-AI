import psutil
import os, signal

process_name = "python.exe"
pid = None

for proc in psutil.process_iter():
    if process_name in proc.name():
       pid = proc.pid
       break
os.kill(int(pid), signal.SIGTERM)
