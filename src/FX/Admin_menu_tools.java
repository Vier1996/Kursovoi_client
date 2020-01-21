package FX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Admin_menu_tools extends JFrame{

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JButton b1, b2, b3;
    public int Choice = 0;
    eHandler handler = new eHandler();

    public Admin_menu_tools() {
        super("Меню редактирования клиентов");
        setLayout(new GridLayout(4, 2));
        l1 = new JLabel("Добавить нового пользователя.");
        l2 = new JLabel("Изменить пользователя.");
        l3 = new JLabel("Удалить пользователя.");
        l4 = new JLabel("");
        b1 = new JButton("добавить");
        b2 = new JButton("редактировать");
        b3 = new JButton("удалить");

        l7 = new JLabel("Редактивирование клиента.");

        add(l7);
        add(l4);

        add(l1);
        add(b1);

        add(l2);
        add(b2);

        add(l3);
        add(b3);

        b1.addActionListener(handler);
        b2.addActionListener(handler);
        b3.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,200);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public class eHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                Choice = 1;
                dispose();
            }
            if(e.getSource() == b2) {
                Choice = 2;
                dispose();
            }
            if(e.getSource() == b3) {
                Choice = 3;
                dispose();
            }
        }
    }
}
