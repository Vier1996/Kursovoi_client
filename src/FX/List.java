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

public class List extends JFrame {
    JLabel l1, l2 = new JLabel(" "), l3 = new JLabel(" ");
    JComboBox cb1;
    JButton b1;
    private String[] Lis;
    eHandler handler = new eHandler();

    public List(String[] G) {
        super("Меню просмотра пользователей");
        setLayout(new GridLayout(3, 2));
        l1 = new JLabel("Список пользователей и админов.");

        String[] List = new String[G.length + 1];
        Size(G);
        List[0] = " "; Lis[0] = "0";

        for(int i = 1; i < List.length; i++) {
            this.Lis[i] = G[i - 1].split(" ")[2];
            List[i] = G[i - 1].split(" ")[0];
        }


        cb1 = new JComboBox(List);
        b1 = new JButton("закрыть");

        add(l1);
        add(l2);
        add(cb1);
        add(l3);
        add(b1);

        cb1.addActionListener(handler);
        b1.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(250,190);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void Size(String[] K) {
        this.Lis = new String[K.length + 1];
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == cb1) {
                String message = "пользователь";
                if(Lis[cb1.getSelectedIndex()].equals("1"))
                    message = "администратор";
                l3.setText(message);
            }
            if(e.getSource() == b1) { dispose(); }
        }
    }
}
