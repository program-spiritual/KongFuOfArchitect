# Filename: signals_slots.py

"""Signals and slots example."""

import sys
import functools
from PyQt5.QtWidgets import QApplication
from PyQt5.QtWidgets import QLabel
from PyQt5.QtWidgets import QPushButton
from PyQt5.QtWidgets import QVBoxLayout
from PyQt5.QtWidgets import QWidget

def greeting(who):
    """Slot function."""
    if msg.text():
        msg.setText('')
    else:
        msg.setText(f'Hello {who}')

app = QApplication(sys.argv)
window = QWidget()
window.setWindowTitle('信号和插槽')
layout = QVBoxLayout()

btn = QPushButton('欢迎语')
# btn.clicked.connect(greeting)  # Connect clicked to greeting()
btn.clicked.connect(functools.partial(greeting, 'james !'))
layout.addWidget(btn)
msg = QLabel('')
layout.addWidget(msg)
window.setLayout(layout)
window.show()
sys.exit(app.exec_())