#Boa:Frame:Frame2

import wx
import MySQLdb

def create(parent):
    return Frame2(parent)

[wxID_FRAME2, wxID_FRAME2BUTTON1, wxID_FRAME2BUTTON2, wxID_FRAME2BUTTON3, 
 wxID_FRAME2BUTTON4, wxID_FRAME2BUTTON5, wxID_FRAME2BUTTON6, 
 wxID_FRAME2BUTTON7, wxID_FRAME2BUTTON8, wxID_FRAME2PANEL1, wxID_FRAME2START, 
] = [wx.NewId() for _init_ctrls in range(11)]

[wxID_FRAME2TIMER1, wxID_FRAME2TIMER2, wxID_FRAME2TIMER3, wxID_FRAME2TIMER4, 
 wxID_FRAME2TIMER5, wxID_FRAME2TIMER6, wxID_FRAME2TIMER7, 
] = [wx.NewId() for _init_utils in range(7)]

class Frame2(wx.Frame):
    global db
    db = MySQLdb.connect("127.0.0.1","root","","fetch_data" )
    
    def _init_utils(self):
        # generated method, don't edit
        self.timer1 = wx.Timer(id=wxID_FRAME2TIMER1, owner=self)
        self.Bind(wx.EVT_TIMER, self.OnTimer1Timer, id=wxID_FRAME2TIMER1)

        self.timer2 = wx.Timer(id=wxID_FRAME2TIMER2, owner=self)
        self.Bind(wx.EVT_TIMER, self.OnTimer2Timer, id=wxID_FRAME2TIMER2)

        self.timer3 = wx.Timer(id=wxID_FRAME2TIMER3, owner=self)
        self.Bind(wx.EVT_TIMER, self.OnTimer3Timer, id=wxID_FRAME2TIMER3)

        self.timer4 = wx.Timer(id=wxID_FRAME2TIMER4, owner=self)
        self.Bind(wx.EVT_TIMER, self.OnTimer4Timer, id=wxID_FRAME2TIMER4)

        self.timer5 = wx.Timer(id=wxID_FRAME2TIMER5, owner=self)
        self.Bind(wx.EVT_TIMER, self.OnTimer5Timer, id=wxID_FRAME2TIMER5)

        self.timer6 = wx.Timer(id=wxID_FRAME2TIMER6, owner=self)
        self.Bind(wx.EVT_TIMER, self.OnTimer6Timer, id=wxID_FRAME2TIMER6)

        self.timer7 = wx.Timer(id=wxID_FRAME2TIMER7, owner=self)
        self.Bind(wx.EVT_TIMER, self.OnTimer7Timer, id=wxID_FRAME2TIMER7)

    def _init_ctrls(self, prnt):
        # generated method, don't edit
        wx.Frame.__init__(self, id=wxID_FRAME2, name='', parent=prnt,
              pos=wx.Point(413, 180), size=wx.Size(400, 453),
              style=wx.DEFAULT_FRAME_STYLE, title='Frame2')
        self._init_utils()
        self.SetClientSize(wx.Size(384, 415))

        self.panel1 = wx.Panel(id=wxID_FRAME2PANEL1, name='panel1', parent=self,
              pos=wx.Point(0, 0), size=wx.Size(384, 415),
              style=wx.TAB_TRAVERSAL)

        self.Start = wx.Button(id=wxID_FRAME2START, label='Start', name='Start',
              parent=self.panel1, pos=wx.Point(144, 96), size=wx.Size(75, 23),
              style=0)
        self.Start.Bind(wx.EVT_BUTTON, self.OnStartButton, id=wxID_FRAME2START)

        self.button1 = wx.Button(id=wxID_FRAME2BUTTON1, label='button1',
              name='button1', parent=self.panel1, pos=wx.Point(8, 16),
              size=wx.Size(75, 23), style=0)

        self.button2 = wx.Button(id=wxID_FRAME2BUTTON2, label='button2',
              name='button2', parent=self.panel1, pos=wx.Point(96, 16),
              size=wx.Size(75, 23), style=0)

        self.button3 = wx.Button(id=wxID_FRAME2BUTTON3, label='button3',
              name='button3', parent=self.panel1, pos=wx.Point(184, 16),
              size=wx.Size(75, 23), style=0)

        self.button4 = wx.Button(id=wxID_FRAME2BUTTON4, label='button4',
              name='button4', parent=self.panel1, pos=wx.Point(272, 16),
              size=wx.Size(75, 23), style=0)

        self.button5 = wx.Button(id=wxID_FRAME2BUTTON5, label='button5',
              name='button5', parent=self.panel1, pos=wx.Point(8, 56),
              size=wx.Size(75, 23), style=0)

        self.button6 = wx.Button(id=wxID_FRAME2BUTTON6, label='button6',
              name='button6', parent=self.panel1, pos=wx.Point(96, 56),
              size=wx.Size(75, 23), style=0)

        self.button7 = wx.Button(id=wxID_FRAME2BUTTON7, label='button7',
              name='button7', parent=self.panel1, pos=wx.Point(184, 56),
              size=wx.Size(75, 23), style=0)

        self.button8 = wx.Button(id=wxID_FRAME2BUTTON8, label='button8',
              name='button8', parent=self.panel1, pos=wx.Point(272, 56),
              size=wx.Size(75, 23), style=0)

    def __init__(self, parent):
        self._init_ctrls(parent)
        
    def OnStartButton(self, event):
                    
        try:
            db.query("""SELECT * FROM colors where Button = 1""")
            r = db.store_result()
            print r.fetch_row()
            if (r.fetch_row() == 'Red',):
                self.button1.SetBackgroundColour('Blue')
                self.Refresh()
                self.timer1.Start(2000)
            else:
                print "Fetching not possible"
                       
        except:
            print "Error: unable to fetch data"
                    
    def OnTimer1Timer(self, event):
        
        try:
            db.query("""SELECT * FROM colors where Button = 2""")
            r1 = db.store_result()
            print r1.fetch_row()
            if (r1.fetch_row() == 'Green',):
                self.button2.SetBackgroundColour('Green')
                self.Refresh()
                self.timer1.Stop()
                self.timer2.Start(2000)
            else:
                print "Fetching not possible"
                
        except:
            print "Error: unable to fetch data"

    def OnTimer2Timer(self, event):
        
        try:
            db.query("""SELECT * FROM colors where Button = 3""")
            r2 = db.store_result()
            print r2.fetch_row()
            if (r2.fetch_row() == 'Red',):
                self.button3.SetBackgroundColour('Red')
                self.Refresh()
                self.timer2.Stop()
                self.timer3.Start(2000)
            else:
                print "Fetching not possible"
                
        except:
            print "Error: unable to fetch data"


    def OnTimer3Timer(self, event):
        
        try:
            db.query("""SELECT * FROM colors where Button = 4""")
            r3 = db.store_result()
            print r3.fetch_row()
            if (r3.fetch_row() == 'Yellow',):
                self.button4.SetBackgroundColour('Yellow')
                self.Refresh()
                self.timer3.Stop()
                self.timer4.Start(2000)
            else:
                print "Fetching not possible"
                
        except:
            print "Error: unable to fetch data"


    def OnTimer4Timer(self, event):

        try:
            db.query("""SELECT * FROM colors where Button = 5""")
            r4 = db.store_result()
            print r4.fetch_row()
            if (r4.fetch_row() == 'Orange',):
                self.button5.SetBackgroundColour('Orange')
                self.Refresh()
                self.timer4.Stop()
                self.timer5.Start(2000)
            else:
                print "Fetching not possible"
                
        except:
            print "Error: unable to fetch data"


    def OnTimer5Timer(self, event):

        try:
            db.query("""SELECT * FROM colors where Button = 6""")
            r5 = db.store_result()
            print r5.fetch_row()
            if (r5.fetch_row() == 'Grey',):
                self.button6.SetBackgroundColour('Grey')
                self.Refresh()
                self.timer5.Stop()
                self.timer6.Start(2000)
            else:
                print "Fetching not possible"
                
        except:
            print "Error: unable to fetch data"


    def OnTimer6Timer(self, event):

        try:
            db.query("""SELECT * FROM colors where Button = 7""")
            r6 = db.store_result()
            print r6.fetch_row()
            if (r6.fetch_row() == 'Black',):
                self.button7.SetBackgroundColour('Black')
                self.Refresh()
                self.timer6.Stop()
                self.timer7.Start(2000)
            else:
                print "Fetching not possible"
                
        except:
            print "Error: unable to fetch data"


    def OnTimer7Timer(self, event):

        try:
            db.query("""SELECT * FROM colors where Button = 8""")
            r7 = db.store_result()
            print r7.fetch_row()
            if (r7.fetch_row(0) == 'White',):
                self.button8.SetBackgroundColour('White')
                self.Refresh()
                self.timer7.Stop()
            else:
                print "Fetching not possible"
                
        except:
            print "Error: unable to fetch data"

