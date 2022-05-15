import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun May 15 00:44:15 CEST 2022
 */



/**
 * @author Porkoláb Zoltán
 */
public class Start extends JFrame {

    public int playerNum;

    public Start() {
        initComponents();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void startButtonEvent(ActionEvent e) {
        if (!playersComboBox.getSelectedItem().equals("Select")){
            setVisible(false);
            dispose();
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
        playerNum= Integer.parseInt(playersComboBox.getSelectedItem().toString());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sailors Knot
        multiLayerPane = new JLayeredPane();
        topPanel = new JPanel();
        titleLabel = new JLabel();
        actionPanel = new JPanel();
        startButton = new JButton();
        playersLabel = new JLabel();
        playersComboBox = new JComboBox<>();
        backgroundPanel = new JPanel();
        backgroundLabel = new JLabel();

        //======== this ========
        setTitle("Lost Virologists");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(650, 330));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== multiLayerPane ========
        {

            //======== topPanel ========
            {
                topPanel.setBackground(new Color(60, 63, 65, 0));
                topPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
                EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
                . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
                java. awt. Color. red) ,topPanel. getBorder( )) ); topPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
                { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
                throw new RuntimeException( ); }} );
                topPanel.setLayout(new MigLayout(
                    "fill,hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[117]" +
                    "[194]"));

                //---- titleLabel ----
                titleLabel.setText("Lost Virologists");
                titleLabel.setFont(new Font("Snap ITC", Font.PLAIN, 30));
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                titleLabel.setForeground(new Color(204, 204, 204));
                topPanel.add(titleLabel, "cell 0 0,dock center");

                //======== actionPanel ========
                {
                    actionPanel.setBackground(new Color(60, 63, 65, 0));
                    actionPanel.setLayout(new MigLayout(
                        "filly,hidemode 3,align center center",
                        // columns
                        "[167,fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]"));

                    //---- startButton ----
                    startButton.setText("Start");
                    startButton.setFont(new Font("Snap ITC", Font.PLAIN, 16));
                    startButton.setForeground(new Color(204, 204, 204));
                    startButton.setBackground(new Color(51, 51, 51));
                    startButton.addActionListener(e -> startButtonEvent(e));
                    actionPanel.add(startButton, "cell 0 0");

                    //---- playersLabel ----
                    playersLabel.setText("Number of players");
                    playersLabel.setFont(new Font("Snap ITC", Font.PLAIN, 14));
                    playersLabel.setForeground(new Color(204, 204, 204));
                    actionPanel.add(playersLabel, "cell 0 1,alignx center,growx 0");

                    //---- playersComboBox ----
                    playersComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Select",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6",
                        "7",
                        "8"
                    }));
                    playersComboBox.setForeground(new Color(204, 204, 204));
                    playersComboBox.setBackground(new Color(51, 51, 51));
                    playersComboBox.addActionListener(e -> playersComboBoxEvent(e));
                    actionPanel.add(playersComboBox, "cell 0 2");
                }
                topPanel.add(actionPanel, "cell 0 1");
            }
            multiLayerPane.add(topPanel, JLayeredPane.DEFAULT_LAYER);
            topPanel.setBounds(0, 0, 650, 300);

            //======== backgroundPanel ========
            {
                backgroundPanel.setLayout(new BorderLayout());

                //---- backgroundLabel ----
                backgroundLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Fields/openingPicture.png")));
                backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
                backgroundPanel.add(backgroundLabel, BorderLayout.CENTER);
            }
            multiLayerPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
            backgroundPanel.setBounds(0, 0, 650, 300);
        }
        contentPane.add(multiLayerPane, BorderLayout.CENTER);
        setSize(650, 330);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sailors Knot
    private JLayeredPane multiLayerPane;
    private JPanel topPanel;
    private JLabel titleLabel;
    private JPanel actionPanel;
    private JButton startButton;
    private JLabel playersLabel;
    private JComboBox<String> playersComboBox;
    private JPanel backgroundPanel;
    private JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
