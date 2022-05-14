import java.awt.event.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/*
 * Created by JFormDesigner on Thu May 12 10:08:46 CEST 2022
 */



/**
 * @author unknown
 */
public class LostVirologists extends JFrame {
    public LostVirologists() {
        initComponents();
        initSettings();
    }

    private void initSettings(){

    }
    
    private void moveButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void attackButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void craftButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void stealButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void agentsButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void gearsButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void materialsButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void dropButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Porkoláb Zoltán
        mailPanel = new JPanel();
        leftPanel = new JPanel();
        leftHeaderPanel = new JPanel();
        neighboursLabelPanel = new JPanel();
        neighboursLabel = new JLabel();
        playersLabelPanel = new JPanel();
        virologistsLabel = new JLabel();
        fieldsPanel = new JPanel();
        fieldsComboBox = new JComboBox<>();
        playersPanel = new JPanel();
        playersComboBox = new JComboBox<>();
        fieldPanel = new JPanel();
        fieldLabel = new JLabel();
        rightPanel = new JPanel();
        rightHeaderPanel = new JPanel();
        vattributePanel = new JPanel();
        bearModePanel = new JPanel();
        bearModeLabel = new JLabel();
        dancingPanel = new JPanel();
        dancingLabel = new JLabel();
        stunnedPanel = new JPanel();
        stunnedLabel = new JLabel();
        immunePanel = new JPanel();
        immuneLabel = new JLabel();
        playerIconPanel = new JPanel();
        playerIconLabel = new JLabel();
        itemsPanel = new JPanel();
        agentsButton = new JButton();
        gearsButton = new JButton();
        materialsButton = new JButton();
        detailsPane = new JScrollPane();
        detailTable = new JTable();
        buttonPanel = new JPanel();
        moveButton = new JButton();
        attackButton = new JButton();
        craftButton = new JButton();
        stealButton = new JButton();
        dropButton = new JButton();

