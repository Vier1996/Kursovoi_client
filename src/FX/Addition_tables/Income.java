package FX.Addition_tables;

import FX.Addition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Income extends JFrame {

    String[] data2 = {"Доход с продажи изделий", "Прибыль", "Доход от сдачи в аренду", "Брендовый налог"};
    JLabel l1 = new JLabel(data2[0]), l2 = new JLabel(data2[1]), l3 = new JLabel(data2[2]), l4 = new JLabel(data2[3]);
    JTextField t1 = new JTextField(10), t2 = new JTextField(10), t3 = new JTextField(10),
            t4 = new JTextField(10);
    JButton b1 = new JButton("Подтвердить");
    eHandler handler = new eHandler();

    public Income() {
        super("Income");
        setLayout(new GridLayout(5, 3));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b1);
        b1.addActionListener(handler);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,200);
        setLocation(0,400);
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

                if(!isDigit(t1.getText(), "r") || !isDigit(t2.getText(), "r") || !isDigit(t3.getText(), "r") ||!isDigit(t4.getText(), "P")) {
                    String Error = "Вы заполнили не все поля или ввели некоректные данные!";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);

                }
                else {
                    Addition.inc[0] = t1.getText();
                    Addition.inc[1] = t2.getText();
                    Addition.inc[2] = t3.getText();
                    Addition.inc[3] = t4.getText();
                    Addition.counter++;
                    dispose();
                }

            }
        }
    }
}
