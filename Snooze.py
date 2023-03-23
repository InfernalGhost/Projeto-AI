# pip install pycaw
from ctypes import cast, POINTER
import time
from comtypes import CLSCTX_ALL
from pycaw.pycaw import AudioUtilities, IAudioEndpointVolume
import math

# Get default audio device using PyCAW
devices = AudioUtilities.GetSpeakers()
interface = devices.Activate(
    IAudioEndpointVolume._iid_, CLSCTX_ALL, None)
volume = cast(interface, POINTER(IAudioEndpointVolume))
# Get current volume 
currentVolumeDb = volume.GetMasterVolumeLevel()
volume.SetMasterVolumeLevelScalar(0, None)
time.sleep(30)
volume.SetMasterVolumeLevel(currentVolumeDb, None)