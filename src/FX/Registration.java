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

public class Registration extends JFrame {
    JTextField t1, t2;
    JLabel l1, l2, l3;
    JButton b1, b2;
    BufferedWriter W;
    eHandler handler = new eHandler();

    public Registration(BufferedWriter Wr) throws IOException {
        super("Меню регистрации");
        setLayout(new FlowLayout());
        W = Wr;
        l1 = new JLabel("Придумайте логин");
        l2 = new JLabel("Придумайте пароль");
        l3 = new JLabel("");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        b1 = new JButton("Зарегистрироватся");
        b2 = new JButton("Вернутся назад");
        /* setBounds() */

        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(l3);
        b1.addActionListener(handler);
        b2.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,150);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public boolean isEmpty(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') return false;
        }
        return true;
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                String log = t1.getText(), Pass = t2.getText();
                try {

                    if(!isEmpty(log) || !isEmpty(Pass)) {
                        l3.setText("Неверное заполнение полей");
                        l3.setForeground(Color.red);
                        t2.setText("");
                        t1.setText("");
                    }
                    else {
                        if(t2.getText().length() < 6) {
                            l3.setText("Длина пароля должна быть > 6 символов.");
                            l3.setForeground(Color.red);
                            t2.setText("");
                        }
                        else {
                            W.write(t1.getText() + " " + Shifr.SHFR(t2.getText()) + " 0\n");
                            W.flush();
                            dispose();
                        }
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getSource() == b2) {
                try {
                    W.write("back\n");
                    W.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        }
    }
}
