import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat May 14 18:12:22 CEST 2022
 */



/**
 * @author Porkoláb Zoltán
 */
public class StartFrame extends JPanel {
    public StartFrame() {
        initComponents();
    }

    private void optionButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void startButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Porkoláb Zoltán
        mainPane = new JLayeredPane();
        topLayer = new JPanel();
        titleLabel = new JLabel();
        buttonsPanel = new JPanel();
        startButton = new JButton();
        optionButton = new JButton();
        backgroundPanel = new JPanel();
        backgroundLabel = new JLabel();

        //======== mainPane ========
        {
            mainPane.setMaximumSize(new Dimension(650, 300));

            //======== topLayer ========
            {
                topLayer.setBackground(new Color(0, 0, 0, 32));
                topLayer.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
                . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing
                .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
                Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
                ) ,topLayer. getBorder () ) ); topLayer. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
                public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName (
                ) ) )throw new RuntimeException( ) ;} } );
                topLayer.setLayout(new MigLayout(
                    "insets 0,hidemode 3,gap 0 0",
                    // columns
                    "[grow,fill]",
                    // rows
                    "[108,fill]" +
                    "[grow,fill]"));

                //---- titleLabel ----
                titleLabel.setText("Lost Virologists");
                titleLabel.setFont(new Font("Snap ITC", Font.BOLD, 36));
                topLayer.add(titleLabel, "cell 0 0,alignx center,growx 0");

                //======== buttonsPanel ========
                {
                    buttonsPanel.setBackground(new Color(0, 0, 0, 0));
                    buttonsPanel.setLayout(new MigLayout(
                        "insets 0,hidemode 3",
                        // columns
                        "[251,fill]",
                        // rows
                        "[fill]" +
                        "[]" +
                        "[14]" +
                        "[]" +
                        "[]" +
                        "[]"));

                    //---- startButton ----
                    startButton.setText("Start game");
                    startButton.setActionCommand("text");
                    startButton.setBackground(new Color(60, 63, 65, 1));
                    startButton.setForeground(Color.lightGray);
                    startButton.setBorderPainted(false);
                    startButton.setFont(new Font("Snap ITC", Font.PLAIN, 15));
                    startButton.addActionListener(e -> startButtonEvent(e));
                    buttonsPanel.add(startButton, "cell 0 1 1 2,wmin 50");

                    //---- optionButton ----
                    optionButton.setText("Options");
                    optionButton.setForeground(Color.lightGray);
                    optionButton.setBorderPainted(false);
                    optionButton.setBackground(new Color(0, 0, 0, 0));
                    optionButton.setFont(new Font("Snap ITC", Font.PLAIN, 15));
                    optionButton.addActionListener(e -> optionButtonEvent(e));
                    buttonsPanel.add(optionButton, "cell 0 3,wmin 50");
                }
                topLayer.add(buttonsPanel, "cell 0 1,alignx center,growx 0");
            }
            mainPane.add(topLayer, JLayeredPane.DEFAULT_LAYER);
            topLayer.setBounds(0, 0, 650, 300);

            //======== backgroundPanel ========
            {
                backgroundPanel.setLayout(new BorderLayout());

                //---- backgroundLabel ----
                backgroundLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Fields/openingPicture.png")));
                backgroundPanel.add(backgroundLabel, BorderLayout.CENTER);
            }
            mainPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
            backgroundPanel.setBounds(0, 0, 650, 300);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Porkoláb Zoltán
    private JLayeredPane mainPane;
    private JPanel topLayer;
    private JLabel titleLabel;
    private JPanel buttonsPanel;
    private JButton startButton;
    private JButton optionButton;
    private JPanel backgroundPanel;
    private JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
