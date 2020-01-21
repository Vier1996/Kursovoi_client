package FX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BD_List_choice extends JFrame {
    JComboBox CB;
    JButton b1;
    public String[] ORGZ;
    public int Choice;
    public String DATA = "";
    eHandler handler = new eHandler();

    public BD_List_choice(String[] O) {
        super("Просмотр данных об оганизации.");
        setLayout(new FlowLayout());
        CB = new JComboBox(O);
        b1 = new JButton("просмотреть");
        add(CB);
        add(b1);
        b1.addActionListener(handler);

        setVisible(true);
        pack();
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                Choice = CB.getSelectedIndex();
                String[] Orgz = DATA.split("//");
                String OUT = "";

                char[] timely = Orgz[Choice].toCharArray();
                for(int i = 0; i < timely.length; i++) {
                    if(Character.toString(timely[i]).equals("/")) {
                        OUT += "\n";
                    }
                    else {
                        OUT += Character.toString(timely[i]);
                    }
                }

                BD_List DBL = new BD_List("asd", OUT);
            }
        }
    }
}
