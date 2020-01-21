package FX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main_menu extends JFrame {
    JTextField t1, t2;
    JLabel l1, l2, l3, l4, spaces, clse;
    JButton b1, b2, b3;
    public int is_Reg;
    eHandler handler = new eHandler();

    public Main_menu() {
        super("Меню входа в программу.");
        setLayout(new FlowLayout());
        spaces = new JLabel("---------------------------------------------------------");
        clse = new JLabel("");
        l1 = new JLabel("Добро пожаловать, выберите что-то.");
        l2 = new JLabel("Зарегистрироватся");
        l3 = new JLabel("Войти в аккаунт");
        l4 = new JLabel("Выход из программы");
        b1 = new JButton("регистрация");
        b2 = new JButton("автороризация");
        b3 = new JButton("выход");
        /* setBounds() */

        add(l1);
        add(spaces);
        add(l2);
        add(b1);
        add(l3);
        add(b2);
        add(l4);
        add(b3);
        b1.addActionListener(handler);
        b2.addActionListener(handler);
        b3.addActionListener(handler);
        add(clse);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,200);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                is_Reg = 1;
                dispose();
            }
            else {
                if(e.getSource() == b2) {
                    is_Reg = 0;
                    dispose();
                }
                else {
                    is_Reg = -1;
                    dispose();
                }
            }
        }
    }
}
