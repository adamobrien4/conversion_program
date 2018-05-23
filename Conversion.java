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
        tf.setBounds(10, 10, 120, 20);

        JComboBox c2 = new JComboBox<>(units.toArray());
        c2.setBounds(135, 45, 100, 30);
        JLabel l = new JLabel();
        l.setBounds(10, 50, 120, 20);

        JButton b = new JButton("Convert");
        b.setBounds(135, 80, 100, 40);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                l.setText( uc.convert(units.get(c1.getSelectedIndex()), Double.valueOf(tf.getText()), units.get(c2.getSelectedIndex())) );
            }
        });

        f.add(c1);  f.add(tf);
        f.add(c2);  f.add(l);
        f.add(b);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args){
        new Conversion();
    }
}