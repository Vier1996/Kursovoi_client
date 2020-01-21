package FX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SelfDestroy extends JFrame {
    JLabel l1 = new JLabel("Вы уверены что хотите удалить свой аккаунт?"), l2 = new JLabel(" ");
    JButton b1 = new JButton("Да"), b2 = new JButton("Нет");
    eHandler handler = new eHandler();
    BufferedWriter W;
    private String login = "";

    public SelfDestroy(String L, BufferedWriter wr) {
        super("Destroyer");
        W = wr;
        setLayout(new GridLayout(2, 2));
        login = L;

        add(l1);
        add(l2);
        add(b1);
        add(b2);

        b1.addActionListener(handler);
        b2.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(250,190);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                try {
                    W.write(login + "\n");
                    W.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
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
