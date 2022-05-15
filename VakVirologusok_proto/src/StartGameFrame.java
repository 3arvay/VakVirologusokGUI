import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat May 14 23:24:39 CEST 2022
 */



/**
 * @author Porkoláb Zoltán
 */
public class StartGameFrame extends JFrame {

    public int playerNum;

    public StartGameFrame() {
        initComponents();

        setVisible(true);
    }

    private void startButtonEvent(ActionEvent e) {
        if (!playersComboBox.getSelectedItem().equals("Select")){
            setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(new Frame(), "Please select a valid player number");
        }

    }

    private void playersComboBoxEvent(ActionEvent e) {
        if (playersComboBox.getSelectedItem().equals("Select")){
            JOptionPane.showMessageDialog(new Frame(), "Please select a valid player number");
            return;
        }
        playerNum=(int)playersComboBox.getSelectedItem();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Porkoláb Zoltán
        mainFrame = new JFrame();
        mainPane = new JLayeredPane();
        topPanel = new JPanel();
        titleLabel = new JLabel();
        buttonPanel = new JPanel();
        startButton = new JButton();
        playersLabel = new JLabel();
        playersComboBox = new JComboBox();
        backgroudPanel = new JPanel();
        backgroundLabel = new JLabel();

        //======== mainFrame ========
        {
            mainFrame.setTitle("Lost Virologists");
            var mainFrameContentPane = mainFrame.getContentPane();
            mainFrameContentPane.setLayout(new BorderLayout());

            //======== mainPane ========
            {

                //======== topPanel ========
                {
                    topPanel.setBackground(new Color(60, 63, 65, 0));
                    topPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
                    .EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax
                    .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,
                    12),java.awt.Color.red),topPanel. getBorder()));topPanel. addPropertyChangeListener(new java.beans
                    .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.
                    getPropertyName()))throw new RuntimeException();}});
                    topPanel.setLayout(new MigLayout(
                        "fill,hidemode 3",
                        // columns
                        "[fill]",
                        // rows
                        "[105]" +
                        "[202]"));

                    //---- titleLabel ----
                    titleLabel.setText("Lost Virologists");
                    titleLabel.setFont(new Font("Snap ITC", Font.BOLD, 30));
                    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    topPanel.add(titleLabel, "cell 0 0");

                    //======== buttonPanel ========
                    {
                        buttonPanel.setBackground(new Color(60, 63, 65, 0));
                        buttonPanel.setLayout(new MigLayout(
                            "hidemode 3,alignx center",
                            // columns
                            "[179,fill]",
                            // rows
                            "[]" +
                            "[24]unrel" +
                            "[]0" +
                            "[]"));

                        //---- startButton ----
                        startButton.setText("Start");
                        startButton.setFont(new Font("Snap ITC", Font.PLAIN, 12));
                        startButton.addActionListener(e -> startButtonEvent(e));
                        buttonPanel.add(startButton, "cell 0 1");

                        //---- playersLabel ----
                        playersLabel.setText("Number of players");
                        playersLabel.setFont(new Font("Snap ITC", Font.PLAIN, 12));
                        buttonPanel.add(playersLabel, "cell 0 2");

                        //---- playersComboBox ----
                        playersComboBox.setFont(new Font("Snap ITC", Font.PLAIN, 12));
                        playersComboBox.addActionListener(e -> playersComboBoxEvent(e));
                        buttonPanel.add(playersComboBox, "cell 0 3");
                    }
                    topPanel.add(buttonPanel, "cell 0 1,dock center");
                }
                mainPane.add(topPanel, JLayeredPane.DEFAULT_LAYER);
                topPanel.setBounds(0, 0, 650, 300);

                //======== backgroudPanel ========
                {
                    backgroudPanel.setLayout(new BorderLayout());

                    //---- backgroundLabel ----
                    backgroundLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Fields/openingPicture.png")));
                    backgroudPanel.add(backgroundLabel, BorderLayout.CENTER);
                }
                mainPane.add(backgroudPanel, JLayeredPane.DEFAULT_LAYER);
                backgroudPanel.setBounds(0, 0, 650, 300);
            }
            mainFrameContentPane.add(mainPane, BorderLayout.CENTER);
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(mainFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Porkoláb Zoltán
    private JFrame mainFrame;
    private JLayeredPane mainPane;
    private JPanel topPanel;
    private JLabel titleLabel;
    private JPanel buttonPanel;
    private JButton startButton;
    private JLabel playersLabel;
    private JComboBox playersComboBox;
    private JPanel backgroudPanel;
    private JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
