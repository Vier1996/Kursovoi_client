package FX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Contract extends JFrame {
    JLabel l1 = new JLabel("Контракт о передаче прав."), l4 = new JLabel(" ");
    JLabel l2 = new JLabel("Кто продает.");
    JLabel l3 = new JLabel("Кто покупает.");
    JComboBox cb1, cb2;
    JButton b1 = new JButton("Подтвердить."), b2 = new JButton("отменить");
    BufferedWriter Wr;
    eHandler handler = new eHandler();

    public Contract(BufferedReader R, BufferedWriter W) throws IOException {
        super("Contract");
        setLayout(new GridLayout(4, 2));
        Wr = W;
        String[] Names = R.readLine().split("/");
        cb1 = new JComboBox(Names);
        cb2 = new JComboBox(Names);


        add(l1);
        add(l4);
        add(l2);
        add(l3);
        add(cb1);
        add(cb2);
        add(b1);
        add(b2);
        b1.addActionListener(handler);
        b2.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300,200);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                if(cb1.getSelectedIndex() == cb2.getSelectedIndex()) {
                    JOptionPane.showMessageDialog(null, "Это бессмысленно, проверьте данные!", "Output", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    try {
                        Wr.write(cb1.getItemAt(cb1.getSelectedIndex()) + " " + cb2.getItemAt(cb2.getSelectedIndex()) + "\n");
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
