package FX;

import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;

public class Compare extends JFrame {
    JLabel l1 = new JLabel(" "), l2 = new JLabel(" "), l3 = new JLabel(" ");
    JLabel[] L = new JLabel[8];
    JLabel[][] ORGZ;
    JLabel[][] ORGZ1;
    JComboBox cb1, cb2;
    JButton b1 = new JButton("Закрыть.");
    String[] Names;
    int size = 0;
    int Prov = 0;
    D2 demo;
    private int FC = 0, SC = 0;
    eHandler handler = new eHandler();

    public Compare(BufferedReader R) throws IOException {
        super("Compare");
        Init(R.readLine());
        setLayout(new GridLayout(10, 3));

        cb1 = new JComboBox(Names);
        cb2 = new JComboBox(Names);

        L[0] = new JLabel("Текущие активы.");
        L[1] = new JLabel("Общая сумма активов.");
        L[2] = new JLabel("Нераспределенная прибыль.");
        L[3] = new JLabel("Прибыль до уплаты налогов.");
        L[4] = new JLabel("Рыночная стоимость акцион. капитала.");
        L[5] = new JLabel("Краткосрочные обязательства.");
        L[6] = new JLabel("Выручка от реализации.");
        L[7] = new JLabel("Коефициент.");

        add(l1);
        add(cb1);
        add(cb2);

        for(int j = 0; j < 8; j++) {
            add(L[j]);
            add(ORGZ1[0][j + 1]);
            add(ORGZ1[1][j + 1]);
        }

        add(l2);
        add(b1);
        add(l3);

        cb1.addActionListener(handler);
        cb2.addActionListener(handler);
        b1.addActionListener(handler);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(570,700);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void Init(String O) {
        String[] Orgz = O.split("/");
        size = Orgz.length;
        Names = new String[size];

        for(int i = 0; i < size; i++) {
            Names[i] = Orgz[i].split(" ")[0];
        }

        ORGZ = new JLabel[size][9];
        ORGZ1 = new JLabel[2][9];

        for(int i = 0; i < size; i++) {
            String[] Dev = Orgz[i].split(" ");
            for(int j = 0; j < 9; j++) {
                ORGZ[i][j] = new JLabel(Dev[j]);
            }
        }

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 9; j++) {
                this.ORGZ1[i][j] = new JLabel("-");
            }
        }
    }

    void Com() {
        if(Prov > 2)
            demo.dispose();
        for (int i = 1; i < 9; i++) {
            if (Double.parseDouble(ORGZ1[0][i].getText()) > Double.parseDouble(ORGZ1[1][i].getText())) {
                ORGZ1[0][i].setForeground(Color.green);
                ORGZ1[1][i].setForeground(Color.red);
                FC++;
            } else {
                if (Double.parseDouble(ORGZ1[0][i].getText()) < Double.parseDouble(ORGZ1[1][i].getText())) {
                    ORGZ1[1][i].setForeground(Color.green);
                    ORGZ1[0][i].setForeground(Color.red);
                    SC++;
                } else {
                    ORGZ1[0][i].setForeground(Color.blue);
                    ORGZ1[1][i].setForeground(Color.blue);
                    FC++;
                    SC++;
                }
            }
        }
        String OUT = "";
        OUT += ORGZ1[0][0].getText() + " " + Integer.toString(FC) + "/" + ORGZ1[1][0].getText() + " " + Integer.toString(SC);
        System.out.println(OUT);
        demo = new D2( "Mobile Sales" , OUT);
        demo.setSize( 560 , 367 );
        RefineryUtilities.centerFrameOnScreen( demo );
        demo.setVisible( true );
        demo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == cb1) {
                int indx = cb1.getSelectedIndex();
                FC = 0;
                SC = 0;
                for(int i = 0; i < 9; i++) {
                    ORGZ1[0][i].setText(ORGZ[indx][i].getText());
                }
                Prov++;
                if(Prov >= 2)
                    Com();
            }
            if(e.getSource() == cb2) {
                int indx = cb2.getSelectedIndex();
                FC = 0;
                SC = 0;
                for(int i = 0; i < 9; i++) {
                    ORGZ1[1][i].setText(ORGZ[indx][i].getText());
                }
                Prov++;
                if(Prov >= 2)
                    Com();
            }
            if(e.getSource() == b1) {
                dispose();
            }
        }
    }
}
