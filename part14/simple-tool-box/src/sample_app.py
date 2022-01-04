import sys

from PyQt5.QtCore import Qt
from PyQt5.QtWidgets import QApplication, QLabel, QMainWindow, QMenuBar,QMenu,QToolBar,QAction
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
    self._createActions()
    self._createMenuBar()
    self._createToolBars()

  def _createToolBars(self):
    # Using a title
    fileToolBar = self.addToolBar("File")
    fileToolBar.addAction(self.newAction)
    fileToolBar.addAction(self.openAction)
    fileToolBar.addAction(self.saveAction)
    # Using a QToolBar object
    editToolBar = QToolBar("Edit", self)
    self.addToolBar(editToolBar)
    editToolBar.addAction(self.copyAction)
    editToolBar.addAction(self.pasteAction)
    editToolBar.addAction(self.cutAction)
    # Using a QToolBar object and a toolbar area
    helpToolBar = QToolBar("Help", self)
    self.addToolBar(Qt.LeftToolBarArea, helpToolBar)
  def _createMenuBar(self):
    menuBar = self.menuBar()
    # Creating menus using a QMenu object
    fileMenu = QMenu("&File", self)
    menuBar.addMenu(fileMenu)
    fileMenu.addAction(self.newAction)
    fileMenu.addAction(self.openAction)
    fileMenu.addAction(self.saveAction)
    fileMenu.addAction(self.exitAction)
    # Creating menus using a title
    editMenu = menuBar.addMenu("&Edit")
    editMenu.addAction(self.copyAction)
    editMenu.addAction(self.pasteAction)
    editMenu.addAction(self.cutAction)
    findMenu = editMenu.addMenu("Find and Replace")
    findMenu.addAction("Find...")
    findMenu.addAction("Replace...")
    # Using an icon and a title
    helpMenu = menuBar.addMenu(QIcon(":help-content.svg"), "&Help")
    helpMenu.addAction(self.helpContentAction)
    helpMenu.addAction(self.aboutAction)

  def _createActions(self):
    # Creating action using the first constructor
    self.newAction = QAction(self)
    self.newAction.setText("&New")
    self.newAction.setIcon(QIcon(":file-new.svg"))

    # Creating actions using the second constructor
    self.openAction = QAction(QIcon(":file-open.svg"), "&Open...", self)
    self.saveAction = QAction(QIcon(":file-save.svg"), "&Save", self)
    self.exitAction = QAction("&Exit", self)
    self.copyAction = QAction(QIcon(":edit-copy.svg"), "&Copy", self)
    self.pasteAction = QAction(QIcon(":edit-paste.svg"), "&Paste", self)
    self.cutAction = QAction(QIcon(":edit-cut.svg"), "C&ut", self)
    self.helpContentAction = QAction("&Help Content", self)
    self.aboutAction = QAction("&About", self)
if __name__ == "__main__":
  app = QApplication(sys.argv)
  win = Window()
  win.show()
  sys.exit(app.exec_())
