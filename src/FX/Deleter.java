package FX;

import Tools.Shifr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Deleter extends JFrame {
    JButton b1, b2;
    JComboBox cb1;
    JLabel l1, l2, l3;
    eHandler handler = new eHandler();
    BufferedWriter Wr;
    String[] Or;

    public Deleter(BufferedWriter W, String[] Org, String T) {
        super("Deleter");
        Wr = W;
        Or = Org;
        setLayout(new GridLayout(3, 2));
        cb1 = new JComboBox(Org);
        if(T.equals(""))
            l1 = new JLabel("Выберите удаляемую организацию");
        else
            l1 = new JLabel("Укажите банкрота");
        b1 = new JButton("Указать");
        l2 = new JLabel("");
        l3 = new JLabel("");
        b2 = new JButton("Отменить");

        add(l1);
        add(l2);
        add(cb1);
        add(l3);
        add(b1);
        add(b2);

        b1.addActionListener(handler);
        b2.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(250,200);
        setResizable(false);
        setLocation(150,150);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                try {
                    Wr.write(Or[cb1.getSelectedIndex()] + "\n");
                    Wr.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
            if(e.getSource() == b2) {
                try {
                    Wr.write("back\n");
                    Wr.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        }
    }
}
