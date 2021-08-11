import sys
from PyQt5.QtCore import *
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
def window():
   app = QApplication(sys.argv)
   w = QWidget()
   b = QLabel(w)
   b.setText("Hello World!")
   # x y width height
   w.setGeometry(100, 100, 280, 80) 
   w.move(60, 15)
   w.setWindowTitle("PyQt5 App")
   helloMsg = QLabel('<h1>Hello World!</h1>', parent=w)
   helloMsg.move(60, 15)
   w.show()
   sys.exit(app.exec_())
if __name__ == '__main__':
   window()