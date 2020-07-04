package com.learnjava.www.behavioralPatterns.mediator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OrderFrame extends JFrame {

    public OrderFrame(String... names) {

        setTitle("订单");

        setSize(460, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

        c.add(new JLabel("使用中介模式"));

        List<JCheckBox> checkboxList = addCheckBox(names);

        JButton selectAll = addButton("全选");

        JButton selectNone = addButton("清空");

        selectNone.setEnabled(false);

        JButton selectInverse = addButton("反选");

        new Mediator(checkboxList, selectAll, selectNone, selectInverse);

        setVisible(true);
    }

    private List<JCheckBox> addCheckBox(String... names) {

        JPanel panel = new JPanel();

        panel.add(new JLabel("菜单:"));

        List<JCheckBox> list = new ArrayList<>();

        for (String name : names) {

            JCheckBox checkbox = new JCheckBox(name);

            list.add(checkbox);

            panel.add(checkbox);
        }

        getContentPane().add(panel);

        return list;
    }

    private JButton addButton(String label) {

        JButton button = new JButton(label);

        getContentPane().add(button);

        return button;
    }
}
