import serial
from Tkinter import *
from time import sleep
import Tkinter
import threading
import Tkinter as tk


class control(tk.Tk):
    
    def __init__(self):
        
        threading.Thread.__init__(self)
        
        
        
    def callback(self):
        self.root.quit()
        
    def run(self):
        self.root=Tkinter.Tk()
        self.root.protocol("WM_DELETE_WINDOW", self.callback)
        self.swingUp=StringVar()
        self.swingDown=StringVar()
        self.temp=StringVar()
        self.settings=StringVar()
        self.crrtemp=StringVar()
        
        
  
        self.ser = serial.Serial('/dev/ttyACM0', 9600)
        
        
        self.getTempBox = Message(self.root, textvariable=self.crrtemp, relief=RAISED )
        self.getTempBox.pack()
        
        
        L0 = Label(self.root, text="setTemp")
        L0.pack()
        self.swingTempLable = Entry(self.root,textvariable=self.temp)
        self.swingTempLable.pack()
        self.swingTempLable.bind('<Key-Return>', self.setTempEvent)
        
        
        L1 = Label(self.root, text="swingUp")
        L1.pack()
        self.swingUpLable = Entry(self.root,textvariable=self.swingUp)
        self.swingUpLable.pack()
        self.swingUpLable.bind('<Key-Return>', self.setSwingUpEvent)
        
        L2 = Label(self.root, text="swingDown")
        L2.pack()
        self.swingDownLable = Entry(self.root,textvariable=self.swingDown)
        self.swingDownLable.pack()
        self.swingDownLable.bind('<Key-Return>', self.setSwingDownEvent)
        
        
        
        self.getSettingsBox = Message(self.root, textvariable=self.settings, relief=RAISED )
        self.getSettingsBox.pack()
        self.getSettings = Button(self.root,text ="getCurrentSettings",command=self.getSet);
        self.getSettings.pack()
        
                
        self.root.after(2000,self.getTemp) 
        self.root.mainloop()
        
        
    def getTemp(self):
        while (True):
            self.crrtemp.set(self.ser.readline())
            self.after(500,self.getTemp)


    def setTempEvent(self, event):
        self.setTemp(self.temp.get())    
    
    
    def setSwingDownEvent(self, event):
        self.setSwingDown(self.swingDown.get())    
        
    def setSwingUpEvent(self, event):
        self.setSwingUp(self.swingUp.get())
        
    def setTemp(self, n):
        self.temp.set(n)
        self.ser.write('@%s' %self.temp.get())
        
        print ('@%s' %self.temp.get())    
    
        
    def setSwingUp(self, n):
        self.swingUp.set(n)
        self.ser.write('~%s' %self.swingUp.get())
       
        print ('~%s' %self.swingUp.get())
        
    def setSwingDown(self,n):
        self.swingDown.set(n)
        self.ser.write('!%s' %self.swingDown.get())
       
        print ('!%s' %self.swingDown.get())
        
    def getCurrentSettings(self):
        self.ser.write('#')
    
    
    def getSet(self):
        self.ser.write('#')
        buff=""
        t=""
        while True:
            buff += self.ser.readline()
            if 'current' and "activated" in buff:
                self.settings.set(buff.partition("current")[1]+buff.partition("current")[2])
                break
        
        
        return self.settings.get()
        
    
    


    
    
     
app= control()
app.start()     