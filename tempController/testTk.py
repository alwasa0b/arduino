import serial
from Tkinter import *
from time import sleep

class Application(Frame):
    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.temp=0
        self.ser = serial.Serial('/dev/ttyACM0', 9600)
        self.root=Tk()
        self.reading = StringVar()
        self.w = Label(self.root, textvariable = self.reading)
        self.b = root.Button(text = 'I am a button')
        self.w.pack()
        self.b.pack()
        self.root.after(1,self.getTemp()) 
        self.root.mainloop()
        
    def say_hi(self):
        print self.ser.readline()

    def createWidgets(self):
        self.QUIT = Button(self)
        self.QUIT["text"] = "QUIT"
        self.QUIT["fg"]   = "red"
        self.QUIT["command"] =  self.quit

        self.QUIT.pack({"side": "left"})

        self.hi_there = Button(self)
        self.hi_there["text"] = "Hello",
        self.hi_there["command"] = self.say_hi

        self.hi_there.pack({"side": "left"})


    def getTemp(self):
        while (True):
            self.reading.set(self.ser.readline())
            sleep(5)




Application()