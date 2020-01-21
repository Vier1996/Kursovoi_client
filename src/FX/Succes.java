package FX;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Succes extends JFrame {
    JLabel l1 = new JLabel("Самая успешная организация."), l2 = new JLabel("Самая худшая организация."),
            l3 = new JLabel(""), l4 = new JLabel(""),
             l5 = new JLabel(""), l6 = new JLabel("");

    public Succes(BufferedReader R) throws IOException {
        super("Succes");
        setLayout(new GridLayout(4, 2));
        String info = R.readLine();
        l3.setText(info.split("/")[0].split(" ")[0]);
        l4.setText(info.split("/")[1].split(" ")[0]);

        l5.setText(info.split("/")[0].split(" ")[1]);
        l6.setText(info.split("/")[1].split(" ")[1]);

        l1.setForeground(Color.GREEN);
        l3.setForeground(Color.GREEN);
        l5.setForeground(Color.GREEN);

        l2.setForeground(Color.red);
        l4.setForeground(Color.red);
        l6.setForeground(Color.red);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450,230);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
