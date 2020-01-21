package FX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class Disconect extends JFrame {
    JButton b1 = new JButton("disconect");
    eHandler handler = new eHandler();
    Socket Sock;

    public Disconect() {
        super("Disconect");
        setLayout(new GridLayout(1, 1));

        add(b1);

        b1.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(250,200);
        setResizable(false);
        setLocation(850,0);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                dispose();
            }
        }
    }
}
