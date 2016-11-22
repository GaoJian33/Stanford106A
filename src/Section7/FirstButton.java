package Section7;

import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Michael on 11/19/2016.
 */
public class FirstButton extends GraphicsProgram {

    private JCheckBox check;
    private JRadioButton sm, med, lg;
    private JComboBox<String> pick;

    public void init() {
//        add(new JButton("Hi"), SOUTH);

        add(new JButton("Clear"), SOUTH);

        check = new JCheckBox("Front");
        check.setSelected(true);
        add(check, SOUTH);

        initRadioButtons();
        add(sm, SOUTH);
        add(med, SOUTH);
        add(lg, SOUTH);

        initComboBox();
        add(new JLabel("    Color:"), SOUTH);
        add(pick, SOUTH);

        addMouseListeners();
        addActionListeners();
    }

    private void initComboBox() {
        pick = new JComboBox<>();
        pick.addItem("Black");
        pick.addItem("Blue");
        pick.addItem("Green");
        pick.addItem("Red");
        pick.setEditable(false);
        pick.setSelectedItem("Black");
    }

    private void initRadioButtons() {
        sm = new JRadioButton("Small");
        med = new JRadioButton("Medium");
        lg = new JRadioButton("Large");
        ButtonGroup size = new ButtonGroup();
        size.add(sm);
        size.add(med);
        size.add(lg);
        med.setSelected(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("Clear")) {
            removeAll();
        }
    }

    public void mouseClicked(MouseEvent e) {
        boolean face = check.isSelected();
        boolean small = sm.isSelected();
        boolean medium = med.isSelected();
        boolean large = lg.isSelected();
    }


}
