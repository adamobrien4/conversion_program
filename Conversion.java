import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Conversion{
    ArrayList<String> units = new ArrayList<>();
    UnitConverter uc = new UnitConverter();

    public Conversion(){

        // Setup units
        units = uc.useLengthUnits();

        JFrame f = new JFrame();

        JComboBox c1 = new JComboBox<>(units.toArray());
        c1.setBounds(135, 5, 100, 30);
        JTextField tf = new JTextField();
        tf.setBounds(10, 10, 115, 20);

        JComboBox c2 = new JComboBox<>(units.toArray());
        c2.setBounds(135, 45, 100, 30);
        JLabel l = new JLabel();
        l.setBounds(10, 50, 120, 20);

        JButton b = new JButton("Convert");
        b.setBounds(135, 85, 100, 40);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                if(!tf.getText().isEmpty()){
                    l.setText( uc.convert(units.get(c1.getSelectedIndex()), Double.valueOf(tf.getText()), units.get(c2.getSelectedIndex())) );
                } else {
                    JOptionPane.showMessageDialog(f, "Please enter a value to be converted.", "Enter Value", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JButton sb = new JButton("Swap");
        sb.setBounds(10, 85, 115, 40);

        sb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Swap currently selected units
                int t = c1.getSelectedIndex();
                c1.setSelectedIndex(c2.getSelectedIndex());
                c2.setSelectedIndex(t);

                // Place value in result label into textfield
                tf.setText(l.getText());
                // Recalculate unit by simulating convert button click
                if(!tf.getText().isEmpty())
                    b.doClick();
            }
        });

        JButton eb = new JButton("Exit");
        eb.setBounds(10, 135, 225, 40);

        eb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        f.add(c1);  f.add(tf);
        f.add(c2);  f.add(l);
        f.add(b);   f.add(sb);
        f.add(eb);

        f.setSize(260, 225);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args){
        new Conversion();
    }
}