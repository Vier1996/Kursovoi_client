package FX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Emergency extends JFrame {
    JLabel l1 = new JLabel("Аварийное завершение работы программы и пермаментное удаление существующей базы банных.");
    JButton b1 = new JButton("Завершить."), b2 = new JButton("Отменить.");
    private BufferedWriter Wr;
    private int Advice = 1;
    eHandler handler = new eHandler();

    public Emergency(BufferedWriter W) {
        super("Использовать только в крайнем случае!!!");
        setLayout(new FlowLayout());
        Wr = W;

        add(l1);
        add(b1);
        add(b2);

        b1.addActionListener(handler);
        b2.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650,100);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                if(Advice <= 0) {
                    try {
                        Wr.write("Yes\n");
                        Wr.flush();
                        dispose();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    Advice--;
                    JOptionPane.showMessageDialog(null, "Нажав кнопку подтвердить, вы немедленно сотрете все данные и досрочно завершите программу.", "Output", JOptionPane.PLAIN_MESSAGE);
                }
            }
            if(e.getSource() == b2) {
                try {
                    Wr.write("No\n");
                    Wr.flush();
                    dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
