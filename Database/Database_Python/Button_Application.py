#!/usr/bin/env python
#Boa:App:BoaApp

import wx
import Database_Access

modules ={u'Colored Buttons': [1, 'Main frame of Application', u'Database_Access.py']}

class BoaApp(wx.App):
    def OnInit(self):
        self.main = Database_Access.create(None)
        self.main.Show()
        self.SetTopWindow(self.main)
        return True
    
def main():
    application = BoaApp(0)
    application.MainLoop()

if __name__ == '__main__':
    main()
