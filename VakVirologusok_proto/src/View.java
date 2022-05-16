import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun May 15 12:50:26 CEST 2022
 */

/**
 * @author Porkoláb Zoltán
 */
public class View extends JFrame {

    public boolean activePlayersturn = true;
    private Virologist currentVirologist;
    private String selectedAgent;
    private String selectedGear;
    private String stealOption;
    public View() {
        initComponents();
        initFill();
    }

    public void initFill(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailTable.getTableHeader().setBackground(new Color(76,80,82));
        detailTable.getTableHeader().setForeground(Color.white);
        agentsButton.setBackground(new Color(76,80,82));
        attackButton.setBackground(new Color(76,80,82));
        stealButton.setBackground(new Color(76,80,82));
        dropButton.setBackground(new Color(76,80,82));
        moveButton.setBackground(new Color(76,80,82));
        gearsButton.setBackground(new Color(76,80,82));
        materialsButton.setBackground(new Color(76,80,82));
        craftButton.setBackground(new Color(76,80,82));
        fieldsComboBox.setBackground(new Color(76,80,82));
        fieldsComboBox.setEditable(false);
        playersComboBox.setBackground(new Color(76,80,82));
        playersComboBox.setEditable(false);
        fieldsComboBox.setSelectedIndex(0);
        playersComboBox.setSelectedIndex(0);
        detailTable.getColumnModel().getColumn(0).setMaxWidth(60);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        detailTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        detailTable.getTableHeader().setReorderingAllowed(false);
        detailTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(detailTable.getTableHeader().getColumnModel().getColumn(1).getHeaderValue().equals("Agent")) {
                    selectedAgent = detailTable.getValueAt(detailTable.getSelectedRow(), 1).toString();
                    selectedGear = "";
                }
                else if(detailTable.getTableHeader().getColumnModel().getColumn(1).getHeaderValue().equals("Gears")) {
                    selectedGear = detailTable.getValueAt(detailTable.getSelectedRow(), 1).toString();
                    selectedAgent = "";
                }
            }
        });
        this.setBackground(new Color(60,63,65));
    }

    public void WinDialogShow(String playerColor)
    {
        JOptionPane.showMessageDialog(this,playerColor+ " won!","Game over",JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean checkVirologist(String caseString){
        switch(caseString){
            case "stunned":
                return currentVirologist.getAttributeList().stream().anyMatch(x->x instanceof Stunned);
            case "immune":
                return currentVirologist.getAttributeList().stream().anyMatch(x->x instanceof Immune);
            case "bearmode":
                return currentVirologist.getAttributeList().stream().anyMatch(x->x instanceof BearMode);
            default:
                return currentVirologist.getAttributeList().stream().anyMatch(x->x instanceof Dancing);
        }
    }

    public void DrawAll(Virologist v, HashMap<Virologist, String> playersPlaying)
    {
        currentVirologist = v;
        stealOption="";
        DrawVirologist(v, playersPlaying);
        fieldLabel.setBorder(new LineBorder(new Color(102, 102, 102)));
        DrawField(v.GetMyField());
        DrawAgent(v);
        DrawVAttribute(v);

        switch (playersPlaying.get(v)) {
            case "Blue":
                playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/blueVirologist_icon.png")));
                break;
            case "Red":
                playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/redVirologist_icon.png")));
                break;
            case "Pink":
                playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/pinkVirologist_icon.png")));
                break;
            case "Yellow":
                playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/yellowVirologist_icon.png")));
                break;
            case "Purple":
                playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/purpleVirologist_icon.png")));
                break;
            case "Cyan":
                playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/cyanVirologist_icon.png")));
                break;
            case "Green":
                playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/greenVirologist_icon.png")));
                break;
            case "Orange":
                playerIconLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Virologists/orangeVirologist_icon.png")));
                break;
        }
        detailTable.getSelectionModel().addSelectionInterval(0,0);
        detailTable.repaint();
    }

    public void DrawField(Object f)
    {
        fieldsComboBox.removeAllItems();
        fieldsComboBox.addItem("\"Select a field and press \"Move\"");

        for(int i = 0; i < currentVirologist.GetMyField().Neighbours.size(); i++) {
            fieldsComboBox.addItem("Neighbour" + String.valueOf(i+1));
        }


        if(f instanceof Warehouse){
            fieldLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Fields/Warehouse.jpg")));
        }
        else if(f instanceof Shelter){
            fieldLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Fields/Shelter.jpg")));
        }
        else if(f instanceof Laboratory){
            fieldLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Fields/Laboratory.jpg")));
            if(((Laboratory) f).getInfecting()){
                fieldLabel.setBorder(new LineBorder(Color.green));
            }
        }
        else{
            fieldLabel.setIcon(new ImageIcon(getClass().getResource("/pictures/Fields/Field.png")));
        }

    }

    public void DrawVirologist(Virologist v, HashMap<Virologist, String> playersPlaying)
    {
        playersComboBox.removeAllItems();
        playersComboBox.addItem("Select a player and press \"Attack\" or \"Steal\"");

        for(Virologist v1 : currentVirologist.GetMyField().standsHere) {
            playersComboBox.addItem(playersPlaying.get(v1));
        }
    }
    public void DrawAgent(Virologist v)
    {
        detailTable.setValueAt("", 0, 0);
        detailTable.setValueAt("", 1, 0);
        detailTable.setValueAt("", 2, 0);
        detailTable.setValueAt("", 3, 0);
        detailTable.setValueAt("", 0, 1);
        detailTable.setValueAt("", 1, 1);
        detailTable.setValueAt("", 2, 1);
        detailTable.setValueAt("", 3, 1);

        detailTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Amount");
        detailTable.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Agent");
        detailTable.getTableHeader().repaint();

        int nStun=0, nImmunity=0, nAmnesia=0, nDi=0;

        for(Agent a : v.getAgentList()) {
            if(a instanceof Stun) {
                nStun++;
            }
            else if(a instanceof Immunity) {
                nImmunity++;
            }
            else if(a instanceof Amnesia) {
                nAmnesia++;
            }
            else {
                nDi++;
            }
        }

        int counter = 0;
        int objectTypes = v.getAgentList().stream().anyMatch(x->x instanceof Stun)?1:0;
        objectTypes+=v.getAgentList().stream().anyMatch(x->x instanceof Dance)?1:0;
        objectTypes+=v.getAgentList().stream().anyMatch(x->x instanceof Immunity)?1:0;
        objectTypes+=v.getAgentList().stream().anyMatch(x->x instanceof Amnesia)?1:0;

        /*if(v.getGeneticCodeList().size() < objectTypes) {
            if(nStun != 0) {
                detailTable.setValueAt(nStun, counter, 0);
                detailTable.setValueAt(v.getGeneticCodeList().get(counter).getClass().getSimpleName(), counter++, 1);
            }
            if(nImmunity != 0) {
                detailTable.setValueAt(nImmunity, counter, 0);
                detailTable.setValueAt(v.getGeneticCodeList().get(counter).getClass().getSimpleName(), counter++, 1);
            }
            if(nAmnesia != 0) {
                detailTable.setValueAt(nAmnesia, counter, 0);
                detailTable.setValueAt(v.getGeneticCodeList().get(counter).getClass().getSimpleName(), counter++, 1);
            }
            if(nDi != 0) {
                detailTable.setValueAt(nDi, counter, 0);
                detailTable.setValueAt(v.getGeneticCodeList().get(counter).getClass().getSimpleName(), counter++, 1);
            }
            return;
        }*/
        //bool
        //while(counter<Math.max(v.getGeneticCodeList().size(),objectTypes)){
            if(v.getAgentList().stream().anyMatch(x->x instanceof Stun)||v.getGeneticCodeList().stream().anyMatch(x->x instanceof Stun)){
                detailTable.setValueAt(nStun, counter, 0);
                detailTable.setValueAt(v.getGeneticCodeList().stream().anyMatch(x->x instanceof Stun)?"Stun":"???", counter++, 1);
            }
            if(v.getAgentList().stream().anyMatch(x->x instanceof Immunity)||v.getGeneticCodeList().stream().anyMatch(x->x instanceof Immunity)){
                detailTable.setValueAt(nImmunity, counter, 0);
                detailTable.setValueAt(v.getGeneticCodeList().stream().anyMatch(x->x instanceof Immunity)?"Immunity":"???", counter++, 1);
            }
            if(v.getAgentList().stream().anyMatch(x->x instanceof Amnesia)||v.getGeneticCodeList().stream().anyMatch(x->x instanceof Amnesia)){
                detailTable.setValueAt(nAmnesia, counter, 0);
                detailTable.setValueAt(v.getGeneticCodeList().stream().anyMatch(x->x instanceof Amnesia)?"Amnesia":"???", counter++, 1);
            }
            if(v.getAgentList().stream().anyMatch(x->x instanceof Dance)||v.getGeneticCodeList().stream().anyMatch(x->x instanceof Dance)){
                detailTable.setValueAt(nDi, counter, 0);
                detailTable.setValueAt(v.getGeneticCodeList().stream().anyMatch(x->x instanceof Dance)?"Dance":"???", counter++, 1);
            }
        //}

        /*for(int i = 0; i < v.getGeneticCodeList().size(); i++) {
            detailTable.setValueAt(v.getGeneticCodeList().get(i).getClass().getSimpleName(), i, 1);
            if(v.getGeneticCodeList().get(i) instanceof Stun) {
                detailTable.setValueAt(nStun, i, 0);
            }
            else if(v.getGeneticCodeList().get(i) instanceof Immunity) {
                detailTable.setValueAt(nImmunity, i, 0);
            }
            else if(v.getGeneticCodeList().get(i) instanceof Amnesia) {
                detailTable.setValueAt(nAmnesia, i, 0);
            }
            else {
                detailTable.setValueAt(nDi, i, 0);
            }
        }*/
    }

    public void DrawVAttribute(Virologist v)
    {
        stunnedLabel.setEnabled(checkVirologist("stunned"));
        bearModeLabel.setEnabled(checkVirologist("bearmode"));
        dancingLabel.setEnabled(checkVirologist("dancing"));
        immuneLabel.setEnabled(checkVirologist("immune"));
    }

    public void DrawGear(Virologist v)
    {
        detailTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Durability");
        detailTable.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Gear");
        detailTable.getTableHeader().repaint();

        detailTable.setValueAt("", 0, 0);
        detailTable.setValueAt("", 1, 0);
        detailTable.setValueAt("", 2, 0);
        detailTable.setValueAt("", 3, 0);
        detailTable.setValueAt("", 0, 1);
        detailTable.setValueAt("", 1, 1);
        detailTable.setValueAt("", 2, 1);
        detailTable.setValueAt("", 3, 1);

        for(int i = 0; i < 4; i++) {
            if(v.getGearList()[i] != null) {
                if(v.getGearList()[i].GetDurability() == -1) {
                    detailTable.setValueAt("inf.", i, 0);
                    detailTable.setValueAt(v.getGearList()[i].getClass().getSimpleName(), i, 1);
                } else {
                    detailTable.setValueAt(String.valueOf(v.getGearList()[i].GetDurability()), i, 0);
                    detailTable.setValueAt(v.getGearList()[i].getClass().getSimpleName(), i, 1);
                }
            }
        }
    }

    public void DrawMaterial(Virologist v)
    {
        detailTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Amount");
        detailTable.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Material");
        detailTable.getTableHeader().repaint();

        detailTable.setValueAt(currentVirologist.GetAmountAminoacid() + "x", 0,0);
        detailTable.setValueAt(currentVirologist.GetAmountNucleotid() + "x", 1,0);
        detailTable.setValueAt("Aminoacid", 0,1);
        detailTable.setValueAt("Nucleotid", 1,1);
        detailTable.setValueAt("", 2,0);
        detailTable.setValueAt("", 2,1);
        detailTable.setValueAt("", 3,0);
        detailTable.setValueAt("", 3,1);
    }


    private void agentsButtonEvent(ActionEvent e) {
        DrawAgent(currentVirologist);
    }

    private void gearsButtonEvent(ActionEvent e) {
        DrawGear(currentVirologist);
        stealOption="gear";
    }

    private void materialsButtonEvent(ActionEvent e) {
        DrawMaterial(currentVirologist);
        stealOption="material";
    }

    private void moveButtonEvent(ActionEvent e) {
        if(fieldsComboBox.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this,"Please select a field first!","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        activePlayersturn = false;
        currentVirologist.Move(currentVirologist.GetMyField().Neighbours.get(fieldsComboBox.getSelectedIndex()-1));
    }

    private void attackButtonEvent(ActionEvent e) {
        if(!detailTable.getTableHeader().getColumnModel().getColumn(1).getHeaderValue().equals("Agent")){
            JOptionPane.showMessageDialog(this,"Take a look at your agents by clicking \"Agents\" button first.","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(playersComboBox.getSelectedIndex()==0 || selectedAgent.equals("")) {
            JOptionPane.showMessageDialog(this,"Please select a player and an agent first!","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(selectedAgent.equals("???")){
            JOptionPane.showMessageDialog(this,"You don't even know what is it.","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else {
            for (Agent a : currentVirologist.getAgentList()) {
                if (a.getClass().getSimpleName().equals(selectedAgent)) {
                    currentVirologist.UseAgent(a, currentVirologist.GetMyField().standsHere.get(playersComboBox.getSelectedIndex() - 1));
                    activePlayersturn = false;
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Craft one first!", "Notice", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void craftButtonEvent(ActionEvent e) {
        if(!detailTable.getTableHeader().getColumnModel().getColumn(1).getHeaderValue().equals("Agent")){
            JOptionPane.showMessageDialog(this,"Take a look at your agents by clicking \"Agents\" button first.","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(selectedAgent.equals("")){
            JOptionPane.showMessageDialog(this,"Please select an agent first!","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if (selectedAgent.equals("???")){
            JOptionPane.showMessageDialog(this,"You forgot that agent","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for(Agent a : currentVirologist.getGeneticCodeList()) {
            System.out.println(a.getClass().getSimpleName()+"=?"+selectedAgent);
            if(a.getClass().getSimpleName().equals(selectedAgent)) {
                if(a.GetAminoacidCost()>currentVirologist.GetAmountAminoacid() || a.GetNucleotidCost()>currentVirologist.GetAmountNucleotid()){
                    JOptionPane.showMessageDialog(this,"You don't have enough materials, do something else.","Notice",JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else {
                    currentVirologist.CraftAgent(currentVirologist, a);
                    break;
                }
            }
        }
        activePlayersturn = false;
    }

    private void stealButtonEvent(ActionEvent e) {
        if(playersComboBox.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this,"Please select a player first!","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(currentVirologist.GetMyField().standsHere.get(playersComboBox.getSelectedIndex()).Stunned()){
            JOptionPane.showMessageDialog(this,"This player is not stunned you can't steal anything!","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(!stealOption.equals("gear")&&!stealOption.equals("material")){
            JOptionPane.showMessageDialog(this,"Press \"Gears\" button or \"Materials\", then press \"Steal\" to be able to steal anything.","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        currentVirologist.Steal(currentVirologist.GetMyField().standsHere.get(playersComboBox.getSelectedIndex()-1), stealOption);
        activePlayersturn = false;
    }

    private void dropButtonEvent(ActionEvent e) {
        if(!detailTable.getTableHeader().getColumnModel().getColumn(1).getHeaderValue().equals("Gear")){
            JOptionPane.showMessageDialog(this,"Take a look at your gears by clicking \"Gears\" button first.","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(detailTable.getValueAt(detailTable.getSelectedRow(),1).equals("")){
            JOptionPane.showMessageDialog(this,"Pick up more items to be able to drop them.","Notice",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        currentVirologist.RemoveGear(currentVirologist.getGearList()[detailTable.getSelectedRow()]);
        activePlayersturn = false;
    }

    private void fieldsComboBoxEvent(ActionEvent e) {
        fieldsComboBox.setSelectedIndex(fieldsComboBox.getSelectedIndex());
    }

    private void playersComboBoxChanged(ActionEvent e) {
        playersComboBox.setSelectedIndex(playersComboBox.getSelectedIndex());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Porkoláb Zoltán
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

        //======== this ========
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/pictures/Virologists/turkizVirologist.png")).getImage());
        setTitle("Lost Virologists");
        setBackground(new Color(51, 51, 51));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        setMinimumSize(new Dimension(925, 570));
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,hidemode 3",
            // columns
            "[fill]" +
            "[250,fill]",
            // rows
            "[545]"));

        //======== leftPanel ========
        {
            leftPanel.setForeground(Color.black);
            leftPanel.setBorder(null);
            leftPanel.setBackground(new Color(102, 102, 102));
            leftPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
            .BOLD,12),java.awt.Color.red),leftPanel. getBorder()));leftPanel. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
            .equals(e.getPropertyName()))throw new RuntimeException();}});
            leftPanel.setLayout(new MigLayout(
                "fill,hidemode 3,align center center",
                // columns
                "[600:600]",
                // rows
                "[81]" +
                "[400,fill]"));

            //======== leftHeaderPanel ========
            {
                leftHeaderPanel.setBackground(new Color(102, 102, 102));
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
                    fieldsComboBox.setBackground(new Color(76, 80, 82));
                    fieldsComboBox.addActionListener(e -> fieldsComboBoxEvent(e));
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
                    playersComboBox.setBackground(new Color(76, 80, 82));
                    playersComboBox.addActionListener(e -> playersComboBoxChanged(e));
                    playersPanel.add(playersComboBox, BorderLayout.CENTER);
                }
                leftHeaderPanel.add(playersPanel, "cell 1 1,gapy 0");
            }
            leftPanel.add(leftHeaderPanel, "cell 0 0");

            //======== fieldPanel ========
            {
                fieldPanel.setBackground(new Color(102, 102, 102));
                fieldPanel.setBorder(null);
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
        contentPane.add(leftPanel, "cell 0 0,dock center");

        //======== rightPanel ========
        {
            rightPanel.setBackground(new Color(102, 102, 102));
            rightPanel.setBorder(null);
            rightPanel.setLayout(new MigLayout(
                "fill,hidemode 3,align center center",
                // columns
                "[250,fill]",
                // rows
                "[200]" +
                "[25]0" +
                "[120]" +
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
                        bearModeLabel.setEnabled(false);
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
                        dancingLabel.setEnabled(false);
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
                        stunnedLabel.setEnabled(false);
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
                        immuneLabel.setEnabled(false);
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
                    playerIconLabel.setIcon(null);
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
                detailTable.setBackground(new Color(153, 153, 153));
                detailTable.setForeground(Color.white);
                detailTable.setModel(new DefaultTableModel(
                    new Object[][] {
                        {"0x", "Amnesia"},
                        {"0x", "Dance"},
                        {"0x", "Immunity"},
                        {"0x", "Stun"},
                    },
                    new String[] {
                        "Amount", "Agent"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, Object.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, false
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
                {
                    TableColumnModel cm = detailTable.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(0).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "0x"
                        }))));
                    cm.getColumn(1).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "Immunity",
                            "Stun",
                            "Dance",
                            "Amnesia"
                        }))));
                }
                detailTable.setSelectionForeground(Color.white);
                detailTable.setGridColor(Color.black);
                detailTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                detailTable.setRowHeight(25);
                detailTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                detailsPane.setViewportView(detailTable);
            }
            rightPanel.add(detailsPane, "cell 0 2,dock center");

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
        contentPane.add(rightPanel, "cell 1 0,dock center");
        setSize(925, 570);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Porkoláb Zoltán
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
