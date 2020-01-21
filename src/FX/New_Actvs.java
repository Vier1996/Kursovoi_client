package FX;

import Tools.Shifr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class New_Actvs extends JFrame {
    JComboBox cb1;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3;
    JButton b1 = new JButton("Подтвердить."), b2 = new JButton("отменить");
    eHandler handler = new eHandler();
    private BufferedWriter Wr;
    public New_Actvs(BufferedReader R, BufferedWriter W) throws IOException {
        super("New_Actvs");
        Wr = W;
        String[] S = R.readLine().split("/");
        cb1 = new JComboBox(S);
        setLayout(new GridLayout(5, 2));

        l1 = new JLabel("Название актива.");
        l2 = new JLabel("Стоимость актива.");
        l3 = new JLabel("Стаж актива.");
        l4 = new JLabel("Укажите организацию.");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);


        add(l4);
        add(cb1);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3 );
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

    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) || str.charAt(i) == ' ') return false;
        }
        return true;
    }

    public boolean isString(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) || str.charAt(i) == ' ') return false;
        }
        return true;
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                if(!isString(t1.getText()) || !isNumber(t2.getText()) || !isNumber(t3.getText())) {
                    String Error = "Вы ввели некоректные данные!";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    String Output = "";
                    Output += cb1.getItemAt(cb1.getSelectedIndex()) + " " + t1.getText() + " " + t2.getText() + " " + t3.getText();
                    try {
                        Wr.write(Output + "\n");
                        Wr.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
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
                dispose();
            }
        }
    }
}
