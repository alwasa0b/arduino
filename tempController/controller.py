import serial
from Tkinter import *
from time import sleep
import Tkinter
import threading


class control(threading.Thread):
    
    def __init__(self,root):
        self.swingUp=StringVar()
        self.swingDown=StringVar()
        self.temp=StringVar()
        self.settings=StringVar()
        self.crrtemp=StringVar()
        
        
        self.root=root
        self.ser = serial.Serial('/dev/rfcomm0', 9600)
        
        
        self.getTempBox = Message(root, textvariable=self.crrtemp, relief=RAISED )
        self.getTempBox.pack()
        
        
        L0 = Label(root, text="setTemp")
        L0.pack()
        self.swingTempLable = Entry(root,textvariable=self.temp)
        self.swingTempLable.pack()
        self.swingTempLable.bind('<Key-Return>', self.setTempEvent)
        
        
        L1 = Label(root, text="swingUp")
        L1.pack()
        self.swingUpLable = Entry(root,textvariable=self.swingUp)
        self.swingUpLable.pack()
        self.swingUpLable.bind('<Key-Return>', self.setSwingUpEvent)
        
        L2 = Label(root, text="swingDown")
        L2.pack()
        self.swingDownLable = Entry(root,textvariable=self.swingDown)
        self.swingDownLable.pack()
        self.swingDownLable.bind('<Key-Return>', self.setSwingDownEvent)
        
        
        
        self.getSettingsBox = Message(root, textvariable=self.settings, relief=RAISED )
        self.getSettingsBox.pack()
        self.getSettings = Button(root,text ="getCurrentSettings",command=self.getSet);
        self.getSettings.pack()
        
                
         
        
    def getTemp(self):
        
            self.crrtemp.set(self.ser.readline())
            self.getTempBox.after(20, self.getTemp)
            


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
        
        self.getSettingsBox.after(20, self.getSet)
        return self.settings.get()
        
    
    
def main():
    root = Tk()
    k1 = control(root)
    k2 = control(root)
    
    mainloop()  
  
 
    
    
     
main()      