        //======== mailPanel ========
        {
            mailPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,mailPanel. getBorder
            ( )) ); mailPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );
            mailPanel.setLayout(new MigLayout(
                "fill,hidemode 3,alignx center",
                // columns
                "[600,fill]" +
                "[237,fill]",
                // rows
                "[]"));

            //======== leftPanel ========
            {
                leftPanel.setForeground(Color.black);
                leftPanel.setBorder(LineBorder.createBlackLineBorder());
                leftPanel.setLayout(new MigLayout(
                    "fill,hidemode 3,align center center",
                    // columns
                    "[600:600]",
                    // rows
                    "[83]" +
                    "[400,fill]"));

                //======== leftHeaderPanel ========
                {
                    leftHeaderPanel.setBackground(Color.darkGray);
                    leftHeaderPanel.setLayout(new MigLayout(
                        "fill,hidemode 3,align center center",
                        // columns
                        "[300,fill]0" +
                        "[300,fill]",
                        // rows
                        "0[19]0" +
                        "[31]0"));

                    //======== neighboursLabelPanel ========
                    {
                        neighboursLabelPanel.setBackground(new Color(204, 204, 204));
                        neighboursLabelPanel.setLayout(new BorderLayout());

                        //---- neighboursLabel ----
                        neighboursLabel.setText("Neighbour fields");
                        neighboursLabel.setForeground(Color.black);
                        neighboursLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        neighboursLabel.setFont(neighboursLabel.getFont().deriveFont(neighboursLabel.getFont().getStyle() | Font.BOLD));
                        neighboursLabel.setBackground(new Color(204, 204, 204));
                        neighboursLabelPanel.add(neighboursLabel, BorderLayout.CENTER);
                    }
                    leftHeaderPanel.add(neighboursLabelPanel, "cell 0 0,dock center,gapy null 0");

                    //======== playersLabelPanel ========
                    {
                        playersLabelPanel.setBackground(new Color(204, 204, 204));
                        playersLabelPanel.setLayout(new BorderLayout());

                        //---- virologistsLabel ----
                        virologistsLabel.setText("Other players here");
                        virologistsLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        virologistsLabel.setForeground(Color.black);
                        virologistsLabel.setFont(virologistsLabel.getFont().deriveFont(virologistsLabel.getFont().getStyle() | Font.BOLD));
                        virologistsLabel.setBackground(new Color(204, 204, 204));
                        playersLabelPanel.add(virologistsLabel, BorderLayout.CENTER);
                    }
                    leftHeaderPanel.add(playersLabelPanel, "cell 1 0,dock center,gapy null 0");

                    //======== fieldsPanel ========
                    {
                        fieldsPanel.setBackground(new Color(204, 204, 204));
                        fieldsPanel.setLayout(new BorderLayout());

                        //---- fieldsComboBox ----
                        fieldsComboBox.setForeground(Color.white);
                        fieldsComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                            "Select a field and press \"Move\""
                        }));
                        fieldsPanel.add(fieldsComboBox, BorderLayout.CENTER);
                    }
                    leftHeaderPanel.add(fieldsPanel, "cell 0 1,gapy 0");

                    //======== playersPanel ========
                    {
                        playersPanel.setBackground(new Color(204, 204, 204));
                        playersPanel.setLayout(new BorderLayout());

                        //---- playersComboBox ----
                        playersComboBox.setForeground(Color.white);
                        playersComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                            "Select a player and press \"Attack\" or \"Steal\""
                        }));
                        playersPanel.add(playersComboBox, BorderLayout.CENTER);
                    }
                    leftHeaderPanel.add(playersPanel, "cell 1 1,gapy 0");
                }
                leftPanel.add(leftHeaderPanel, "cell 0 0");

                //======== fieldPanel ========
                {
                    fieldPanel.setBackground(Color.darkGray);
                    fieldPanel.setLayout(new BorderLayout());

                    //---- fieldLabel ----
                    fieldLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Fields/Laboratory.jpg")));
                    fieldLabel.setBackground(new Color(153, 153, 153));
                    fieldLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                    fieldLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    fieldPanel.add(fieldLabel, BorderLayout.CENTER);
                }
                leftPanel.add(fieldPanel, "cell 0 1,dock center");
            }
            mailPanel.add(leftPanel, "cell 0 0");

            //======== rightPanel ========
            {
                rightPanel.setBackground(new Color(102, 102, 102));
                rightPanel.setBorder(LineBorder.createBlackLineBorder());
                rightPanel.setLayout(new MigLayout(
                    "fill,hidemode 3,align center center",
                    // columns
                    "[250,fill]",
                    // rows
                    "[200]" +
                    "[25]0" +
                    "[166]" +
                    "[90]"));

                //======== rightHeaderPanel ========
                {
                    rightHeaderPanel.setBackground(new Color(153, 153, 153));
                    rightHeaderPanel.setBorder(LineBorder.createBlackLineBorder());
                    rightHeaderPanel.setForeground(Color.darkGray);
                    rightHeaderPanel.setLayout(new MigLayout(
                        "fill,hidemode 3,gap 0 0",
                        // columns
                        "[60,fill]" +
                        "[212,fill]",
                        // rows
                        "[200]" +
                        "[]"));

                    //======== vattributePanel ========
                    {
                        vattributePanel.setBackground(new Color(204, 204, 204));
                        vattributePanel.setLayout(new MigLayout(
                            "fill,align center center,gap 0 0",
                            // columns
                            "[60]",
                            // rows
                            "[50]" +
                            "[50]" +
                            "[50]" +
                            "[50]"));

                        //======== bearModePanel ========
                        {
                            bearModePanel.setBackground(Color.white);
                            bearModePanel.setForeground(Color.white);
                            bearModePanel.setBorder(LineBorder.createBlackLineBorder());
                            bearModePanel.setToolTipText("BearMode");
                            bearModePanel.setLayout(new BorderLayout());

                            //---- bearModeLabel ----
                            bearModeLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/VAttributes/BearMode.png")));
                            bearModeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                            bearModePanel.add(bearModeLabel, BorderLayout.CENTER);
                        }
                        vattributePanel.add(bearModePanel, "cell 0 0,alignx center,growx 0,width 50::50,height 50::50");

                        //======== dancingPanel ========
                        {
                            dancingPanel.setBackground(Color.white);
                            dancingPanel.setBorder(LineBorder.createBlackLineBorder());
                            dancingPanel.setToolTipText("Dancing");
                            dancingPanel.setLayout(new BorderLayout());

                            //---- dancingLabel ----
                            dancingLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/VAttributes/Dancing.png")));
                            dancingLabel.setHorizontalAlignment(SwingConstants.CENTER);
                            dancingPanel.add(dancingLabel, BorderLayout.CENTER);
                        }
                        vattributePanel.add(dancingPanel, "cell 0 1,alignx center,growx 0,width 50::50,height 50::50");

                        //======== stunnedPanel ========
                        {
                            stunnedPanel.setBackground(Color.white);
                            stunnedPanel.setBorder(LineBorder.createBlackLineBorder());
                            stunnedPanel.setToolTipText("Stunned");
                            stunnedPanel.setLayout(new BorderLayout());

                            //---- stunnedLabel ----
                            stunnedLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/VAttributes/Stunned.png")));
                            stunnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
                            stunnedPanel.add(stunnedLabel, BorderLayout.CENTER);
                        }
                        vattributePanel.add(stunnedPanel, "cell 0 2,alignx center,growx 0,width 50::50,height 50::50");

                        //======== immunePanel ========
                        {
                            immunePanel.setBackground(Color.white);
                            immunePanel.setBorder(LineBorder.createBlackLineBorder());
                            immunePanel.setToolTipText("Immune");
                            immunePanel.setLayout(new BorderLayout());

                            //---- immuneLabel ----
                            immuneLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/VAttributes/Immune.png")));
                            immuneLabel.setHorizontalAlignment(SwingConstants.CENTER);
                            immunePanel.add(immuneLabel, BorderLayout.CENTER);
                        }
                        vattributePanel.add(immunePanel, "cell 0 3,alignx center,growx 0,width 50::50,height 50::50");
                    }
                    rightHeaderPanel.add(vattributePanel, "cell 0 0,dock center");

                    //======== playerIconPanel ========
                    {
                        playerIconPanel.setBackground(new Color(204, 204, 204));
                        playerIconPanel.setBorder(LineBorder.createBlackLineBorder());
                        playerIconPanel.setLayout(new BorderLayout());

                        //---- playerIconLabel ----
                        playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/purpleVirologist_icon.png")));
                        playerIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        playerIconPanel.add(playerIconLabel, BorderLayout.CENTER);
                    }
                    rightHeaderPanel.add(playerIconPanel, "cell 1 0,dock center");
                }
                rightPanel.add(rightHeaderPanel, "cell 0 0");

                //======== itemsPanel ========
                {
                    itemsPanel.setAutoscrolls(true);
                    itemsPanel.setBackground(new Color(153, 153, 153));
                    itemsPanel.setBorder(LineBorder.createBlackLineBorder());
                    itemsPanel.setLayout(new GridLayout());

                    //---- agentsButton ----
                    agentsButton.setText("Agents");
                    agentsButton.setForeground(Color.white);
                    agentsButton.setBackground(new Color(153, 153, 153));
                    agentsButton.addActionListener(e -> agentsButtonEvent(e));
                    itemsPanel.add(agentsButton);

                    //---- gearsButton ----
                    gearsButton.setText("Gears");
                    gearsButton.setForeground(Color.white);
                    gearsButton.setBackground(new Color(153, 153, 153));
                    gearsButton.addActionListener(e -> gearsButtonEvent(e));
                    itemsPanel.add(gearsButton);

                    //---- materialsButton ----
                    materialsButton.setText("Materials");
                    materialsButton.setForeground(Color.white);
                    materialsButton.setBackground(new Color(153, 153, 153));
                    materialsButton.addActionListener(e -> materialsButtonEvent(e));
                    itemsPanel.add(materialsButton);
                }
                rightPanel.add(itemsPanel, "cell 0 1,aligny center,growy 0");

                //======== detailsPane ========
                {
                    detailsPane.setForeground(Color.black);
                    detailsPane.setBackground(Color.lightGray);

                    //---- detailTable ----
                    detailTable.setBorder(LineBorder.createBlackLineBorder());
                    detailTable.setBackground(new Color(102, 102, 102));
                    detailTable.setForeground(Color.black);
                    detailTable.setCellSelectionEnabled(true);
                    detailTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    detailTable.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null},
                            {null, null},
                            {null, null},
                            {null, null},
                        },
                        new String[] {
                            "Amount", "Agent"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Integer.class, Object.class
                        };
                        boolean[] columnEditable = new boolean[] {
                            true, false
                        };
                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                            return columnTypes[columnIndex];
                        }
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    detailTable.setSelectionForeground(Color.white);
                    detailTable.setGridColor(Color.black);
                    detailsPane.setViewportView(detailTable);
                }
                rightPanel.add(detailsPane, "cell 0 2,align center center,grow 0 0");

                //======== buttonPanel ========
                {
                    buttonPanel.setBackground(new Color(153, 153, 153));
                    buttonPanel.setBorder(LineBorder.createBlackLineBorder());
                    buttonPanel.setLayout(new MigLayout(
                        "fill,hidemode 3,gap 0 0",
                        // columns
                        "[fill]" +
                        "[fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]"));

                    //---- moveButton ----
                    moveButton.setText("Move");
                    moveButton.setBackground(new Color(153, 153, 153));
                    moveButton.setForeground(Color.white);
                    moveButton.addActionListener(e -> moveButtonEvent(e));
                    buttonPanel.add(moveButton, "cell 0 0 2 1");

                    //---- attackButton ----
                    attackButton.setText("Attack");
                    attackButton.setBackground(new Color(153, 153, 153));
                    attackButton.setForeground(Color.white);
                    attackButton.addActionListener(e -> attackButtonEvent(e));
                    buttonPanel.add(attackButton, "cell 0 1");

                    //---- craftButton ----
                    craftButton.setText("Craft");
                    craftButton.setBackground(new Color(153, 153, 153));
                    craftButton.setForeground(Color.white);
                    craftButton.addActionListener(e -> craftButtonEvent(e));
                    buttonPanel.add(craftButton, "cell 1 1");

                    //---- stealButton ----
                    stealButton.setText("Steal");
                    stealButton.setBackground(new Color(153, 153, 153));
                    stealButton.setForeground(Color.white);
                    stealButton.addActionListener(e -> stealButtonEvent(e));
                    buttonPanel.add(stealButton, "cell 0 2");

                    //---- dropButton ----
                    dropButton.setText("Drop");
                    dropButton.setBackground(new Color(153, 153, 153));
                    dropButton.setForeground(Color.white);
                    dropButton.addActionListener(e -> dropButtonEvent(e));
                    buttonPanel.add(dropButton, "cell 1 2");
                }
                rightPanel.add(buttonPanel, "cell 0 3");
            }
            mailPanel.add(rightPanel, "cell 1 0");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Porkoláb Zoltán
    private JPanel mailPanel;
    private JPanel leftPanel;
    private JPanel leftHeaderPanel;
    private JPanel neighboursLabelPanel;
    private JLabel neighboursLabel;
    private JPanel playersLabelPanel;
    private JLabel virologistsLabel;
    private JPanel fieldsPanel;
    private JComboBox<String> fieldsComboBox;
    private JPanel playersPanel;
    private JComboBox<String> playersComboBox;
    private JPanel fieldPanel;
    private JLabel fieldLabel;
    private JPanel rightPanel;
    private JPanel rightHeaderPanel;
    private JPanel vattributePanel;
    private JPanel bearModePanel;
    private JLabel bearModeLabel;
    private JPanel dancingPanel;
    private JLabel dancingLabel;
    private JPanel stunnedPanel;
    private JLabel stunnedLabel;
    private JPanel immunePanel;
    private JLabel immuneLabel;
    private JPanel playerIconPanel;
    private JLabel playerIconLabel;
    private JPanel itemsPanel;
    private JButton agentsButton;
    private JButton gearsButton;
    private JButton materialsButton;
    private JScrollPane detailsPane;
    private JTable detailTable;
    private JPanel buttonPanel;
    private JButton moveButton;
    private JButton attackButton;
    private JButton craftButton;
    private JButton stealButton;
    private JButton dropButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
