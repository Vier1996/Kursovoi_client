package FX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_menu extends JFrame {
    JButton b1, b2, b3, b5, b6, b7, b8, b9;
    JLabel l1, l2, l3, l5, l6, l7, l8, l9, text, login;
    public int input;
    eHandler handler = new eHandler();

    public Admin_menu(String L) {
        super("Панель администратора");
        setLayout(new GridLayout(9, 2));

        text = new JLabel("Добро пожаловать Бог - ");
        login = new JLabel(L);
        login.setForeground(Color.red);
        l1 = new JLabel("Редактировать клиента.");
        l2 = new JLabel("Редактировать организацию.");
        l3 = new JLabel("Просмотреть организации.");
        l5 = new JLabel("Провести сравнение организаций.");
        l6 = new JLabel("Вывести список польз. и админов.");
        l7 = new JLabel("Нажать только в крайнем случае.");
        l8 = new JLabel("Сохранить значения базы данных.");
        l9 = new JLabel("Загрузить значения базы данных.");

        b1 = new JButton("ред. (пользователей)");
        b2 = new JButton("ред. (базу данных)");
        b3 = new JButton("просм. базу данных");
        b5 = new JButton("сравн. данных базы данных");
        b6 = new JButton("список");
        b7 = new JButton("аварийное завершение");
        b8 = new JButton("сохранить");
        b9 = new JButton("загрузить");

        add(text);
        add(login);
        add(l1);
        add(b1);
        add(l2);
        add(b2);
        add(l3);
        add(b3);
        add(l5);
        add(b5);
        add(l6);
        add(b6);
        add(l7);
        add(b7);
        add(l8);
        add(b8);
        add(l9);
        add(b9);

        b1.addActionListener(handler);
        b2.addActionListener(handler);
        b3.addActionListener(handler);
        b5.addActionListener(handler);
        b6.addActionListener(handler);
        b7.addActionListener(handler);
        b8.addActionListener(handler);
        b9.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450,400);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public class eHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                input = 1;
                dispose();
            }
            if(e.getSource() == b2) {
                input = 2;
                dispose();
            }
            if(e.getSource() == b3) {
                input = 3;
                dispose();
            }
            if(e.getSource() == b5) {
                input = 5;
                dispose();
            }
            if(e.getSource() == b6) {
                input = 6;
                dispose();
            }
            if(e.getSource() == b7) {
                input = 7;
                dispose();
            }
            if(e.getSource() == b8) {
                input = 8;
                dispose();
            }
            if(e.getSource() == b9) {
                input = 9;
                dispose();
            }
        }
    }
}
