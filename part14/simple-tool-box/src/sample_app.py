import sys
from functools import partial

from PyQt5.QtCore import Qt
from PyQt5.QtWidgets import QApplication, QLabel, QMainWindow, QMenuBar,QMenu,QToolBar,QAction,QStatusBar
from PyQt5.QtGui import QIcon,QKeySequence
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
    # self._createContextMenu()
    self._connectActions()
    self._createStatusBar()
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
    # Adding an Open Recent submenu
    self.openRecentMenu = fileMenu.addMenu("Open Recent")
    fileMenu.addAction(self.saveAction)
    # Adding a separator
    fileMenu.addSeparator()
    fileMenu.addAction(self.exitAction)

    # Creating menus using a title
    editMenu = menuBar.addMenu("&Edit")
    editMenu.addAction(self.copyAction)
    editMenu.addAction(self.pasteAction)
    editMenu.addAction(self.cutAction)
    # Adding a separator
    fileMenu.addSeparator()
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
    # Using string-based key sequences
    self.newAction.setShortcut("Ctrl+N")
    self.openAction.setShortcut("Ctrl+O")
    self.saveAction.setShortcut("Ctrl+S")
    # Adding help tips
    newTip = "Create a new file"
    self.newAction.setStatusTip(newTip)
    self.newAction.setToolTip(newTip)
    # Using standard keys
    self.copyAction.setShortcut(QKeySequence.Copy)
    self.pasteAction.setShortcut(QKeySequence.Paste)
    self.cutAction.setShortcut(QKeySequence.Cut)
  def _createContextMenu(self):
    # Setting contextMenuPolicy
    self.centralWidget.setContextMenuPolicy(Qt.ActionsContextMenu)
    # Populating the widget with actions
    self.centralWidget.addAction(self.newAction)
    self.centralWidget.addAction(self.openAction)
    self.centralWidget.addAction(self.saveAction)
    self.centralWidget.addAction(self.copyAction)
    self.centralWidget.addAction(self.pasteAction)
    self.centralWidget.addAction(self.cutAction)

  def getWordCount(self):
    # Logic for computing the word count goes here...
    return 42
  def _createStatusBar(self):
    self.statusbar = self.statusBar()
    # Adding a temporary message
    self.statusbar.showMessage("Ready", 3000)
    # Adding a permanent message
    self.wcLabel = QLabel(f"{self.getWordCount()} Words")
    self.statusbar.addPermanentWidget(self.wcLabel)

  def contextMenuEvent(self, event):
    # Creating a menu object with the central widget as parent
    menu = QMenu(self.centralWidget)
    # Populating the menu with actions
    menu.addAction(self.newAction)
    menu.addAction(self.openAction)
    menu.addAction(self.saveAction)
    # Creating a separator action
    separator = QAction(self)
    separator.setSeparator(True)
    # Adding the separator to the menu
    menu.addAction(separator)
    menu.addAction(self.copyAction)
    menu.addAction(self.pasteAction)
    menu.addAction(self.cutAction)
    # Launching the menu
    menu.exec(event.globalPos())

  def _connectActions(self):
    # Connect File actions
    self.newAction.triggered.connect(self.newFile)
    self.openAction.triggered.connect(self.openFile)
    self.saveAction.triggered.connect(self.saveFile)
    self.exitAction.triggered.connect(self.close)
    # Connect Edit actions
    self.copyAction.triggered.connect(self.copyContent)
    self.pasteAction.triggered.connect(self.pasteContent)
    self.cutAction.triggered.connect(self.cutContent)
    # Connect Help actions
    self.helpContentAction.triggered.connect(self.helpContent)
    self.aboutAction.triggered.connect(self.about)
    # Connect Open Recent to dynamically populate it
    self.openRecentMenu.aboutToShow.connect(self.populateOpenRecent)

  def openRecentFile(self, filename):
    # Logic for opening a recent file goes here...
    self.centralWidget.setText(f"<b>{filename}</b> opened")
  def newFile(self):
    # Logic for creating a new file goes here...
    self.centralWidget.setText("<b>File > New</b> clicked")

  def openFile(self):
    # Logic for opening an existing file goes here...
    self.centralWidget.setText("<b>File > Open...</b> clicked")

  def saveFile(self):
    # Logic for saving a file goes here...
    self.centralWidget.setText("<b>File > Save</b> clicked")

  def copyContent(self):
    # Logic for copying content goes here...
    self.centralWidget.setText("<b>Edit > Copy</b> clicked")

  def pasteContent(self):
    # Logic for pasting content goes here...
    self.centralWidget.setText("<b>Edit > Paste</b> clicked")

  def cutContent(self):
    # Logic for cutting content goes here...
    self.centralWidget.setText("<b>Edit > Cut</b> clicked")

  def helpContent(self):
    # Logic for launching help goes here...
    self.centralWidget.setText("<b>Help > Help Content...</b> clicked")

  def about(self):
    # Logic for showing an about dialog content goes here...
    self.centralWidget.setText("<b>Help > About...</b> clicked")

  def populateOpenRecent(self):
    # Step 1. Remove the old options from the menu
    self.openRecentMenu.clear()
    # Step 2. Dynamically create the actions
    actions = []
    filenames = [f"File-{n}" for n in range(5)]
    for filename in filenames:
      action = QAction(filename, self)
      action.triggered.connect(partial(self.openRecentFile, filename))
      actions.append(action)
    # Step 3. Add the actions to the menu
    self.openRecentMenu.addActions(actions)
if __name__ == "__main__":
  app = QApplication(sys.argv)
  win = Window()
  win.show()
  sys.exit(app.exec_())
