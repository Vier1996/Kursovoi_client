package FX;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Model_of_Bank extends JFrame {
    JLabel l1 = new JLabel("Текущие активы.");
    JLabel l2 = new JLabel("Общая сумма активов.");
    JLabel l3 = new JLabel("Нераспределенная прибыль.");
    JLabel l4 = new JLabel("Прибыль до уплаты налогов.");
    JLabel l6 = new JLabel("Рыночная стоимость акцион. капитала.");
    JLabel l7 = new JLabel("Краткосрочные обязательства.");
    JLabel l8 = new JLabel("Выручка от реализации.");
    JLabel l9 = new JLabel("Коефициент.");
    JLabel l10 = new JLabel(" ");
    JLabel[][] ORGZ;
    D1 demo;
    int[] Dia = new int[] {0, 0, 0, 0};
    int size = 0;


    public Model_of_Bank(BufferedReader R, String T) throws IOException {
        super("list");
        Init(R.readLine());
        setLayout(new GridLayout(size + 1, 9));

        if(T.equals("Advice"))
            setTitle("Топ компаний в которые выгодно вложится.");

        add(l10);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l6);
        add(l7);
        add(l8);
        add(l9);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < 9; j++) {
                add(ORGZ[i][j]);
            }
            ORGZ[i][0].setForeground(Color.blue);
            if(Double.parseDouble(ORGZ[i][8].getText()) < 1.81) {
                ORGZ[i][8].setForeground(Color.red);
                Dia[3]++;
            }
            else
                if(Double.parseDouble(ORGZ[i][8].getText()) >= 1.81 && Double.parseDouble(ORGZ[i][8].getText()) < 2.7) {
                    ORGZ[i][8].setForeground(Color.orange);
                    Dia[2]++;
                }
                else
                    if(Double.parseDouble(ORGZ[i][8].getText()) >= 2.7 && Double.parseDouble(ORGZ[i][8].getText()) < 2.99) {
                        ORGZ[i][8].setForeground(Color.yellow);
                        Dia[1]++;
                    }
                    else {
                        ORGZ[i][8].setForeground(Color.green);
                        Dia[0]++;
                    }

        }

        String OUT = "";
        OUT += "Полные_банкроты " + Dia[3] + "/Очень_близки_к_банкротству " + Dia[2] + "/Более-менее_платежеспособные " + Dia[1] + "/Не_банкроты " + Dia[0];
        demo = new D1( "Mobile Sales" , OUT);
        demo.setSize( 560 , 367 );
        RefineryUtilities.centerFrameOnScreen( demo );
        demo.setVisible( true );
        demo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1100, 350);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void Init(String O) {
        String[] Orgz = O.split("/");
        size = Orgz.length;
        ORGZ = new JLabel[size][9];
        for(int i = 0; i < size; i++) {
            String[] Dev = Orgz[i].split(" ");
            for(int j = 0; j < 9; j++) {
                ORGZ[i][j] = new JLabel(Dev[j]);
            }
        }
    }
}
