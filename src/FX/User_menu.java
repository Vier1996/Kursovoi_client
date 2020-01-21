package FX;

import Tools.Deshifr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class User_menu extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, text, login;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    public int input = 0;
    eHandler handler = new eHandler();

    public User_menu(String L) {
        super("Панель пользователя");
        setLayout(new GridLayout(13,2));

        text = new JLabel("Добро пожаловать: ");
        login = new JLabel(L);
        login.setForeground(Color.blue);
        l1 = new JLabel("Запросить вывести организации.");
        l2 = new JLabel("Запросить вывести пользователей.");
        l3 = new JLabel("Запросить объявление о новой организации");
        l4 = new JLabel("Запросить добавить актуальные данные.");
        l5 = new JLabel("Запросить вывести модель вероятности банкр.");
        l6 = new JLabel("Запросить добавление нового имущества.");
        l7 = new JLabel("Запросить (договор подписание).");
        l8 = new JLabel("Указать компанию банкрота.");
        l9 = new JLabel("Удалить аккаунт.");
        l10 = new JLabel("Запросить вывести ключевые организации.");
        l11 = new JLabel("Запросить вывести список надёжных организаций");
        l12 = new JLabel("Запросить сравнить организации");

        b1 = new JButton("вывод орг.");
        b2 = new JButton("вывод польз.");
        b3 = new JButton("обьявить.");
        b4 = new JButton("добавить.");
        b5 = new JButton("модель банкр.");
        b6 = new JButton("доб. новое имущ.");
        b7 = new JButton("договор");
        b8 = new JButton("указать");
        b9 = new JButton("удалить акк.");
        b10 = new JButton("вывести");
        b11 = new JButton("вывести");
        b12 = new JButton("сравнить");

        add(text);
        add(login);
        add(l1);
        add(b1);
        add(l2);
        add(b2);
        add(l3);
        add(b3);
        add(l4);
        add(b4);
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
        add(l10);
        add(b10);
        add(l11);
        add(b11);
        add(l12);
        add(b12);

        b1.addActionListener(handler);
        b2.addActionListener(handler);
        b3.addActionListener(handler);
        b4.addActionListener(handler);
        b5.addActionListener(handler);
        b6.addActionListener(handler);
        b7.addActionListener(handler);
        b8.addActionListener(handler);
        b9.addActionListener(handler);
        b10.addActionListener(handler);
        b11.addActionListener(handler);
        b12.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,650);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b8) {
                input = 8;
                dispose();
            }
            if(e.getSource() == b5) {
                input = 5;
                dispose();
            }
            if(e.getSource() == b3) {
                input = 3;
                dispose();
            }
            if(e.getSource() == b1) {
                input = 1;
                dispose();
            }
            if(e.getSource() == b2) {
                input = 2;
                dispose();
            }
            if(e.getSource() == b4) {
                input = 4;
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
            if(e.getSource() == b9) {
                input = 9;
                dispose();
            }
            if(e.getSource() == b10) {
                input = 10;
                dispose();
            }
            if(e.getSource() == b11) {
                input = 11;
                dispose();
            }
            if(e.getSource() == b12) {
                input = 12;
                dispose();
            }
        }
    }
}
