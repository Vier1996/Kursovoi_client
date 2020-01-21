package FX.RDA_users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;

public class Add_U extends JFrame {
    JLabel l1, l2, l3, l4 = new JLabel(" ");
    JTextField t1, t2;
    JButton b1, b2;
    BufferedWriter Wr;
    JRadioButton rb1 = new JRadioButton("Админ"), rb2 = new JRadioButton("Пользователь");
    ButtonGroup group = new ButtonGroup();
    eHandler handler = new eHandler();

    public Add_U(BufferedWriter W) {
        super("Addition_user");
        Wr = W;
        setLayout(new GridLayout(5, 2));
        l1 = new JLabel("Добавление нового пользователя");
        l2 = new JLabel("Введите логин пользователя");
        l3 = new JLabel("Введите пароль пользователя");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        b1 = new JButton("Подтвердить");
        b2 = new JButton("Вернутся назад");
        group.add(rb1);
        group.add(rb2);

        add(l1);
        add(l4);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(rb1);
        add(rb2);
        add(b1);
        add(b2);

        b1.addActionListener(handler);
        b2.addActionListener(handler);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(430,150);
        setLocation(500,500);
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
                if(!isEmpty(t1.getText()) || !isEmpty(t2.getText()) || t2.getText().length() < 6) {
                    String Error = "Проверьте коректность введеных данных!";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    String data = "";
                    int is_Admin = 0;

                    if (rb1.isSelected())
                        is_Admin = 1;

                    data += t1.getText() + " ";
                    data += t2.getText() + " ";
                    data += Integer.toString(is_Admin);

                    try {
                        Wr.write(data + "\n");
                        Wr.flush();
                        dispose();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            if(e.getSource() == b2) {
                try {
                    Wr.write("back\n");
                    Wr.flush();
                    dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
