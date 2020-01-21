package FX.Addition_tables;

import FX.Addition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shareholders extends JFrame {
    String[] data2 = {"Количество акционеров", "Девиденты", "Стоимость акицй на рынке"};
    JLabel l1 = new JLabel(data2[0]), l2 = new JLabel(data2[1]), l3 = new JLabel(data2[2]);
    JTextField t1 = new JTextField(10), t2 = new JTextField(10), t3 = new JTextField(10);
    JButton b1 = new JButton("Подтвердить");
    eHandler handler = new eHandler();

    public Shareholders() {
        super("Activies");
        setLayout(new GridLayout(5, 3));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        b1.addActionListener(handler);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,200);
        setLocation(600,400);
    }

    public boolean isNumber(String str) {
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

                if(!isNumber(t1.getText()) || !isNumber(t2.getText()) || !isNumber(t3.getText())) {
                    String Error = "Вы заполнили не все поля!";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);

                }
                else {
                    Addition.shr[0] = t1.getText();
                    Addition.shr[1] = t2.getText();
                    Addition.shr[2] = t3.getText();
                    Addition.counter++;
                    dispose();
                }

            }
        }
    }
}
