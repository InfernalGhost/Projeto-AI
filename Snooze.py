import subprocess
import time

subprocess.run(["amixer", "-D", "pulse", "sset", "Master", "mute"])

time.sleep(30)

subprocess.run(["amixer", "-D", "pulse", "sset", "Master", "unmute"])
