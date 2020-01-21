package FX.Addition_tables;

import FX.Addition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Organization extends JFrame {
    String[] data1 = {"Название организации", "Тип организации", "Имя начальника", "Возраст", "Локация", "Кол. персонала", "Накопления организации"};
    JLabel l1 = new JLabel(data1[0]), l2 = new JLabel(data1[1]), l3 = new JLabel(data1[2]), l4 = new JLabel(data1[3]),
            l5 = new JLabel(data1[4]), l6 = new JLabel(data1[5]), l7 = new JLabel(data1[6]);
    JTextField t1 = new JTextField(10), t2 = new JTextField(10), t3 = new JTextField(10),
            t4 = new JTextField(10), t5 = new JTextField(10), t6 = new JTextField(10),
            t7 = new JTextField(10);
    JButton b1 = new JButton("Подтвердить");
    eHandler handler = new eHandler();


    public Organization() {
        super("Org_table");
        setLayout(new GridLayout(8, 3));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(b1);
        b1.addActionListener(handler);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700,200);
        setLocation(0,0);
    }

    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) || str.charAt(i) == ' ') return false;
        }
        return true;
    }

    public boolean isString(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) || str.charAt(i) == ' ') return false;
        }
        return true;
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                if(!isString(t1.getText()) || !isString(t2.getText()) ||
                        !isString(t3.getText()) || !isNumber(t4.getText()) || !isString(t5.getText()) ||
                        !isNumber(t6.getText()) || !isNumber(t7.getText())) {
                    String Error = "Вы заполнили не все поля или ввели не коректные данные!";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);

                }
                else {
                    Addition.orgz[0] = t1.getText();
                    Addition.orgz[1] = t2.getText();
                    Addition.orgz[2] = t3.getText();
                    Addition.orgz[3] = t4.getText();
                    Addition.orgz[4] = t5.getText();
                    Addition.orgz[5] = t6.getText();
                    Addition.orgz[6] = t7.getText();
                    Addition.counter++;
                    dispose();
                }
            }
        }
    }
}
