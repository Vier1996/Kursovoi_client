package FX.Addition_tables;

import FX.Addition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Expenses extends JFrame {

    String[] data2 = {"Мелкие издержки", "Крупные издержки", "Налоги", "Кредиты", "Внутрение затраты на улучшение"};
    JLabel l1 = new JLabel(data2[0]), l2 = new JLabel(data2[1]), l3 = new JLabel(data2[2]), l4 = new JLabel(data2[3]),
            l5 = new JLabel(data2[4]);
    JTextField t1 = new JTextField(10), t2 = new JTextField(10), t3 = new JTextField(10),
               t4 = new JTextField(10), t5 = new JTextField(10);
    JButton b1 = new JButton("Подтвердить");
    eHandler handler = new eHandler();

    public Expenses() {
        super("Expenses");
        setLayout(new GridLayout(6, 3));

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
        add(b1);
        b1.addActionListener(handler);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,200);
        setLocation(0,200);
    }

    public boolean isDigit(String str, String B) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) || str.charAt(i) == ' ') return false;
        }
        if(B.equals("P"))
            if(Integer.parseInt(str) > 100)
                return false;
        return true;
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {

                if(!isDigit(t1.getText(), "a") || !isDigit(t2.getText(), "a") || !isDigit(t3.getText(), "P") || !isDigit(t4.getText(), "a")
                        || !isDigit(t5.getText(), "a")) {
                    String Error = "Вы заполнили не все поля или ввели некоректные данные!";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);

                }
                else {
                    Addition.exp[0] = t1.getText();
                    Addition.exp[1] = t2.getText();
                    Addition.exp[2] = t3.getText();
                    Addition.exp[3] = t4.getText();
                    Addition.exp[4] = t5.getText();
                    Addition.counter++;
                    dispose();
                }

            }
        }
    }
}
