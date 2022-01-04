import sys

from PyQt5.QtCore import Qt
from PyQt5.QtWidgets import QApplication, QLabel, QMainWindow, QMenuBar,QMenu,QToolBar
from PyQt5.QtGui import QIcon
import qrc_resources

class Window(QMainWindow):
  """Main Window."""

  def __init__(self, parent=None):
    """Initializer."""
    super().__init__(parent)
    self.setWindowTitle("Python Menus & Toolbars")
    self.resize(400, 200)
    self.centralWidget = QLabel("Hello, World")
    self.centralWidget.setAlignment(Qt.AlignHCenter | Qt.AlignVCenter)
    self.setCentralWidget(self.centralWidget)
    self._createMenuBar()
    self._createToolBars()

  def _createToolBars(self):
    # Using a title
    fileToolBar = self.addToolBar("File")
    # Using a QToolBar object
    editToolBar = QToolBar("Edit", self)
    self.addToolBar(editToolBar)
    # Using a QToolBar object and a toolbar area
    helpToolBar = QToolBar("Help", self)
    self.addToolBar(Qt.LeftToolBarArea, helpToolBar)
  def _createMenuBar(self):
    menuBar = self.menuBar()
    # Creating menus using a QMenu object
    fileMenu = QMenu("&File", self)
    menuBar.addMenu(fileMenu)
    # Creating menus using a title
    editMenu = menuBar.addMenu("&Edit")
    # Using an icon and a title
    helpMenu = menuBar.addMenu(QIcon(":help-content.svg"), "&Help")

if __name__ == "__main__":
  app = QApplication(sys.argv)
  win = Window()
  win.show()
  sys.exit(app.exec_())
