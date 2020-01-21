package FX;
import Tools.Deshifr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Autorization extends JFrame {
    public String Log = "", Pass = "";
    JTextField t1;
    JPasswordField p1;
    JLabel l1, l2, l3;
    JButton b1, b2;
    private String Password;
    private BufferedWriter Wr;

    eHandler handler = new eHandler();

    public Autorization(BufferedWriter W) throws IOException {
        super("Меню авторизации");
        setLayout(new FlowLayout());
        Wr = W;
        l1 = new JLabel("Введите логин");
        l2 = new JLabel("Введите пароль");
        p1 = new JPasswordField(10);
        l3 = new JLabel("");
        t1 = new JTextField(10);
        b1 = new JButton("Войти");
        b2 = new JButton("Вернутся назад");

        /* setBounds() */

        add(l1);
        add(l2);
        add(t1);
        add(p1);
        add(b1);
        add(b2);
        add(l3);
        b1.addActionListener(handler);
        b2.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,125);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void BACK() throws IOException {
        Wr.write("back\n");
        Wr.flush();
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
                Password = new String(p1.getPassword());
                if(!isEmpty(t1.getText()) || !isEmpty(Password)) {
                    try {
                        BACK();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    dispose();
                }
                else {
                    try {
                        Wr.write(t1.getText() + " " + Password + "\n");
                        Wr.flush();
                        dispose();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                /**/
            }
            if(e.getSource() == b2) {
                try {
                    BACK();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        }
    }
}
