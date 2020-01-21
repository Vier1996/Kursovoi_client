package FX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_menu_tools_cmp extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JButton b1, b2, b3;
    eHandler handler = new eHandler();
    public int choice = 0;

    public Admin_menu_tools_cmp() {
        super("Меню редактирования организаций");
        setLayout(new GridLayout(4, 2));
        l1 = new JLabel("Добавить новую организацию");
        l2 = new JLabel("Изменить данные организации");
        l3 = new JLabel("Удалить организацию");
        l4 = new JLabel("");
        b1 = new JButton("добавить");
        b2 = new JButton("редактировать");
        b3 = new JButton("удалить");

        l7 = new JLabel("Редактивирование организации.");

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
                choice = 1;
                dispose();
            }
            if(e.getSource() == b2) {
                choice = 2;
                dispose();
            }
            if(e.getSource() == b3) {
                choice = 3;
                dispose();
            }
        }
    }
}
