package FX;

import Tools.Shifr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.jar.JarFile;

public class Redaction extends JFrame {
    JLabel l1 = new JLabel("Выберите параметры редактирования."), space = new JLabel(" ");
    public String[] data;
    String[] data1 = {" ", "Название организации", "Тип организации", "Имя начальника", "Возраст", "Локация", "Кол. персонала", "Накопления организации"};
    String[] data2 = {" ", "Сфера делятельности", "Тип продукции"};
    String[] data3 = {" ", "Название конкурента", "Стаж конурента"};
    String[] data4 = {" ", "Выручка с продукции", "Прибыль", "Оказание аренды", "Брэндовый налог"};
    String[] data5 = {" ", "Название актива", "Стоимость актива", "Возраст актива"};
    String[] data6 = {" ", "Мелкие издержки", "Крупные издержки", "Налоги", "Долги", "Затраты на улучшения"};
    String[] data7 = {" ", "Количество акционеров", "Девиденты", "Рыночная стоимость акций"};
    String[] on_Red = {"", "", "", "", "", "", ""};
    int[][] Check = {{0, 0, 0, 1, 0, 1, 1}, {0, 0}, {0, 1}, {1, 1, 1, 1}, {0, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1}};
    eHandler handler = new eHandler();
    JComboBox cb, cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    JLabel l2 = new JLabel("Организация."), l3 = new JLabel("Напрвление"), l4 = new JLabel("Конкурент"), l5 = new JLabel("Доходы"),
            l6 = new JLabel("Расходы"), l7 = new JLabel("Имущество"), l8 = new JLabel("Акции"), l9 = new JLabel("Название");
    JButton b1 = new JButton("Завершить изменение."), b2 = new JButton("Внести изменение.");
    JTextField t1;
    int input = 0, Queue = 0;
    BufferedWriter Wr;

    public Redaction(String S, String[] OR, BufferedWriter bw) {
        super(S);
        data = OR;
        Wr = bw;
        setLayout(new GridLayout(11,2));

        t1 = new JTextField("тут нужно будет вводить данные");
        t1.setForeground(Color.black);

        cb = new JComboBox(data);
        cb1 = new JComboBox(data1);
        cb2 = new JComboBox(data2);
        cb3 = new JComboBox(data3);
        cb4 = new JComboBox(data4);
        cb5 = new JComboBox(data5);
        cb6 = new JComboBox(data6);
        cb7 = new JComboBox(data7);

        add(l1);
        add(space);
        add(l9);
        add(cb);
        add(l2);
        add(cb1);
        add(l3);
        add(cb2);
        add(l4);
        add(cb3);
        add(l5);
        add(cb4);
        add(l6);
        add(cb5);
        add(l7);
        add(cb6);
        add(l8);
        add(cb7);
        add(t1);
        add(b2);
        add(b1);

        b1.addActionListener(handler);
        b2.addActionListener(handler);
        cb1.addActionListener(handler);
        cb2.addActionListener(handler);
        cb3.addActionListener(handler);
        cb4.addActionListener(handler);
        cb5.addActionListener(handler);
        cb6.addActionListener(handler);
        cb7.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(600,450);
        setResizable(false);
        setLocationRelativeTo(null);
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

    boolean multySwitch() {
        switch (input) {
            case 0:
                if(Check[0][Queue] == 1) {
                    return isNumber(t1.getText());
                }
                else {
                    return isString(t1.getText());
                }
            case 1:
                if(Check[1][Queue] == 1) {
                    return isNumber(t1.getText());
                }
                else {
                    return isString(t1.getText());
                }
            case 2:
                if(Check[2][Queue] == 1) {
                    return isNumber(t1.getText());
                }
                else {
                    return isString(t1.getText());
                }
            case 3:
                if(Check[3][Queue] == 1) {
                    return isNumber(t1.getText());
                }
                else {
                    return isString(t1.getText());
                }
            case 4:
                if(Check[4][Queue] == 1) {
                    return isNumber(t1.getText());
                }
                else {
                    return isString(t1.getText());
                }
            case 5:
                if(Check[5][Queue] == 1) {
                    return isNumber(t1.getText());
                }
                else {
                    return isString(t1.getText());
                }
            case 6:
                if(Check[6][Queue] == 1) {
                    return isNumber(t1.getText());
                }
                else {
                    return isString(t1.getText());
                }
            default: return false;
        }
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                try {
                    String RED = "";

                    RED += data[cb.getSelectedIndex()] + "/";
                    RED += cb1.getSelectedIndex() + "-" + on_Red[0] + "/";
                    RED += cb2.getSelectedIndex() + "-" + on_Red[1] +"/";
                    RED += cb3.getSelectedIndex() + "-" + on_Red[2] +"/";
                    RED += cb4.getSelectedIndex() + "-" + on_Red[3] +"/";
                    RED += cb5.getSelectedIndex() + "-" + on_Red[4] +"/";
                    RED += cb6.getSelectedIndex() + "-" + on_Red[5] +"/";
                    RED += cb7.getSelectedIndex() + "-" + on_Red[6];

                    Wr.write(RED + "\n");
                    Wr.flush();
                    dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getSource() == b2) {
                if(multySwitch()) {
                    on_Red[input] = t1.getText();
                    t1.setText("тут нужно будет вводить данные");
                    t1.setForeground(Color.black);
                }
                else {
                    String Error = "Вы ввели не коректные данные!";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);
                }
            }
            if(e.getSource() == cb1) {
                input = 0;
                Queue = cb1.getSelectedIndex() - 1;
                t1.setForeground(Color.red);
                t1.setText("Введите значение поля");
            }
            if(e.getSource() == cb2) {
                input = 1;
                Queue = cb2.getSelectedIndex() - 1;
                t1.setForeground(Color.red);
                t1.setText("Введите значение поля");
            }
            if(e.getSource() == cb3) {
                input = 2;
                Queue = cb3.getSelectedIndex() - 1;
                t1.setForeground(Color.red);
                t1.setText("Введите значение поля");
            }
            if(e.getSource() == cb4) {
                input = 3;
                Queue = cb4.getSelectedIndex() - 1;
                t1.setForeground(Color.red);
                t1.setText("Введите значение поля");
            }
            if(e.getSource() == cb5) {
                input = 4;
                Queue = cb5.getSelectedIndex() - 1;
                t1.setForeground(Color.red);
                t1.setText("Введите значение поля");
            }
            if(e.getSource() == cb6) {
                input = 5;
                Queue = cb5.getSelectedIndex() - 1;
                t1.setForeground(Color.red);
                t1.setText("Введите значение поля");
            }
            if(e.getSource() == cb7) {
                input = 6;
                Queue = cb7.getSelectedIndex() - 1;
                t1.setForeground(Color.red);
                t1.setText("Введите значение поля");
            }
        }
    }
}
