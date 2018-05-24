import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Conversion{
    ArrayList<String> units = new ArrayList<>();
    UnitConverter uc = new UnitConverter();

    public Conversion(){

        JFrame f = new JFrame();

        String[] types = {
            "length", "volume"
        };

        JComboBox u = new JComboBox<>(types);
        u.setBounds(10, 10, 210, 20);

        JComboBox c1 = new JComboBox<>(uc.units.toArray());
        c1.setBounds(140, 40, 80, 20);
        JTextField tf = new JTextField();
        tf.setBounds(10, 40, 120, 20);

        JComboBox c2 = new JComboBox<>(uc.units.toArray());
        c2.setBounds(140, 70, 80, 20);
        JLabel l = new JLabel();
        l.setBounds(10, 70, 120, 20);

        JButton b = new JButton("Convert");
        b.setBounds(140, 100, 80, 30);

        JButton sb = new JButton("Swap");
        sb.setBounds(10, 100, 120, 30);

        JButton eb = new JButton("Exit");
        eb.setBounds(10, 140, 210, 30);

        u.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                switch(u.getSelectedIndex()){
                    case 0:
                        // length
                        uc.useLengthUnits();
                        break;
                    case 1:
                        // volume
                        uc.useVolumeUnits();
                        break;
                    default:
                        System.exit(0);
                }

                String[] units = new String[uc.units.size()];
                units = uc.units.toArray(units);

                c1.removeAllItems();
                c2.removeAllItems();
                for(int i = 0; i < units.length; i++ ){
                    c1.addItem(units[i]);
                    c2.addItem(units[i]);
                }
            }
        });

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                if(!tf.getText().isEmpty()){
                    l.setText( uc.convert(uc.units.get(c1.getSelectedIndex()), Double.valueOf(tf.getText()), uc.units.get(c2.getSelectedIndex())) );
                } else {
                    JOptionPane.showMessageDialog(f, "Please enter a value to be converted.", "Enter Value", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

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

        eb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        f.add(u);
        f.add(c1);  f.add(tf);
        f.add(c2);  f.add(l);
        f.add(b);   f.add(sb);
        f.add(eb);

        f.setSize(245, 215);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args){
        new Conversion();
    }
}