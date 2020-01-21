package FX.Addition_tables;

import FX.Addition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Concurents extends JFrame {

    String[] data2 = {"Название орг. конкурента", "Стаж конкрента"};
    JLabel l1 = new JLabel(data2[0]), l2 = new JLabel(data2[1]);
    JTextField t1 = new JTextField(10), t2 = new JTextField(10);
    JButton b1 = new JButton("Подтвердить");
    eHandler handler = new eHandler();

    public Concurents() {
        super("Concurents");
        setLayout(new GridLayout(3, 3));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        b1.addActionListener(handler);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,200);
        setLocation(1000,0);
    }

    public boolean isString(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) || str.charAt(i) == ' ') return false;
        }
        return true;
    }

    public boolean isDigit(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) || str.charAt(i) == ' ') return false;
        }
        return true;
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {

                if(!isString(t1.getText()) || !isDigit(t2.getText())) {
                    String Error = "Вы заполнили не все поля или ввели некоректные данные!";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);

                }
                else {
                    Addition.conc[0] = t1.getText();
                    Addition.conc[1] = t2.getText();
                    Addition.counter++;
                    dispose();
                }

            }
        }
    }
}
