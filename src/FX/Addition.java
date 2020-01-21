package FX;

import FX.Addition_tables.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;

public class Addition extends JFrame {
    JLabel l1 = new JLabel("Выберите параметры добавления."), l2 = new JLabel(" ");
    JButton b1 = new JButton("подтвердить"), b2 = new JButton("отмена");
    BufferedWriter Wr;
    Organization orgW;
    Activity actW;
    Concurents concW;
    Expenses expW;
    Income incW;
    Activities activW;
    Shareholders shrW;
    public static String[] orgz = new String[7], conc = new String[2], actv = new String[2], inc = new String[4],
                    exp = new String[5], actvs = new String[3], shr = new String[3];

    public static int counter = 0;
    eHandler handler = new eHandler();

    public Addition(String S, BufferedWriter W) {
        super(S);
        setLayout(new GridLayout(2, 1));
        Wr = W;

        add(l1);
        add(l2);
        add(b1);
        add(b2);
        b1.addActionListener(handler);
        b2.addActionListener(handler);

        Call_to_tables();

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700,200);
        setLocation(300,200);
    }

    void Call_to_tables() {
        orgW = new Organization();
        actW = new Activity();
        concW = new Concurents();
        expW = new Expenses();
        incW = new Income();
        activW = new Activities();
        shrW = new Shareholders();
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                if(counter == 7) {
                    String OUTPUT = "";
                    for(int i = 0; i < orgz.length; i++) {
                        OUTPUT += orgz[i] + "/";
                    }
                    OUTPUT += " // ";
                    for(int i = 0; i < actv.length; i++) {
                        OUTPUT += actv[i] + "/";
                    }
                    OUTPUT += " // ";
                    for(int i = 0; i < conc.length; i++) {
                        OUTPUT += conc[i] + "/";
                    }
                    OUTPUT += " // ";
                    for(int i = 0; i < inc.length; i++) {
                        OUTPUT += inc[i] + "/";
                    }
                    OUTPUT += " // ";
                    for(int i = 0; i < exp.length; i++) {
                        OUTPUT += exp[i] + "/";
                    }
                    OUTPUT += " // ";
                    for(int i = 0; i < actvs.length; i++) {
                        OUTPUT += actvs[i] + "/";
                    }
                    OUTPUT += " // ";
                    for(int i = 0; i < shr.length; i++) {
                        OUTPUT += shr[i] + "/";
                    }
                    try {
                        Wr.write(OUTPUT + "\n");
                        Wr.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    counter = 0;
                    dispose();
                }
                else {
                    String Error = "Вы не заполнили ещё " + Integer.toString(7 - counter) + " таблиц.";
                    JOptionPane.showMessageDialog(null, Error, "Output", JOptionPane.PLAIN_MESSAGE);
                }

            }
            if(e.getSource() == b2) {
                try {
                    Wr.write("back\n");
                    Wr.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                orgW.dispose();
                actW.dispose();
                concW.dispose();
                expW.dispose();
                incW.dispose();
                activW.dispose();
                shrW.dispose();
                dispose();
            }
        }
    }
}
