package FX.RDA_users;

import Tools.Deshifr;
import Tools.Shifr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Red_U extends JFrame {
    JLabel l1, l2, l3, l4 = new JLabel(" ");
    JTextField t1, t2;
    JComboBox cb1;
    String[] Usrs, names;
    JButton b1, b2;
    JRadioButton rb1 = new JRadioButton("Админ"), rb2 = new JRadioButton("Пользователь");
    ButtonGroup group = new ButtonGroup();
    eHandler handler = new eHandler();
    BufferedWriter Wr;
    BufferedReader Rd;

    public Red_U(BufferedWriter W, BufferedReader R) throws IOException {
        super("Red_User");
        setLayout(new GridLayout(5,2));
        Usrs = R.readLine().split("/");
        names = new String[Integer.parseInt(Usrs[Usrs.length - 1])];
        Wr = W;
        Catch();

        l1 = new JLabel("Выребите пользователя.");
        l2 = new JLabel("Измените логин");
        l3 = new JLabel("Измените пароль");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        cb1 = new JComboBox(names);
        b1 = new JButton("Подтвердить");
        b2 = new JButton("Вернутся назад");
        group.add(rb1);
        group.add(rb2);

        add(l1);
        add(cb1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(rb1);
        add(rb2);
        add(b1);
        add(b2);
        cb1.addActionListener(handler);
        b1.addActionListener(handler);
        b2.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,250);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void Catch() throws IOException {
        for(int i = 0; i < Usrs.length - 1; i++) {
            names[i] = Usrs[i].split(" ")[0];
        }
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
                    int is_Admin = 0;
                    if(rb1.isSelected())
                        is_Admin = 1;

                    String Izm = t1.getText() + " " + Shifr.SHFR(t2.getText()) + " " + Integer.toString(is_Admin) + " " + cb1.getSelectedIndex(), Output = "";
                    /**/
                    try {
                        Wr.write(Izm + "\n");
                        Wr.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    /**/
                    dispose();
                }
            }
            if(e.getSource() == b2) {
                try {
                    Wr.write("back\n");
                    Wr.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                /**/
                dispose();
            }
            if(e.getSource() == cb1) {
                String[] SHOW = Usrs[cb1.getSelectedIndex()].split(" ");
                t1.setText(SHOW[0]);
                t2.setText(Deshifr.DESHFR(SHOW[1]));
            }
        }
    }
}
