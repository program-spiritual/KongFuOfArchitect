import sys

from PyQt5.QtWidgets import (
    QApplication,
    QGridLayout,
    QPushButton,
    QWidget,
)

class Window(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QGridLayout Example")
        # Create a QGridLayout instance
        layout = QGridLayout()
        # Add widgets to the layout
        layout.addWidget(QPushButton("Button at (0, 0)"), 0, 0)
        layout.addWidget(QPushButton("Button at (0, 1)"), 0, 1)
        layout.addWidget(QPushButton("Button at (0, 2)"), 0, 2)
        layout.addWidget(QPushButton("Button at (1, 0)"), 1, 0)
        layout.addWidget(QPushButton("Button at (1, 1)"), 1, 1)
        layout.addWidget(QPushButton("Button at (1, 2)"), 1, 2)
        layout.addWidget(QPushButton("Button at (2, 0)"), 2, 0)
        layout.addWidget(QPushButton("Button at (2, 1)"), 2, 1)
        layout.addWidget(QPushButton("Button at (2, 2)"), 2, 2)
        # Set the layout on the application's window
        self.setLayout(layout)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = Window()
    window.show()
    sys.exit(app.exec_())