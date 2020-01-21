package FX;

import javax.swing.*;

public class BD_List extends JFrame {
    JTextArea TA;
    JScrollPane SP;
    public BD_List(String S, String INFO) {
        super(S);
        TA = new JTextArea(INFO, 10, 95);
        SP = new JScrollPane(TA);

        add(SP);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
    }
}
