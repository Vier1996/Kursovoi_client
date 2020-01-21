package FX.RDA_users;

import FX.User_menu;
import Tools.Deshifr;
import Tools.Shifr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Delete_U extends JFrame {
    JLabel l1 = new JLabel("Выберите пользователя.");
    JComboBox cb1;
    JButton b1 = new JButton("Удалить");
    String[] Usrs, names;
    BufferedReader R;
    BufferedWriter W;
    eHandler handler = new eHandler();

    public Delete_U(BufferedReader rd, BufferedWriter wr) throws IOException {
        super("Delete");
        R = rd;
        W = wr;
        setLayout(new GridLayout(3,1));

        Usrs = R.readLine().split("/");
        names = new String[Integer.parseInt(Usrs[Usrs.length - 1])];

        Catch();
        cb1 = new JComboBox(names);

        add(l1);
        add(cb1);
        add(b1);
        b1.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300,250);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void Catch() throws IOException {
        for(int i = 0; i < Usrs.length - 1; i++) {
            names[i] = Usrs[i].split(" ")[0];
        }
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                try {
                    W.write(cb1.getSelectedIndex() + "\n");
                    W.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        }
    }
}
