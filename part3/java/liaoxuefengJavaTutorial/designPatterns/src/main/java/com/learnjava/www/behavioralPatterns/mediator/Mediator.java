package com.learnjava.www.behavioralPatterns.mediator;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class Mediator {

  // 引用UI组件:

  private List<JCheckBox> checkBoxList;

  private JButton selectAll;

  private JButton selectNone;

  private JButton selectInverse;

  public Mediator(
    List<JCheckBox> checkBoxList,
    JButton selectAll,
    JButton selectNone,
    JButton selectInverse
  ) {
    this.checkBoxList = checkBoxList;

    this.selectAll = selectAll;

    this.selectNone = selectNone;

    this.selectInverse = selectInverse;

    // 绑定事件:
    this.checkBoxList.forEach(
        checkBox -> {
          checkBox.addChangeListener(this::onCheckBoxChanged);
        }
      );

    this.selectAll.addActionListener(this::onSelectAllClicked);

    this.selectNone.addActionListener(this::onSelectNoneClicked);

    this.selectInverse.addActionListener(this::onSelectInverseClicked);
  }

  // 当checkbox有变化时:
  public void onCheckBoxChanged(ChangeEvent event) {
    boolean allChecked = true;

    boolean allUnchecked = true;

    for (var checkBox : checkBoxList) {
      if (checkBox.isSelected()) {
        allUnchecked = false;
      } else {
        allChecked = false;
      }
    }

    selectAll.setEnabled(!allChecked);

    selectNone.setEnabled(!allUnchecked);
  }

  // 当点击select all:
  public void onSelectAllClicked(ActionEvent event) {
    checkBoxList.forEach(checkBox -> checkBox.setSelected(true));

    selectAll.setEnabled(false);

    selectNone.setEnabled(true);
  }

  // 当点击select none:
  public void onSelectNoneClicked(ActionEvent event) {
    checkBoxList.forEach(checkBox -> checkBox.setSelected(false));

    selectAll.setEnabled(true);

    selectNone.setEnabled(false);
  }

  // 当点击select inverse:
  public void onSelectInverseClicked(ActionEvent event) {
    checkBoxList.forEach(
      checkBox -> checkBox.setSelected(!checkBox.isSelected())
    );

    onCheckBoxChanged(null);
  }
}
