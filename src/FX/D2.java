package FX;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

class D2 extends JDialog {

    public D2( String title, String S ) {
        super();
        setContentPane(createDemoPanel( S ));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private static PieDataset createDataset( String S ) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        String[] Cpr = S.split("/");
        double d = 0;
        d += Double.parseDouble(Cpr[0].split(" ")[1]) + Double.parseDouble(Cpr[0].split(" ")[1]);
        dataset.setValue( Cpr[0].split(" ")[0] , new Double( (Double.parseDouble(Cpr[0].split(" ")[1])) / d * 100 ) );
        dataset.setValue( Cpr[1].split(" ")[0] , new Double( (Double.parseDouble(Cpr[1].split(" ")[1])) / d * 100 ) );
        return dataset;
    }

    private static JFreeChart createChart( PieDataset dataset ) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Сравнение",   // chart title
                dataset,          // data
                true,             // include legend
                true,
                false);

        return chart;
    }

    public static JPanel createDemoPanel( String S ) {
        JFreeChart chart = createChart(createDataset( S ) );
        return new ChartPanel( chart );
    }

}