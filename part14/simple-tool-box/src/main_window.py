# Filename: main_window.py

"""Main Window-Style application."""
import sys
from PyQt5.QtWidgets import QApplication
from PyQt5.QtWidgets import QLabel
from PyQt5.QtWidgets import QMainWindow
from PyQt5.QtWidgets import QStatusBar
from PyQt5.QtWidgets import QToolBar


class Window(QMainWindow):
  """Main Window."""

  def __init__(self, parent=None):
    """Initializer."""
    super().__init__(parent)
    self.setWindowTitle('主窗口')
    self.setCentralWidget(QLabel("我是居中部件"))
    # 在后续行中调用专用方法，以创建不同的 GUI 元素：
    # 创建菜单
    self._createMenu()
    # 创建工具栏
    self._createToolBar()
    # 创建状态栏
    self._createStatusBar()

  def _createMenu(self):
    self.menu = self.menuBar().addMenu("&Menu")
    self.menu.addAction('&Exit', self.close)

  def _createToolBar(self):
    tools = QToolBar()
    self.addToolBar(tools)
    tools.addAction('Exit', self.close)

  def _createStatusBar(self):
    status = QStatusBar()
    status.showMessage("我是状态栏")
    self.setStatusBar(status)

if __name__ == '__main__':
    app = QApplication(sys.argv)
    win = Window()
    win.show()
    sys.exit(app.exec_())