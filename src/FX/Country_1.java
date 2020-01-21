package FX;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

class Country_2 extends JDialog {

    public Country_2( String title, String S ) {
        super();
        setContentPane(createDemoPanel( S ));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private static PieDataset createDataset( String S ) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        String[] Country = S.split("/");
        double d = 0;
        d += Double.parseDouble(Country[0]) + Double.parseDouble(Country[1]) + Double.parseDouble(Country[2]) +
                Double.parseDouble(Country[3]) + Double.parseDouble(Country[4]);

        dataset.setValue( "Соревнования в беларуси" , new Double( Double.parseDouble(Country[0]) / d * 100 ) );
        dataset.setValue( "Соревнования в британии" , new Double( Double.parseDouble(Country[1]) / d * 100 ) );
        dataset.setValue( "Соревнования во франции" , new Double( Double.parseDouble(Country[2]) / d * 100 ) );
        dataset.setValue( "Соревнования в испаний" , new Double( Double.parseDouble(Country[3]) / d * 100 ) );
        dataset.setValue( "Соревнования в США" , new Double( Double.parseDouble(Country[4]) / d * 100 ) );

        return dataset;
    }

    private static JFreeChart createChart( PieDataset dataset ) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Соотношение соревнований",   // chart title
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